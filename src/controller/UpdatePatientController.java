package controller;

import controller.interfaces.IUpdatePatientController;
import model.DataStore;
import model.Patient;
import model.User;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class UpdatePatientController implements IUpdatePatientController {

    private final DataStore store = DataStore.getInstance();

    public Response update(long patientId, String username, String firstname, String lastname,
                           String password, String confirmPassword, String email,
                           String birthdate, String gender, String phone, String address) {
        User user = store.findUserById(patientId);
        if (user == null || !(user instanceof Patient)) {
            return new Response(Response.NOT_FOUND, "Patient not found");
        }
        Patient patient = (Patient) user;

        if (username == null || username.isBlank()) {
            return new Response(Response.BAD_REQUEST, "Username is required");
        }
        User existing = store.findUserByUsername(username.trim());
        if (existing != null && existing.getId() != patientId) {
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

        patient.setUsername(username.trim());
        patient.setFirstname(firstname.trim());
        patient.setLastname(lastname.trim());
        patient.setPassword(password);
        patient.setEmail(email.trim());
        patient.setBirthdate(birthdateDate);
        patient.setGender(genderBool);
        patient.setPhone(phoneNum);
        patient.setAddress(address);
        store.notifyObservers();
        return new Response(Response.OK, "Patient updated successfully");
    }
}
