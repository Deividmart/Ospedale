package controller;

import model.DataStore;

public class RegisterPatientController {

    private final DataStore store = DataStore.getInstance();

    public Response register(String id, String username, String firstname, String lastname,
                             String password, String confirmPassword, String email,
                             String birthdate, String gender, String phone, String address) {
        // TODO - Día 4
        return new Response(Response.BAD_REQUEST, "Not implemented yet");
    }
}
