package Hospital.People;

import java.util.Objects;

public class Pacient extends Person{
    private int pacientId;
    private int age;

    public Pacient(String name, String lastname, int pacientId, int age) {
        super(name, lastname);
        this.pacientId = pacientId;
        this.age = age;
    }

    public int getPacientId() {
        return pacientId;
    }

    public void setPacientId(int pacientId) {
        this.pacientId = pacientId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    String prefix(){
        return "Pacient ";
    };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pacient pacient = (Pacient) o;
        return pacientId == pacient.pacientId && age == pacient.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pacientId, age);
    }

    @Override
    public String toString() {
        return   super.toString() +
                "pacient Id:" + pacientId +
                ", age: " + age ;
    }
}
