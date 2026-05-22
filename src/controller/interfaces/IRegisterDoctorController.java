package controller.interfaces;

import controller.Response;
import model.User;

public interface IRegisterDoctorController {
    Response register(User requester, String id, String username, String firstname,
                      String lastname, String password, String confirmPassword,
                      String specialty, String licenceNumber, String assignedOffice);
}
