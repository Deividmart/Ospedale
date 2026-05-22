package controller.interfaces;

import controller.Response;

public interface IUpdatePatientController {
    Response update(long patientId, String username, String firstname, String lastname,
                    String password, String confirmPassword, String email,
                    String birthdate, String gender, String phone, String address);
}
