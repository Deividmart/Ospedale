package controller.interfaces;

import controller.Response;

public interface ILoginController {
    Response login(String username, String password);
}
