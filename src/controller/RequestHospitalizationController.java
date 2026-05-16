package controller;

import model.DataStore;
import model.Patient;

public class RequestHospitalizationController {

    private final DataStore store = DataStore.getInstance();

    public Response request(Patient patient, long doctorId, String date,
                            String reason, String roomType, String observations) {
        // TODO - Día 6
        return new Response(Response.BAD_REQUEST, "Not implemented yet");
    }
}
