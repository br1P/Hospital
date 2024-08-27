package Hospital.Models.People;

import Hospital.Interfaces.Prefix;

public abstract class Person implements Prefix {

    protected String name;
    protected String lastname;

    public Person() {
    }

    public Person(String name, String lastname) {
        this.name =  name;
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

    abstract public String prefix();
    @Override
    public String toString() {
        return
                "name: '" + prefix() + name + " "  + lastname + '\'' ;
    }
}
