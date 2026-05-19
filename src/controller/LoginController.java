package controller;

import model.Administrator;
import model.DataStore;
import model.Doctor;
import model.User;
import java.util.LinkedHashMap;
import java.util.Map;

public class LoginController {

    private final DataStore store = DataStore.getInstance();

    public Response login(String username, String password) {
        if (username == null || username.isBlank() || password == null || password.isBlank()) {
            return new Response(Response.BAD_REQUEST, "Username and password are required");
        }

        User user = store.findUserByUsername(username.trim());
        if (user == null) {
            return new Response(Response.NOT_FOUND, "User not found");
        }

        if (!user.getPassword().equals(password)) {
            return new Response(Response.BAD_REQUEST, "Incorrect password");
        }

        String userType;
        if (user instanceof Administrator) {
            userType = "admin";
        } else if (user instanceof Doctor) {
            userType = "doctor";
        } else {
            userType = "patient";
        }

        Map<String, Object> data = new LinkedHashMap<>();
        data.put("userId", user.getId());
        data.put("username", user.getUsername());
        data.put("firstname", user.getFirstname());
        data.put("lastname", user.getLastname());
        data.put("userType", userType);

        return new Response(Response.OK, "Login successful", data);
    }
}
