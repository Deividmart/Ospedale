package controller.interfaces;

import controller.Response;
import model.Doctor;
import model.Patient;

public interface IGetDataController {
    Response getPatientAppointments(Patient patient);
    Response getDoctorAppointments(Doctor doctor, boolean pendingOnly);
    Response getAllUsers();
    Response getAllHospitalizations();
}
