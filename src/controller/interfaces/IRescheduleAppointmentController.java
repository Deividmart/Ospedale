package controller.interfaces;

import controller.Response;
import model.Doctor;

public interface IRescheduleAppointmentController {
    Response reschedule(Doctor doctor, String appointmentId, String newTime, String rescheduleReason);
}
