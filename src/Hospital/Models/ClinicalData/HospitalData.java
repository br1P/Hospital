package Hospital.Models.ClinicalData;

import Hospital.Models.People.Medic;
import Hospital.Models.People.Pacient;

import java.util.*;

public class HospitalData{
    private Set<Medic> medics;
    private Map<Integer, Pacient> pacients;

    public HospitalData(Set<Medic> medics, Map<Integer, Pacient> pacients) {
        this.medics = new HashSet<>(medics);
        this.pacients = pacients;
    }

    public Set<Medic> getMedics() {
        return medics;
    }

    public void setMedics(Set<Medic> medics) {
        this.medics = medics;
    }

    public Map<Integer, Pacient> getPacients() {
        return pacients;
    }

    public void setPacients(Map<Integer, Pacient> pacients) {
        this.pacients = pacients;
    }





}
