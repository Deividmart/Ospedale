package controller.interfaces;

import controller.Response;
import model.Patient;

public interface IRequestHospitalizationController {
    Response request(Patient patient, long doctorId, String date,
                     String reason, String roomType, String observations);
}
