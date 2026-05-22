package controller.interfaces;

import controller.Response;

public interface IRegisterPatientController {
    Response register(String id, String username, String firstname, String lastname,
                      String password, String confirmPassword, String email,
                      String birthdate, String gender, String phone, String address);
}
