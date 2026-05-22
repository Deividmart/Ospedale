package controller;

import model.Appointment;
import model.AppointmentStatus;
import model.DataStore;
import model.Doctor;

public class CompleteAppointmentController {

    private final DataStore store = DataStore.getInstance();

    public Response complete(Doctor doctor, String appointmentId) {
        Appointment appointment = store.findAppointmentById(appointmentId);
        if (appointment == null) {
            return new Response(Response.NOT_FOUND, "Appointment not found");
        }
        if (appointment.getDoctor().getId() != doctor.getId()) {
            return new Response(Response.BAD_REQUEST, "This appointment does not belong to the given doctor");
        }
        if (appointment.getStatus() != AppointmentStatus.PENDING) {
            return new Response(Response.BAD_REQUEST,
                    "Appointment must be PENDING to complete (current: " + appointment.getStatus() + ")");
        }
        appointment.setStatus(AppointmentStatus.COMPLETED);
        return new Response(Response.OK, "Appointment completed");
    }
}
