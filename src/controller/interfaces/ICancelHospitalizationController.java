package controller.interfaces;

import controller.Response;
import model.Doctor;

public interface ICancelHospitalizationController {
    Response cancel(Doctor doctor, String hospitalizationId);
}
