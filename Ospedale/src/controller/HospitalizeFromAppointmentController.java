package controller;

import model.Appointment;
import model.AppointmentStatus;
import model.DataStore;
import model.Doctor;
import model.Hospitalization;
import model.HospitalizationStatus;
import model.RoomType;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class HospitalizeFromAppointmentController {

    private final DataStore store = DataStore.getInstance();

    public Response hospitalize(Doctor doctor, String appointmentId,
                                String date, String reason, String roomType, String observations) {
        Appointment appointment = store.findAppointmentById(appointmentId);
        if (appointment == null) {
            return new Response(Response.NOT_FOUND, "Appointment not found");
        }
        if (appointment.getDoctor().getId() != doctor.getId()) {
            return new Response(Response.BAD_REQUEST, "This appointment does not belong to the given doctor");
        }
        if (appointment.getStatus() != AppointmentStatus.PENDING) {
            return new Response(Response.BAD_REQUEST,
                    "Appointment must be PENDING to hospitalize (current: " + appointment.getStatus() + ")");
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

        appointment.setStatus(AppointmentStatus.COMPLETED);

        String hospId = store.generateHospitalizationId(appointment.getPatient().getId());
        Hospitalization hospitalization = new Hospitalization(hospId, appointment.getPatient(), doctor,
                hospitalizationDate, reason, roomTypeEnum, observations);
        hospitalization.setStatus(HospitalizationStatus.ONGOING);
        store.addHospitalization(hospitalization);

        return new Response(Response.OK, "Patient hospitalized successfully", hospId);
    }
}
