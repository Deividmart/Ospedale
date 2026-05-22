package controller;

import model.DataStore;
import model.Doctor;
import model.Hospitalization;
import model.Patient;
import model.RoomType;
import model.User;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class RequestHospitalizationController {

    private final DataStore store = DataStore.getInstance();

    public Response request(Patient patient, long doctorId, String date,
                            String reason, String roomType, String observations) {
        User u = store.findUserById(doctorId);
        if (u == null || !(u instanceof Doctor)) {
            return new Response(Response.NOT_FOUND, "Doctor not found");
        }
        Doctor doctor = (Doctor) u;

        if (reason == null || reason.isBlank()) {
            return new Response(Response.BAD_REQUEST, "Reason is required");
        }

        LocalDate hospitalizationDate;
        try {
            hospitalizationDate = LocalDate.parse(date.trim());
        } catch (DateTimeParseException e) {
            return new Response(Response.BAD_REQUEST, "Date must be YYYY-MM-DD");
        }

        RoomType roomTypeEnum;
        try {
            roomTypeEnum = RoomType.valueOf(roomType.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            return new Response(Response.BAD_REQUEST, "Invalid room type: " + roomType);
        }

        String id = store.generateHospitalizationId(patient.getId());
        Hospitalization hospitalization = new Hospitalization(id, patient, doctor,
                hospitalizationDate, reason, roomTypeEnum, observations);
        store.addHospitalization(hospitalization);

        return new Response(Response.OK, "Hospitalization requested successfully", id);
    }
}
