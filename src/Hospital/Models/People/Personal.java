package Hospital.Models.People;

import Hospital.Interfaces.CheckIn;
import Hospital.Interfaces.Prefix;
import Hospital.Interfaces.Salary;
import Hospital.Interfaces.Surgery;
import Hospital.enums.Role;

import java.util.Objects;

public class Personal extends Employee implements Prefix, Salary, Surgery, CheckIn {
    protected Role role;
    protected int personalID;
    protected final double ExtraHours=1.2;
    public Personal(String name, String lastname, double payPerHour, int workedHours, Role role, int personalID) {
        super(name, lastname, payPerHour, workedHours);
        this.role = role;
        this.personalID = personalID;
    }

    //region Getter & Setters
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getPersonalID() {
        return personalID;
    }

    public void setPersonalID(int personalID) {
        this.personalID = personalID;
    }
//endregion
public String prefix(){
        return "Employee ";
    };

    @Override
    public double calcSalary() {
        if(workedHours<38){
            return super.calcSalary();}
        else{
            int extraWorkedHours=workedHours-38;
            return 38*payPerHour + (extraWorkedHours*payPerHour*1.5);
        }
    }
    final public String surgeryRoom(){
        if(this.role.equals(Role.CLEANING_STAFF)){
            return "This doctor is allowed to enter Surgery Room \n";
        }
        else {
            return "This doctor is not allowed at the Surgery Room";
        }
    }

    @Override
    public boolean Check() {
        System.out.println("Pacient check in the apointment");
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personal personal = (Personal) o;
        return personalID == personal.personalID && role == personal.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(role, personalID);
    }

    @Override
    public String toString() {
        return super.toString() +
                "role:" + role +
                ", personalID: '" + personalID + '\'';
    }
}
