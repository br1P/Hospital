package Hospital.Models.ClinicalData;

import Hospital.Models.People.Medic;

import java.util.ArrayList;
import java.util.List;

public class ClinicalHistory {
    private List<Apointment> apointments;
    private List<Treatment> treatments;
    private int idCh=0;

    public ClinicalHistory(List<Apointment> apointments, List<Treatment> treatments) {
        this.apointments = new ArrayList<>();
        this.treatments = new ArrayList<>();
        this.idCh=0;

    }

    public List<Apointment> getApointments() {
        return apointments;
    }

    public void setApointments(List<Apointment> apointments) {
        this.apointments = apointments;
    }

    public List<Treatment> getTreatments() {
        return treatments;
    }

    public void setTreatments(List<Treatment> treatments) {
        this.treatments = treatments;
    }

    public int getIdCh() {
        return idCh;
    }

    public void setIdCh(int idCh) {
        this.idCh = idCh;
    }

     public void addTreatment(Treatment treatment) {
        this.treatments.add(treatment);
    }

    @Override
    public String toString() {
        return "\nClinicalHistory: \n" +
                "Apointments: \n" + apointments +
                "\ntreatments: \n" + treatments ;
    }
}
