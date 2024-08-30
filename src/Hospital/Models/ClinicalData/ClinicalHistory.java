package Hospital.Models.ClinicalData;

import Hospital.Generics.CustomLinkedList;
import Hospital.Models.People.Medic;

import java.util.ArrayList;
import java.util.List;

public class ClinicalHistory {
    private List<Apointment> apointments;
    private CustomLinkedList<Treatment> treatments;
    private int idCh=0;

    public ClinicalHistory(List<Apointment> apointments, CustomLinkedList<Treatment> treatments) {
        this.apointments = new ArrayList<>();
        this.treatments = new CustomLinkedList<>();
        this.idCh=0;

    }

    public List<Apointment> getApointments() {
        return apointments;
    }



    public CustomLinkedList<Treatment> getTreatments() {
        return treatments;
    }

    public void setTreatments(CustomLinkedList<Treatment> treatments) {
        this.treatments = treatments;
    }

    public int getIdCh() {
        return idCh;
    }

    public void setIdCh(int idCh) {
        this.idCh = idCh;
    }

    // public void addTreatment(Treatment treatment) {
    //    this.treatments.add(treatment);
    //}

    public void addApointment(Apointment apointment) {
        this.apointments.add(apointment);
    }

    public void addTreatment(Treatment tratamiento) {
        treatments.add(tratamiento);
    }

    public Treatment getTreatment(int index) {
        return treatments.get(index);
    }
    @Override
    public String toString() {
        return "\nClinicalHistory: \n" +
                "Apointments: \n" + apointments +
                "\ntreatments: \n" + treatments ;
    }
}