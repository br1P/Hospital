package Hospital;

import Hospital.People.Medic;
import Hospital.People.Pacient;

public class Apointment {
    private String date;
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
        return "Hospital.Apointment{" +
                "date=" + date +
                ", medic=" + medic +
                ", pacient=" + pacient +
                ", room=" + room +
                '}';
    }
}
