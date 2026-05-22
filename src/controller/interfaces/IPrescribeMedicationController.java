package controller.interfaces;

import controller.Response;
import model.Doctor;

public interface IPrescribeMedicationController {
    Response prescribe(Doctor doctor, String appointmentId, String medicationName,
                       double dose, String administrationRoute,
                       int treatmentDuration, String additionalInstructions, int frequency);
}
