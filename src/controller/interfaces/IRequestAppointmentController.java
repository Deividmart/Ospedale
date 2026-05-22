package controller.interfaces;

import controller.Response;
import model.Patient;

public interface IRequestAppointmentController {
    Response request(Patient patient, boolean byDoctor, String doctorOrSpecialty,
                     String date, String time, String reason, boolean type);
}
