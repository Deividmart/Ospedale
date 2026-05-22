package controller;

import controller.interfaces.IGetDataController;
import model.Administrator;
import model.Appointment;
import model.DataStore;
import model.Doctor;
import model.Hospitalization;
import model.Patient;
import model.User;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class GetDataController implements IGetDataController {

    private final DataStore store = DataStore.getInstance();

    public Response getPatientAppointments(Patient patient) {
        ArrayList<Appointment> sorted = store.getPatientAppointmentsSorted(patient);
        ArrayList<Map<String, Object>> data = new ArrayList<>();
        for (Appointment a : sorted) {
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("id", a.getId());
            map.put("doctor", a.getDoctor().getFirstname() + " " + a.getDoctor().getLastname());
            map.put("specialty", a.getSpecialty().name());
            map.put("datetime", a.getDatetime().toString());
            map.put("type", a.isType() ? "In-person" : "Remote");
            map.put("reason", a.getReason());
            map.put("status", a.getStatus().name());
            data.add(map);
        }
        return new Response(Response.OK, "Appointments retrieved", data);
    }

    public Response getDoctorAppointments(Doctor doctor, boolean pendingOnly) {
        ArrayList<Appointment> sorted = store.getDoctorAppointmentsSorted(doctor, pendingOnly);
        ArrayList<Map<String, Object>> data = new ArrayList<>();
        for (Appointment a : sorted) {
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("id", a.getId());
            map.put("patient", a.getPatient().getFirstname() + " " + a.getPatient().getLastname());
            map.put("specialty", a.getSpecialty().name());
            map.put("datetime", a.getDatetime().toString());
            map.put("type", a.isType() ? "In-person" : "Remote");
            map.put("reason", a.getReason());
            map.put("status", a.getStatus().name());
            data.add(map);
        }
        return new Response(Response.OK, "Appointments retrieved", data);
    }

    public Response getAllUsers() {
        ArrayList<Map<String, Object>> data = new ArrayList<>();
        for (User u : store.getUsers()) {
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("id", String.valueOf(u.getId()));
            map.put("username", u.getUsername());
            map.put("firstname", u.getFirstname());
            map.put("lastname", u.getLastname());
            if (u instanceof Administrator) {
                map.put("type", "Admin");
            } else if (u instanceof Doctor) {
                Doctor d = (Doctor) u;
                map.put("type", "Doctor");
                map.put("specialty", d.getSpecialty().name());
                map.put("licenceNumber", d.getLicenceNumber());
                map.put("assignedOffice", d.getAssignedOffice());
            } else if (u instanceof Patient) {
                Patient p = (Patient) u;
                map.put("type", "Patient");
                map.put("email", p.getEmail());
                map.put("phone", String.valueOf(p.getPhone()));
                map.put("birthdate", p.getBirthdate().toString());
            }
            data.add(map);
        }
        return new Response(Response.OK, "Users retrieved", data);
    }

    public Response getAllHospitalizations() {
        ArrayList<Map<String, Object>> data = new ArrayList<>();
        for (Hospitalization h : store.getHospitalizations()) {
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("id", h.getId());
            map.put("patient", h.getPatient().getFirstname() + " " + h.getPatient().getLastname());
            map.put("doctor", h.getDoctor().getFirstname() + " " + h.getDoctor().getLastname());
            map.put("date", h.getDate().toString());
            map.put("reason", h.getReason());
            map.put("roomType", h.getRoomType().name());
            map.put("status", h.getStatus().name());
            data.add(map);
        }
        return new Response(Response.OK, "Hospitalizations retrieved", data);
    }
}
