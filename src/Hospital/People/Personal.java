package Hospital.People;

import java.util.Objects;

public class Personal extends Employee{
    private Role role;
    private int personalID;

    public Personal(String name, String lastname, double payPerHour, int workedHours, Role role, int personalID) {
        super(name, lastname, payPerHour, workedHours);
        this.role = role;
        this.personalID = personalID;
    }

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

    String prefix(){
        return "Employee ";
    };

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
