package Hospital.Models.ClinicalData;

import Hospital.Models.People.Pacient;

import java.util.LinkedList;
import java.util.Queue;

public class Emergency {
    private Queue<Pacient> emergencyQueue;

    public Emergency() {
        this.emergencyQueue = new LinkedList<>();
    }

    public void addPatientToEmergencyQueue(Pacient pacient) {
        emergencyQueue.add(pacient);
        System.out.println("Patient added to emergency queue: " + pacient.getName());
    }

    public Pacient treatNextEmergencyPatient() {
        return emergencyQueue.poll();  // Treat the next patient in the queue
    }
}