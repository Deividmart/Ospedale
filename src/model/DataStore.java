package model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;
import model.interfaces.ModelObservable;
import model.interfaces.ModelObserver;
import org.json.JSONArray;
import org.json.JSONObject;

public class DataStore implements ModelObservable {

    private static DataStore instance;

    private ArrayList<User> users;
    private ArrayList<Appointment> appointments;
    private ArrayList<Hospitalization> hospitalizations;
    private ArrayList<ModelObserver> observers;

    private DataStore() {
        this.users = new ArrayList<>();
        this.appointments = new ArrayList<>();
        this.hospitalizations = new ArrayList<>();
        this.observers = new ArrayList<>();
        loadUsersFromJSON();
    }

    @Override
    public void addObserver(ModelObserver observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (ModelObserver observer : observers) {
            observer.onModelChanged();
        }
    }

    public static DataStore getInstance() {
        if (instance == null) {
            instance = new DataStore();
        }
        return instance;
    }

    // -------------------------------------------------------------------------
    // JSON Loading
    // -------------------------------------------------------------------------

    private void loadUsersFromJSON() {
        try {
            String content = new String(Files.readAllBytes(Paths.get("json/users.json")));
            JSONObject root = new JSONObject(content);
            JSONArray usersArray = root.getJSONArray("users");

            for (int i = 0; i < usersArray.length(); i++) {
                JSONObject obj = usersArray.getJSONObject(i);
                String type = obj.getString("type");

                switch (type) {
                    case "admin":
                        users.add(new Administrator(
                            obj.getLong("id"),
                            obj.getString("username"),
                            obj.getString("firstname"),
                            obj.getString("lastname"),
                            obj.getString("password")
                        ));
                        break;

                    case "patient":
                        users.add(new Patient(
                            obj.getLong("id"),
                            obj.getString("username"),
                            obj.getString("firstname"),
                            obj.getString("lastname"),
                            obj.getString("password"),
                            obj.getString("email"),
                            LocalDate.parse(obj.getString("birthdate")),
                            obj.getBoolean("gender"),
                            obj.getLong("phone"),
                            obj.getString("address")
                        ));
                        break;

                    case "doctor":
                        users.add(new Doctor(
                            obj.getLong("id"),
                            obj.getString("username"),
                            obj.getString("firstname"),
                            obj.getString("lastname"),
                            obj.getString("password"),
                            parseSpecialty(obj.getString("specialty")),
                            obj.getString("licenceNumber"),
                            obj.getString("assignedOffice")
                        ));
                        break;
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading users.json: " + e.getMessage());
        }
    }

    // Mapea los valores del JSON a los valores exactos del enum Specialty
    private Specialty parseSpecialty(String value) {
        switch (value.toUpperCase()) {
            case "CARDIOLOGY":              return Specialty.CARDIOLOGY;
            case "NEUROLOGY":               return Specialty.NEUROLOGY;
            case "PEDIATRICS":              return Specialty.PEDIATRICS;
            case "DERMATOLOGY":             return Specialty.DERMATOLOGY;
            case "ORTHOPEDICS":             return Specialty.TRAUMATOLOGY_ORTHOPEDICS;
            case "GYNECOLOGY":              return Specialty.GYNECOLOGY_OBSTETRICS;
            case "PSYCHIATRY":              return Specialty.PSYCHIATRY;
            case "ONCOLOGY":                return Specialty.ONCOLOGY;
            case "OPHTHALMOLOGY":           return Specialty.OPHTHALMOLOGY;
            case "INTERNAL_MEDICINE":       return Specialty.INTERNAL_MEDICINE;
            default:                        return Specialty.GENERAL_MEDICINE;
        }
    }

    // -------------------------------------------------------------------------
    // ID generation for Appointments and Hospitalizations
    // -------------------------------------------------------------------------

    public String generateAppointmentId(long patientId) {
        long count = appointments.stream()
                .filter(a -> a.getPatient().getId() == patientId)
                .count();
        return String.format("A-%d-%04d", patientId, count);
    }

    public String generateHospitalizationId(long patientId) {
        long count = hospitalizations.stream()
                .filter(h -> h.getPatient().getId() == patientId)
                .count();
        return String.format("H-%d-%04d", patientId, count);
    }

    // -------------------------------------------------------------------------
    // Users
    // -------------------------------------------------------------------------

    public ArrayList<User> getUsers()       { return users; }

    public User findUserById(long id) {
        return users.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
    }

    public User findUserByUsername(String username) {
        return users.stream().filter(u -> u.getUsername().equals(username)).findFirst().orElse(null);
    }

    public boolean isUsernameTaken(String username) {
        return users.stream().anyMatch(u -> u.getUsername().equals(username));
    }

    public boolean isIdTaken(long id) {
        return users.stream().anyMatch(u -> u.getId() == id);
    }

    public void addUser(User user) {
        users.add(user);
        notifyObservers();
    }

    // -------------------------------------------------------------------------
    // Appointments
    // -------------------------------------------------------------------------

    public ArrayList<Appointment> getAppointments()  { return appointments; }

    public Appointment findAppointmentById(String id) {
        return appointments.stream().filter(a -> a.getId().equals(id)).findFirst().orElse(null);
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
        appointment.getPatient().addAppointment(appointment);
        appointment.getDoctor().addAppointment(appointment);
        notifyObservers();
    }

    // -------------------------------------------------------------------------
    // Hospitalizations
    // -------------------------------------------------------------------------

    public ArrayList<Hospitalization> getHospitalizations() { return hospitalizations; }

    public Hospitalization findHospitalizationById(String id) {
        return hospitalizations.stream().filter(h -> h.getId().equals(id)).findFirst().orElse(null);
    }

    public void addHospitalization(Hospitalization hospitalization) {
        hospitalizations.add(hospitalization);
        hospitalization.getPatient().setHospitalization(hospitalization);
        hospitalization.getDoctor().addHospitalization(hospitalization);
        notifyObservers();
    }

    // -------------------------------------------------------------------------
    // Typed queries — used by controllers
    // -------------------------------------------------------------------------

    public ArrayList<Patient> getPatients() {
        return users.stream()
                .filter(u -> u instanceof Patient)
                .map(u -> (Patient) u)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Doctor> getDoctors() {
        return users.stream()
                .filter(u -> u instanceof Doctor)
                .map(u -> (Doctor) u)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Doctor> findDoctorsBySpecialty(Specialty specialty) {
        return getDoctors().stream()
                .filter(d -> d.getSpecialty() == specialty)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    // Returns true if the doctor has no REQUESTED or PENDING appointment within 30 minutes of datetime
    public boolean isDoctorAvailableAt(Doctor doctor, LocalDateTime datetime) {
        return doctor.getAppointments().stream()
                .filter(a -> a.getStatus() == AppointmentStatus.REQUESTED
                          || a.getStatus() == AppointmentStatus.PENDING)
                .noneMatch(a -> Math.abs(java.time.Duration.between(a.getDatetime(), datetime).toMinutes()) < 15);
    }

    public ArrayList<Appointment> getPatientAppointmentsSorted(Patient patient) {
        return patient.getAppointments().stream()
                .sorted(Comparator.comparing(Appointment::getDatetime).reversed())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Appointment> getDoctorAppointmentsSorted(Doctor doctor, boolean pendingOnly) {
        return doctor.getAppointments().stream()
                .filter(a -> !pendingOnly || a.getStatus() == AppointmentStatus.PENDING)
                .sorted(Comparator.comparing(Appointment::getDatetime).reversed())
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
