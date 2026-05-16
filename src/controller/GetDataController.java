package controller;

import model.DataStore;
import model.Doctor;
import model.Patient;

public class GetDataController {

    private final DataStore store = DataStore.getInstance();

    // Citas del paciente ordenadas descendentemente por fecha y hora
    public Response getPatientAppointments(Patient patient) {
        // TODO - Día 6
        return new Response(Response.BAD_REQUEST, "Not implemented yet");
    }

    // Citas del doctor; pendingOnly=true → solo PENDING; ordenadas desc
    public Response getDoctorAppointments(Doctor doctor, boolean pendingOnly) {
        // TODO - Día 6
        return new Response(Response.BAD_REQUEST, "Not implemented yet");
    }

    public Response getAllUsers() {
        // TODO - Día 6
        return new Response(Response.BAD_REQUEST, "Not implemented yet");
    }

    public Response getAllHospitalizations() {
        // TODO - Día 6
        return new Response(Response.BAD_REQUEST, "Not implemented yet");
    }
}
