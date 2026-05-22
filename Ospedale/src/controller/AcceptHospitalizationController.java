package controller;

import model.DataStore;
import model.Doctor;
import model.Hospitalization;
import model.HospitalizationStatus;

public class AcceptHospitalizationController {

    private final DataStore store = DataStore.getInstance();

    public Response accept(Doctor doctor, String hospitalizationId) {
        Hospitalization hospitalization = store.findHospitalizationById(hospitalizationId);
        if (hospitalization == null) {
            return new Response(Response.NOT_FOUND, "Hospitalization not found");
        }
        if (hospitalization.getDoctor().getId() != doctor.getId()) {
            return new Response(Response.BAD_REQUEST, "This hospitalization does not belong to the given doctor");
        }
        if (hospitalization.getStatus() != HospitalizationStatus.REQUESTED) {
            return new Response(Response.BAD_REQUEST,
                    "Hospitalization must be REQUESTED to accept (current: " + hospitalization.getStatus() + ")");
        }
        hospitalization.setStatus(HospitalizationStatus.ONGOING);
        return new Response(Response.OK, "Hospitalization accepted");
    }
}
