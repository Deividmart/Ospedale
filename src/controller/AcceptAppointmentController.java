package controller;

import model.DataStore;
import model.Doctor;

public class AcceptAppointmentController {

    private final DataStore store = DataStore.getInstance();

    // REQUESTED → PENDING
    public Response accept(Doctor doctor, String appointmentId) {
        // TODO - Día 5
        return new Response(Response.BAD_REQUEST, "Not implemented yet");
    }
}
