import java.util.List;
public class Treatment {
    private String observation;
    private int days;
    private List<Medication> medication;

    public Treatment(String observation, int days, List<Medication> medication) {
        this.observation = observation;
        this.days = days;
        this.medication = medication;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public List<Medication> getMedication() {
        return medication;
    }

    public void setMedication(List<Medication> medication) {
        this.medication = medication;
    }

    @Override
    public String toString() {
        return "Treatment{" +
                "observation='" + observation + '\'' +
                ", days=" + days +
                ", medication=" + medication +
                '}';
    }
}
