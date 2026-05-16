package controller;

import model.DataStore;

public class UpdatePatientController {

    private final DataStore store = DataStore.getInstance();

    // Mismas validaciones que el registro; id NO puede modificarse
    public Response update(long patientId, String username, String firstname, String lastname,
                           String password, String confirmPassword, String email,
                           String birthdate, String gender, String phone, String address) {
        // TODO - Día 4
        return new Response(Response.BAD_REQUEST, "Not implemented yet");
    }
}
