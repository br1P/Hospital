package Hospital.ClinicalData;

import Hospital.People.Medic;
import Hospital.People.Pacient;
import Hospital.Room;

public class Apointment {
    private String date; //private Date date;
    private Medic medic;
    private Pacient pacient;
    private Room room;

    public Apointment(String date, Medic medic, Pacient pacient, Room room) {
        this.date = date;
        this.medic = medic;
        this.pacient = pacient;
        this.room = room;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
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

    public Pacient getPacient() {
        return pacient;
    }

    public void setPacient(Pacient pacient) {
        this.pacient = pacient;
    }

    @Override
    public String toString() {
        return "Apointment: \n" +
                "date:\n " + date + '\n' +
                "Medic: \n" + medic +
                "Pacient: \n" + pacient + '\n' +
                room ;
    }
}
