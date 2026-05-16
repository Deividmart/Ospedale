package controller;

import model.DataStore;

public class UpdateDoctorController {

    private final DataStore store = DataStore.getInstance();

    // Mismas validaciones que el registro; id NO puede modificarse
    public Response update(long doctorId, String username, String firstname, String lastname,
                           String password, String confirmPassword,
                           String specialty, String licenceNumber, String assignedOffice) {
        // TODO - Día 4
        return new Response(Response.BAD_REQUEST, "Not implemented yet");
    }
}
