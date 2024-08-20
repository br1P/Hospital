package Hospital.People;

public abstract class Employee extends Person{
    protected double payPerHour;
    protected int workedHours;


    public Employee() {
    }

    public Employee(String name, String lastname) {
        super(name, lastname);
    }

    public Employee(String name, String lastname, double payPerHour, int workedHours) {
        super(name, lastname);
        this.payPerHour = payPerHour;
        this.workedHours = workedHours;
    }

    //region getter & setter
    public double getPayPerHour() {
        return payPerHour;
    }

    public void setPayPerHour(double payPerHour) {
        this.payPerHour = payPerHour;
    }

    public int getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(int workedHours) {
        this.workedHours = workedHours;
    }
    //endregion


    @Override
    public String toString() {
        return super.toString() +
                " payPerHour: " + payPerHour +
                ", workedHours: " + workedHours + " ";
    }
}
