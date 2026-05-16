package controller;

import model.DataStore;
import model.Doctor;

public class AcceptHospitalizationController {

    private final DataStore store = DataStore.getInstance();

    // REQUESTED → ONGOING
    public Response accept(Doctor doctor, String hospitalizationId) {
        // TODO - Día 6
        return new Response(Response.BAD_REQUEST, "Not implemented yet");
    }
}
