package controller.interfaces;

import controller.Response;
import model.Doctor;

public interface IHospitalizeFromAppointmentController {
    Response hospitalize(Doctor doctor, String appointmentId,
                         String date, String reason, String roomType, String observations);
}
