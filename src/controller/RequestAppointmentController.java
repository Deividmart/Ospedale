package controller;

import controller.interfaces.IRequestAppointmentController;
import model.Appointment;
import model.DataStore;
import model.Doctor;
import model.Patient;
import model.Specialty;
import model.User;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class RequestAppointmentController implements IRequestAppointmentController {

    private final DataStore store = DataStore.getInstance();

    public Response request(Patient patient, boolean byDoctor, String doctorOrSpecialty,
                            String date, String time, String reason, boolean type) {
        LocalDate appointmentDate;
        try {
            appointmentDate = LocalDate.parse(date.trim());
        } catch (DateTimeParseException e) {
            return new Response(Response.BAD_REQUEST, "Date must be YYYY-MM-DD");
        }

        LocalTime appointmentTime;
        try {
            appointmentTime = LocalTime.parse(time.trim());
        } catch (DateTimeParseException e) {
            return new Response(Response.BAD_REQUEST, "Time must be HH:mm format");
        }
        int minutes = appointmentTime.getMinute();
        if (minutes != 0 && minutes != 15 && minutes != 30 && minutes != 45) {
            return new Response(Response.BAD_REQUEST, "Minutes must be 00, 15, 30, or 45");
        }

        LocalDateTime datetime = LocalDateTime.of(appointmentDate, appointmentTime);

        Doctor doctor;
        if (byDoctor) {
            long doctorId;
            try {
                doctorId = Long.parseLong(doctorOrSpecialty.trim());
            } catch (NumberFormatException e) {
                return new Response(Response.BAD_REQUEST, "Invalid doctor ID");
            }
            User u = store.findUserById(doctorId);
            if (u == null || !(u instanceof Doctor)) {
                return new Response(Response.NOT_FOUND, "Doctor not found");
            }
            doctor = (Doctor) u;
            if (!store.isDoctorAvailableAt(doctor, datetime)) {
                return new Response(Response.BAD_REQUEST, "Doctor is not available at the requested time");
            }
        } else {
            Specialty specialty;
            try {
                specialty = Specialty.valueOf(doctorOrSpecialty.trim().toUpperCase()
                        .replace(" & ", "_").replace(" ", "_"));
            } catch (IllegalArgumentException e) {
                return new Response(Response.BAD_REQUEST, "Invalid specialty: " + doctorOrSpecialty);
            }
            ArrayList<Doctor> doctors = store.findDoctorsBySpecialty(specialty);
            doctor = doctors.stream()
                    .filter(d -> store.isDoctorAvailableAt(d, datetime))
                    .findFirst().orElse(null);
            if (doctor == null) {
                return new Response(Response.NOT_FOUND,
                        "No available doctor for specialty " + specialty + " at that time");
            }
        }

        String id = store.generateAppointmentId(patient.getId());
        Appointment appointment = new Appointment(id, patient, doctor,
                doctor.getSpecialty(), datetime, reason, type);
        store.addAppointment(appointment);

        return new Response(Response.OK, "Appointment requested successfully", id);
    }
}
