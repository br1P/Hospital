public class Medication {
    private String name;
    private String dosage;

    // Constructor
    public Medication(String name, String dosage) {
        this.name = name;
        this.dosage = dosage;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getDosage() {
        return dosage;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    @Override
    public String toString() {
        return "Medication{" +
                "name='" + name + '\'' +
                ", dosage='" + dosage + '\'' +
                '}';
    }
}
