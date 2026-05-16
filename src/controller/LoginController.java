package controller;

import model.DataStore;
import model.User;

public class LoginController {

    private final DataStore store = DataStore.getInstance();

    public Response login(String username, String password) {
        // TODO - Día 4
        return new Response(Response.BAD_REQUEST, "Not implemented yet");
    }
}
