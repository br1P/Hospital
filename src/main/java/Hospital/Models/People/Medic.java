package Hospital.Models.People;

import Hospital.Interfaces.CheckIn;
import Hospital.Interfaces.Prefix;
import Hospital.Interfaces.Salary;
import Hospital.Interfaces.Surgery;
import Hospital.enums.Specialty;

import java.util.Objects;
import java.util.function.*;
import java.util.List;

public class Medic extends Employee implements Prefix, Salary, Surgery, CheckIn {

    protected static int licenseNumberGen = 0; //STATIC VARIABLE
    protected Specialty specialty;
    protected int licenseNumber;
    protected final double ExtraHours = 1.5; //FINAL VARIABLE

    // 1
    private static final Supplier<Integer> generateLicenseNumber = () -> ++Medic.licenseNumberGen; // Supplier: generates a license number

    // 2
    private static final Predicate<Medic> isCriticalSpecialty = medic -> medic.specialty.equals(Specialty.CARDIOLOGY);  // Predicate: check if a medic specialty is cardiology

    // 3
    private static final Consumer<Medic> printMedicDetails = medic -> System.out.println(medic);    // Consumer: print medic details

    // 4
    private static final BiFunction<Double, Integer, Double> calcMedicSalary = (payPerHour, workedHours) -> {  // BiFunction: cal medic salary for hours
        int regularHours = Math.min(38, workedHours);
        int extraHours = Math.max(0, workedHours - 38);
        return (regularHours * payPerHour) + (extraHours * payPerHour * 1.5);
    };

    //5
    private static final Function<Medic, String> medicPrefix = medic -> "Dr. " ;  // Function: for returning "Dr"

    public Medic(String name, String lastname, double payPerHour, int workedHours, Specialty specialty) {
        super(name, lastname, payPerHour, workedHours);
        this.specialty = specialty;
        this.licenseNumber = generateLicenseNumber.get();
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


    public String prefix() { //using lambda for obtaining medic prefix
        return medicPrefix.apply(this);
    }

    // Verify if medic can join surgery room
    final public String surgeryRoom() {
        if (isCriticalSpecialty.test(this)) {
            return "This doctor is allowed to enter Surgery Room \n";
        } else {
            return "This doctor is not allowed at the Surgery Room";
        }
    }


    @Override
    public double calcSalary() {    // Calc salary with BiFunction
        return calcMedicSalary.apply(payPerHour, workedHours);
    }


    @Override
    public boolean Check() {
        System.out.println("Pacient leaved the appointment");
        return false;
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
                ", licenseNumber:" + licenseNumber + '\n' +
                "salary of the month: " + calcSalary() + " " + surgeryRoom();
    }

    // print details with Consumer
    public void printDetails() {
        printMedicDetails.accept(this);
    }
}
