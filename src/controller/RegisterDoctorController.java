package controller;

import model.DataStore;
import model.User;

public class RegisterDoctorController {

    private final DataStore store = DataStore.getInstance();

    // Solo el administrador puede registrar doctores
    public Response register(User requester, String id, String username, String firstname,
                             String lastname, String password, String confirmPassword,
                             String specialty, String licenceNumber, String assignedOffice) {
        // TODO - Día 4
        return new Response(Response.BAD_REQUEST, "Not implemented yet");
    }
}
