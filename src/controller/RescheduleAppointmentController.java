package controller;

import controller.interfaces.IRescheduleAppointmentController;
import model.Appointment;
import model.AppointmentStatus;
import model.DataStore;
import model.Doctor;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class RescheduleAppointmentController implements IRescheduleAppointmentController {

    private final DataStore store = DataStore.getInstance();

    public Response reschedule(Doctor doctor, String appointmentId, String newTime, String rescheduleReason) {
        Appointment appointment = store.findAppointmentById(appointmentId);
        if (appointment == null) {
            return new Response(Response.NOT_FOUND, "Appointment not found");
        }
        if (appointment.getDoctor().getId() != doctor.getId()) {
            return new Response(Response.BAD_REQUEST, "This appointment does not belong to the given doctor");
        }
        if (appointment.getStatus() == AppointmentStatus.COMPLETED
                || appointment.getStatus() == AppointmentStatus.CANCELED) {
            return new Response(Response.BAD_REQUEST, "Cannot reschedule a completed or canceled appointment");
        }

        LocalTime time;
        try {
            time = LocalTime.parse(newTime.trim());
        } catch (DateTimeParseException e) {
            return new Response(Response.BAD_REQUEST, "Time must be HH:mm format");
        }
        int minutes = time.getMinute();
        if (minutes != 0 && minutes != 15 && minutes != 30 && minutes != 45) {
            return new Response(Response.BAD_REQUEST, "Minutes must be 00, 15, 30, or 45");
        }

        LocalDateTime newDatetime = LocalDateTime.of(appointment.getDatetime().toLocalDate(), time);

        boolean available = doctor.getAppointments().stream()
                .filter(a -> !a.getId().equals(appointmentId))
                .filter(a -> a.getStatus() == AppointmentStatus.REQUESTED
                          || a.getStatus() == AppointmentStatus.PENDING)
                .noneMatch(a -> Math.abs(Duration.between(a.getDatetime(), newDatetime).toMinutes()) < 30);

        if (!available) {
            return new Response(Response.BAD_REQUEST, "Doctor is not available at the new time");
        }

        appointment.setDatetime(newDatetime);
        appointment.setReason(appointment.getReason() + " | Rescheduled: " + rescheduleReason);
        store.notifyObservers();
        return new Response(Response.OK, "Appointment rescheduled successfully");
    }
}
