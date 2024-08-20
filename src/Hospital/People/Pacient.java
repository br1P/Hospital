package Hospital;

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

    @Override
    public String toString() {
        return super.toString() +"Hospital.Pacient{" +
                "pacientId=" + pacientId +
                ", age=" + age +
                '}';
    }
}
