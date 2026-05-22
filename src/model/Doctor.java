package model;

import model.interfaces.AppointmentManageable;
import model.interfaces.HospitalizationManageable;
import java.util.ArrayList;

public class Doctor extends User implements AppointmentManageable, HospitalizationManageable {

    private Specialty specialty;
    private String licenceNumber;
    private String assignedOffice;
    private ArrayList<Appointment> appointments;
    private ArrayList<Hospitalization> hospitalizations;

    public Doctor(long id, String username, String firstname, String lastname, String password,
                  Specialty specialty, String licenceNumber, String assignedOffice) {
        super(id, username, firstname, lastname, password);
        this.specialty = specialty;
        this.licenceNumber = licenceNumber;
        this.assignedOffice = assignedOffice;
        this.appointments = new ArrayList<>();
        this.hospitalizations = new ArrayList<>();
    }

    public Specialty getSpecialty()                           { return specialty; }
    public String getLicenceNumber()                          { return licenceNumber; }
    public String getAssignedOffice()                         { return assignedOffice; }
    public ArrayList<Appointment> getAppointments()           { return appointments; }
    public ArrayList<Hospitalization> getHospitalizations()   { return hospitalizations; }

    public void setSpecialty(Specialty specialty)             { this.specialty = specialty; }
    public void setLicenceNumber(String licenceNumber)        { this.licenceNumber = licenceNumber; }
    public void setAssignedOffice(String assignedOffice)      { this.assignedOffice = assignedOffice; }

    public void addAppointment(Appointment a)       { this.appointments.add(a); }
    public void addHospitalization(Hospitalization h) { this.hospitalizations.add(h); }
}
