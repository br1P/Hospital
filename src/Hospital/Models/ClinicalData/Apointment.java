package Hospital.Models.ClinicalData;

import Hospital.Models.People.Medic;
import Hospital.Models.People.Pacient;

public class Apointment {
    private String date; //private Date date;
    private Medic medic;


    public Apointment(String date, Medic medic) {
        this.date = date;
        this.medic = medic;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Medic getMedic() {
        return medic;
    }

    public void setMedic(Medic medic) {
        this.medic = medic;
    }



    @Override
    public String toString() {
        return
                "\ndate: " + date + '\n' +
                "Medic: \n" + medic.getName() + " " + medic.getLastname()  ;
    }
}
