package Hospital.Models.People;

import Hospital.Models.ClinicalData.ClinicalHistory;

import java.util.Objects;

public class Pacient extends Person implements Prefix{
    private static int pacientIdGen=0;
    private int age;
    private String gender;
    private int pacientID;
    private ClinicalHistory clinicalHistory;

    public Pacient(String name, String lastname, int age, String gender,ClinicalHistory clinicalHistory) {
        super(name, lastname);
        this.pacientID = ++Pacient.pacientIdGen;
        this.age = age;
        this.gender = gender;
        this.clinicalHistory = clinicalHistory;
    }

 //region Getter & Setters
    public int getPacientID() {
        return pacientID;
    }

    public void setPacientID(int pacientID) {
        this.pacientID = pacientID;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public ClinicalHistory getClinicalHistory() {
        return clinicalHistory;
    }

    public void setClinicalHistory(ClinicalHistory clinicalHistory) {
        this.clinicalHistory = clinicalHistory;
    }

    //endregion



    final public String prefix(){
        System.out.println(this.gender);
        if ("male".equalsIgnoreCase(this.gender)) {
            return "Mr.";
        } else if ("female".equalsIgnoreCase(this.gender)) {
            return "Miss ";
        } else {
            return "Unknown";
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pacient pacient = (Pacient) o;
        return pacientID == pacient.pacientID;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(pacientID);
    }

    @Override
    public String toString() {
        return "Pacient:\n" +
                "age:" + age +
                ", gender:'" + gender + '\'' +
                ", pacientID:" + pacientID +
                ", clinicalHistory:" + clinicalHistory;
    }
}
