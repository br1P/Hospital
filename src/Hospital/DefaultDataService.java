package Hospital;

import Hospital.Generics.CustomLinkedList;
import Hospital.Models.ClinicalData.*;
import Hospital.Models.People.Medic;
import Hospital.Models.People.Pacient;

import Hospital.enums.Specialty;

import java.util.*;

public class DefaultDataService {
    public static HospitalData generateDefaultHospital(){

        //creating 1 medic
        Medic medic1 = new Medic("John","Doe",10.0,40, Specialty.CARDIOLOGY);
        //creating 1 personal
        //Personal personal1=new Personal("Adam","Smith",13.0,40, Role.CLEANING_STAFF,43);
        //creating 2 medications
        Medication medication1=new Medication("Ibuprofen","500mg");
        Medication medication2 = new Medication("Paracetamol", "500mg");
        //adding them to a list
        //List<Medication> medications = new ArrayList<>();
       // medications.add(medication1);
       // medications.add(medication2);
        //creating one treatment
        Treatment treatment1= new Treatment("headache",medication1);


        //creating 2 apointments
        Apointment apointment1= new Apointment("13/8/2024 16:30",medic1);
        Apointment apointment2 = new Apointment("15/10/2024 18:30",medic1);

        //creating treatment and apointment list for the clinical history
        CustomLinkedList<Treatment> treatmentL = new CustomLinkedList<>();
        treatmentL.add(treatment1);
        List<Apointment> apointmentL = new ArrayList<>();
        apointmentL.add(apointment1);
        apointmentL.add(apointment2);

        //creating clinical history
        ClinicalHistory clinicalHistory1 = new ClinicalHistory(apointmentL,treatmentL);

        //creating pacient
        Pacient pacient1=new Pacient("Mary","Lou",12,"female",clinicalHistory1);

        //creating list of pacients
        Map<Integer, Pacient> pacientsData = new HashMap<>();
        pacientsData.put(pacient1.getPacientID(), pacient1);
        //creating list of doctors
        Set<Medic> medicsData = new HashSet<>();
        medicsData.add(medic1);

        HospitalData hospitalData = new HospitalData(medicsData,pacientsData);
        return hospitalData;

    }
}
