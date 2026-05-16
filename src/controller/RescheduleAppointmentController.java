package controller;

import model.DataStore;
import model.Doctor;

public class RescheduleAppointmentController {

    private final DataStore store = DataStore.getInstance();

    // Nueva hora misma fecha; razón se anexa a la razón original
    public Response reschedule(Doctor doctor, String appointmentId, String newTime, String rescheduleReason) {
        // TODO - Día 5
        return new Response(Response.BAD_REQUEST, "Not implemented yet");
    }
}
