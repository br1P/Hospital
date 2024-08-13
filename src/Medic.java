public class Medic extends Employee{
    private Specialty specialty;
    private int licenseNumber;

    //region getter & setter
    public Medic(String name, String lastname, double payPerHour, int workedHours, Specialty specialty, int licenseNumber) {
        super(name, lastname, payPerHour, workedHours);
        this.specialty = specialty;
        this.licenseNumber = licenseNumber;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public int getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(int licenseNumber) {
        this.licenseNumber = licenseNumber;
    }
//endregion

    @Override
    public String toString() {
        return super.toString() + "Medic{" +
                "specialty=" + specialty +
                ", licenseNumber='" + licenseNumber + '\'' +
                '}';
    }
}
