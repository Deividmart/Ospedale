package controller;

import controller.interfaces.IRegisterDoctorController;
import model.Administrator;
import model.DataStore;
import model.Doctor;
import model.Specialty;
import model.User;

public class RegisterDoctorController implements IRegisterDoctorController {

    private final DataStore store = DataStore.getInstance();

    public Response register(User requester, String id, String username, String firstname,
                             String lastname, String password, String confirmPassword,
                             String specialty, String licenceNumber, String assignedOffice) {
        if (!(requester instanceof Administrator)) {
            return new Response(Response.BAD_REQUEST, "Only administrators can register doctors");
        }

        long doctorId;
        try {
            doctorId = Long.parseLong(id.trim());
        } catch (NumberFormatException e) {
            return new Response(Response.BAD_REQUEST, "ID must be a number");
        }
        if (String.valueOf(doctorId).length() != 12 || doctorId <= 0) {
            return new Response(Response.BAD_REQUEST, "ID must be exactly 12 digits and greater than 0");
        }
        if (store.isIdTaken(doctorId)) {
            return new Response(Response.BAD_REQUEST, "ID already exists");
        }

        if (username == null || username.isBlank()) {
            return new Response(Response.BAD_REQUEST, "Username is required");
        }
        if (store.isUsernameTaken(username.trim())) {
            return new Response(Response.BAD_REQUEST, "Username already taken");
        }

        if (firstname == null || firstname.isBlank()) {
            return new Response(Response.BAD_REQUEST, "First name is required");
        }
        if (lastname == null || lastname.isBlank()) {
            return new Response(Response.BAD_REQUEST, "Last name is required");
        }

        if (password == null || password.isBlank()) {
            return new Response(Response.BAD_REQUEST, "Password is required");
        }
        if (!password.equals(confirmPassword)) {
            return new Response(Response.BAD_REQUEST, "Passwords do not match");
        }

        if (licenceNumber == null || !licenceNumber.trim().matches("L-\\d{10} MTL")) {
            return new Response(Response.BAD_REQUEST, "License must be in format L-XXXXXXXXXX MTL");
        }

        if (assignedOffice == null || !assignedOffice.trim().matches("O-\\d{3}")) {
            return new Response(Response.BAD_REQUEST, "Office must be in format O-XXX");
        }

        Specialty specialtyEnum;
        try {
            specialtyEnum = Specialty.valueOf(specialty.trim().toUpperCase()
                    .replace(" & ", "_").replace(" ", "_"));
        } catch (IllegalArgumentException e) {
            return new Response(Response.BAD_REQUEST, "Invalid specialty: " + specialty);
        }

        Doctor doctor = new Doctor(doctorId, username.trim(), firstname.trim(), lastname.trim(),
                password, specialtyEnum, licenceNumber.trim(), assignedOffice.trim());
        store.addUser(doctor);

        return new Response(Response.OK, "Doctor registered successfully");
    }
}
