package Hospital.Models.People;

import Hospital.Interfaces.Salary;

public abstract class Employee extends Person implements Salary {
    protected double payPerHour;
    protected int workedHours;




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

    public double calcSalary(){
        return  workedHours*payPerHour;
    }

    @Override
    public String toString() {
        return super.toString() +
                " payPerHour: " + payPerHour +
                ", workedHours: " + workedHours + " ";
    }
}
