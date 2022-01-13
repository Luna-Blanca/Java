package DAY_16;

public class Person extends Animal implements AnimalAct{
    String address;

    public Person() {
    }

    public Person(String name, int age, int type) {
        super(name, age, type);
    }

    public void sleep() {}
    public void eat() {}
    public void eat(String food) {}

    public void think() {
        System.out.println("생각한다");
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
