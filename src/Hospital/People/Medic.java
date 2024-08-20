package Hospital.People;

import java.util.Objects;

public class Medic extends Employee{
    protected Specialty specialty;
    protected int licenseNumber;


    public Medic() {
    }


    public Medic(String name, String lastname, double payPerHour, int workedHours) {
        super(name, lastname, payPerHour, workedHours);
    }

    public Medic(String name, String lastname, double payPerHour, int workedHours, Specialty specialty, int licenseNumber) {
        super(name, lastname, payPerHour, workedHours);
        this.specialty = specialty;
        this.licenseNumber = licenseNumber;
    }
    //region getter & setter
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

    String prefix(){
        return "Dr.";
    };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medic medic = (Medic) o;
        return licenseNumber == medic.licenseNumber && specialty == medic.specialty;
    }

    @Override
    public int hashCode() {
        return Objects.hash(specialty, licenseNumber);
    }

    @Override
    public String toString() {
        return super.toString() +
                "specialty: " + specialty +
                ", licenseNumber:'" + licenseNumber + '\n' ;
    }
}
