package controller;

import model.DataStore;
import model.Patient;

public class RequestAppointmentController {

    private final DataStore store = DataStore.getInstance();

    // byDoctor=true  → doctorOrSpecialtyId es el id del doctor
    // byDoctor=false → doctorOrSpecialtyId es el nombre de la especialidad
    public Response request(Patient patient, boolean byDoctor, String doctorOrSpecialty,
                            String date, String time, String reason, boolean type) {
        // TODO - Día 5
        return new Response(Response.BAD_REQUEST, "Not implemented yet");
    }
}
