package controller;

import controller.interfaces.IRegisterPatientController;
import model.DataStore;
import model.Patient;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class RegisterPatientController implements IRegisterPatientController {

    private final DataStore store = DataStore.getInstance();

    public Response register(String id, String username, String firstname, String lastname,
                             String password, String confirmPassword, String email,
                             String birthdate, String gender, String phone, String address) {
        long patientId;
        try {
            patientId = Long.parseLong(id.trim());
        } catch (NumberFormatException e) {
            return new Response(Response.BAD_REQUEST, "ID must be a number");
        }
        if (String.valueOf(patientId).length() != 12 || patientId <= 0) {
            return new Response(Response.BAD_REQUEST, "ID must be exactly 12 digits and greater than 0");
        }
        if (store.isIdTaken(patientId)) {
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

        long phoneNum;
        try {
            phoneNum = Long.parseLong(phone.trim());
        } catch (NumberFormatException e) {
            return new Response(Response.BAD_REQUEST, "Phone must be a number");
        }
        if (String.valueOf(phoneNum).length() != 10) {
            return new Response(Response.BAD_REQUEST, "Phone must be exactly 10 digits");
        }

        if (email == null || !email.trim().matches("[^@\\s]+@[^@\\s]+\\.com")) {
            return new Response(Response.BAD_REQUEST, "Invalid email format (must be XXXXX@XXXXX.com)");
        }

        LocalDate birthdateDate;
        try {
            birthdateDate = LocalDate.parse(birthdate.trim());
        } catch (DateTimeParseException e) {
            return new Response(Response.BAD_REQUEST, "Birthdate must be YYYY-MM-DD");
        }

        boolean genderBool = "Male".equalsIgnoreCase(gender) || "true".equalsIgnoreCase(gender);

        Patient patient = new Patient(patientId, username.trim(), firstname.trim(), lastname.trim(),
                password, email.trim(), birthdateDate, genderBool, phoneNum, address);
        store.addUser(patient);

        return new Response(Response.OK, "Patient registered successfully");
    }
}
