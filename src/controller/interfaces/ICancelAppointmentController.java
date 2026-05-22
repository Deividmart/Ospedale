package controller.interfaces;

import controller.Response;
import model.Patient;

public interface ICancelAppointmentController {
    Response cancel(Patient patient, String appointmentId);
}
