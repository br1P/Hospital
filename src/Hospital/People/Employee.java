package Hospital;

public abstract class Employee extends Person{
    private double payPerHour;
    private int workedHours;



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
        return super.toString() + "Hospital.Employee{" +
                "payPerHour=" + payPerHour +
                ", workedHours=" + workedHours +
                '}';
    }
}
