package controller;

import controller.interfaces.IUpdateDoctorController;
import model.DataStore;
import model.Doctor;
import model.Specialty;
import model.User;

public class UpdateDoctorController implements IUpdateDoctorController {

    private final DataStore store = DataStore.getInstance();

    public Response update(long doctorId, String username, String firstname, String lastname,
                           String password, String confirmPassword,
                           String specialty, String licenceNumber, String assignedOffice) {
        User user = store.findUserById(doctorId);
        if (user == null || !(user instanceof Doctor)) {
            return new Response(Response.NOT_FOUND, "Doctor not found");
        }
        Doctor doctor = (Doctor) user;

        if (username == null || username.isBlank()) {
            return new Response(Response.BAD_REQUEST, "Username is required");
        }
        User existing = store.findUserByUsername(username.trim());
        if (existing != null && existing.getId() != doctorId) {
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

        doctor.setUsername(username.trim());
        doctor.setFirstname(firstname.trim());
        doctor.setLastname(lastname.trim());
        doctor.setPassword(password);
        doctor.setSpecialty(specialtyEnum);
        doctor.setLicenceNumber(licenceNumber.trim());
        doctor.setAssignedOffice(assignedOffice.trim());
        store.notifyObservers();
        return new Response(Response.OK, "Doctor updated successfully");
    }
}
