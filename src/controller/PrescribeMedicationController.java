package controller;

import controller.interfaces.IPrescribeMedicationController;
import model.Appointment;
import model.AppointmentStatus;
import model.DataStore;
import model.Doctor;
import model.Prescription;

public class PrescribeMedicationController implements IPrescribeMedicationController {

    private final DataStore store = DataStore.getInstance();

    public Response prescribe(Doctor doctor, String appointmentId, String medicationName,
                              double dose, String administrationRoute,
                              int treatmentDuration, String additionalInstructions, int frequency) {
        Appointment appointment = store.findAppointmentById(appointmentId);
        if (appointment == null) {
            return new Response(Response.NOT_FOUND, "Appointment not found");
        }
        if (appointment.getDoctor().getId() != doctor.getId()) {
            return new Response(Response.BAD_REQUEST, "This appointment does not belong to the given doctor");
        }
        if (appointment.getStatus() != AppointmentStatus.PENDING) {
            return new Response(Response.BAD_REQUEST,
                    "Medications can only be prescribed for PENDING appointments (current: "
                    + appointment.getStatus() + ")");
        }
        if (medicationName == null || medicationName.isBlank()) {
            return new Response(Response.BAD_REQUEST, "Medication name is required");
        }
        if (dose <= 0) {
            return new Response(Response.BAD_REQUEST, "Dose must be greater than 0");
        }

        Prescription prescription = new Prescription(appointment, medicationName, dose,
                administrationRoute, treatmentDuration, additionalInstructions, frequency);
        appointment.addPrescription(prescription);
        store.notifyObservers();
        return new Response(Response.OK, "Medication prescribed successfully");
    }
}
