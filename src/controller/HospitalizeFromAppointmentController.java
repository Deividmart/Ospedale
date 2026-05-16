package controller;

import model.DataStore;
import model.Doctor;

public class HospitalizeFromAppointmentController {

    private final DataStore store = DataStore.getInstance();

    // Cita → COMPLETED; hospitalización inicia en ONGOING directamente
    public Response hospitalize(Doctor doctor, String appointmentId,
                                String date, String reason, String roomType, String observations) {
        // TODO - Día 6
        return new Response(Response.BAD_REQUEST, "Not implemented yet");
    }
}
