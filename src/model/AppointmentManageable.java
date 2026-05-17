package model;

import java.util.ArrayList;

public interface AppointmentManageable {
    void addAppointment(Appointment appointment);
    ArrayList<Appointment> getAppointments();
}
