package Hospital;

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

    @Override
    public String toString() {
        return "Hospital.Personal{" +
                "role=" + role +
                ", personalID='" + personalID + '\'' +
                '}';
    }
}
