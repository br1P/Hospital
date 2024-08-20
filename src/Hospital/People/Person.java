package Hospital.People;

public abstract class Person {

    protected String name;
    protected String lastname;

    public Person() {
    }

    public Person(String name, String lastname) {
        this.name = prefix() + name;
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    abstract String prefix();
    @Override
    public String toString() {
        return
                "name: '" + name + " "  + lastname + '\'' ;
    }
}
