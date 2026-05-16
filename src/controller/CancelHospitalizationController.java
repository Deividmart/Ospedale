package controller;

import model.DataStore;
import model.Doctor;

public class CancelHospitalizationController {

    private final DataStore store = DataStore.getInstance();

    // El doctor deniega — REQUESTED → CANCELED
    public Response cancel(Doctor doctor, String hospitalizationId) {
        // TODO - Día 6
        return new Response(Response.BAD_REQUEST, "Not implemented yet");
    }
}
