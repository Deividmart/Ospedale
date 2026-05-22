package model;

import java.time.LocalDate;

public class Hospitalization {

    private final String id;
    private Patient patient;
    private Doctor doctor;
    private LocalDate date;
    private String reason;
    private RoomType roomType;
    private String observations;
    private HospitalizationStatus status;

    public Hospitalization(String id, Patient patient, Doctor doctor, LocalDate date,
                           String reason, RoomType roomType, String observations) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.reason = reason;
        this.roomType = roomType;
        this.observations = observations;
        this.status = HospitalizationStatus.REQUESTED;
    }

    public String getId()                   { return id; }
    public Patient getPatient()             { return patient; }
    public Doctor getDoctor()               { return doctor; }
    public LocalDate getDate()              { return date; }
    public String getReason()               { return reason; }
    public RoomType getRoomType()           { return roomType; }
    public String getObservations()         { return observations; }
    public HospitalizationStatus getStatus() { return status; }

    public void setStatus(HospitalizationStatus status) { this.status = status; }
    public void setObservations(String observations)    { this.observations = observations; }
}
