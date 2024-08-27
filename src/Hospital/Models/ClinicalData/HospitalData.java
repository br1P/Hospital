package Hospital.Models.ClinicalData;

import Hospital.Models.People.Medic;
import Hospital.Models.People.Pacient;

import java.util.List;

public class HospitalData {
    private List<Medic> medics;
    private List<Pacient> pacients;

    public HospitalData(List<Medic> medics, List<Pacient> pacients) {
        this.medics = medics;
        this.pacients = pacients;
    }

    public List<Medic> getMedics() {
        return medics;
    }

    public void setMedics(List<Medic> medics) {
        this.medics = medics;
    }

    public List<Pacient> getPacients() {
        return pacients;
    }

    public void setPacients(List<Pacient> pacients) {
        this.pacients = pacients;
    }

}
