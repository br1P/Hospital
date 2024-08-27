package Hospital.Models.ClinicalData;

import java.util.ArrayList;
import java.util.List;
public class Treatment {
    private String observation;
    private Medication medication;

    public Treatment(String observation, Medication medication) {
        this.observation = observation;

        this.medication = medication;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }

    @Override
    public String toString() {
        return "Treatment: \n " +
                "observation: '" + observation + '\'' +

                ", medication: " + medication + '\n';
    }
}
