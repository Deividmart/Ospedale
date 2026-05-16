package controller;

import model.DataStore;
import model.Doctor;

public class PrescribeMedicationController {

    private final DataStore store = DataStore.getInstance();

    // Solo si la cita está en PENDING
    public Response prescribe(Doctor doctor, String appointmentId, String medicationName,
                              double dose, String administrationRoute,
                              int treatmentDuration, String additionalInstructions, int frequency) {
        // TODO - Día 5
        return new Response(Response.BAD_REQUEST, "Not implemented yet");
    }
}
