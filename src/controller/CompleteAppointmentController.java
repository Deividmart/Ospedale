package controller;

import model.DataStore;
import model.Doctor;

public class CompleteAppointmentController {

    private final DataStore store = DataStore.getInstance();

    // PENDING → COMPLETED
    public Response complete(Doctor doctor, String appointmentId) {
        // TODO - Día 5
        return new Response(Response.BAD_REQUEST, "Not implemented yet");
    }
}
