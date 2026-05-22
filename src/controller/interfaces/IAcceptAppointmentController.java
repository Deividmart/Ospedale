package controller.interfaces;

import controller.Response;
import model.Doctor;

public interface IAcceptAppointmentController {
    Response accept(Doctor doctor, String appointmentId);
}
