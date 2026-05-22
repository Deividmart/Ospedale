package controller.interfaces;

import controller.Response;
import model.Doctor;

public interface IAcceptHospitalizationController {
    Response accept(Doctor doctor, String hospitalizationId);
}
