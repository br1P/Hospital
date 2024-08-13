import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Medic medic1 = new Medic("John","Doe",40.0,38,Specialty.NEUROLOGY,123);
        Pacient pacient1=new Pacient("Mary","Lou",12,32);
        Personal personal1=new Personal("Adam","Smith",13.0,40,Role.CLEANING_STAFF,43);
        Medication medication1=new Medication("Ibuprofen","500mg");
        Medication medication2 = new Medication("Paracetamol", "500mg");
        List<Medication> medications = new ArrayList<>();
        medications.add(medication1);
        medications.add(medication2);
        Treatment treatment1= new Treatment("headache",3,medications);
        Room room1=new Room(1,"single");
        Apointment apointment= new Apointment("13/8/2024 16:30",medic1,pacient1,room1);
        ClinicalHistory ch1=new ClinicalHistory(treatment1,apointment,23);

        System.out.println(ch1.toString());

    }
}