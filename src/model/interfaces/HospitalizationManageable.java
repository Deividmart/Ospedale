package model.interfaces;

import model.Hospitalization;
import java.util.ArrayList;

public interface HospitalizationManageable {
    void addHospitalization(Hospitalization hospitalization);
    ArrayList<Hospitalization> getHospitalizations();
}
