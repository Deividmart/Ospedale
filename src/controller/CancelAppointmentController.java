package controller;

import model.Appointment;
import model.AppointmentStatus;
import model.DataStore;
import model.Patient;

public class CancelAppointmentController {

    private final DataStore store = DataStore.getInstance();

    public Response cancel(Patient patient, String appointmentId) {
        Appointment appointment = store.findAppointmentById(appointmentId);
        if (appointment == null) {
            return new Response(Response.NOT_FOUND, "Appointment not found");
        }
        if (appointment.getPatient().getId() != patient.getId()) {
            return new Response(Response.BAD_REQUEST, "This appointment does not belong to the given patient");
        }
        if (appointment.getStatus() == AppointmentStatus.COMPLETED) {
            return new Response(Response.BAD_REQUEST, "Cannot cancel a completed appointment");
        }
        if (appointment.getStatus() == AppointmentStatus.CANCELED) {
            return new Response(Response.BAD_REQUEST, "Appointment is already canceled");
        }
        appointment.setStatus(AppointmentStatus.CANCELED);
        return new Response(Response.OK, "Appointment canceled");
    }
}
