package Hospital.Models.People;

import Hospital.enums.Specialty;

import java.util.Objects;

public class Medic extends Employee implements Prefix,Salary,Surgery{
    protected static int licenseNumberGen=0;
    protected Specialty specialty;
    protected int licenseNumber;
    protected final double ExtraHours=1.5;

    public Medic(String name, String lastname, double payPerHour, int workedHours, Specialty specialty) {
        super(name, lastname, payPerHour, workedHours);
        this.specialty = specialty;
        this.licenseNumber = ++Medic.licenseNumberGen;
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

    public String prefix(){
        return "Dr.";
    }

    final public String surgeryRoom(){
        if(this.specialty.equals(Specialty.CARDIOLOGY)){
            return "This doctor is allowed to enter Surgery Room \n";
        }
        else {
            return "This doctor is not allowed at the Surgery Room";
        }
    }
    @Override
    public double calcSalary() {
        if(workedHours<38){
        return super.calcSalary();}
        else{
            int extraWorkedHours=workedHours-38;
            return 38*payPerHour + (extraWorkedHours*payPerHour*1.5);
        }
    }

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
                ", licenseNumber:'" + licenseNumber + '\n' + "salary of the month: " +calcSalary() + " "+ surgeryRoom();
    }
}
