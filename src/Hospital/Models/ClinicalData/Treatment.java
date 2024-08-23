package Hospital.Models.ClinicalData;

import java.util.List;
public class Treatment {
    private String observation;
    private List<Medication> medication;

    public Treatment(String observation, List<Medication> medication) {
        this.observation = observation;

        this.medication = medication;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }



    public List<Medication> getMedication() {
        return medication;
    }

    public void setMedication(List<Medication> medication) {
        this.medication = medication;
    }

    @Override
    public String toString() {
        return "Treatment: \n " +
                "observation: '" + observation + '\'' +

                ", medication: " + medication + '\n';
    }
}
