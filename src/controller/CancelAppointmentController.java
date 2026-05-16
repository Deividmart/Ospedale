package controller;

import model.DataStore;
import model.Patient;

public class CancelAppointmentController {

    private final DataStore store = DataStore.getInstance();

    // El paciente cancela — cualquier estado excepto COMPLETED → CANCELED
    public Response cancel(Patient patient, String appointmentId) {
        // TODO - Día 5
        return new Response(Response.BAD_REQUEST, "Not implemented yet");
    }
}
