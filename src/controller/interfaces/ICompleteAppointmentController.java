package controller.interfaces;

import controller.Response;
import model.Doctor;

public interface ICompleteAppointmentController {
    Response complete(Doctor doctor, String appointmentId);
}
