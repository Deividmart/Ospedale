package model;

import java.util.ArrayList;

public interface HospitalizationManageable {
    void addHospitalization(Hospitalization hospitalization);
    ArrayList<Hospitalization> getHospitalizations();
}
