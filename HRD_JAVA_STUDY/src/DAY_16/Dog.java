package DAY_16;

public class Dog extends Animal implements AnimalAct {

    public Dog() {}
    public Dog(String name, int age, int type) {
        super(name, age, type);
    }

    public void sleep() {}
    public void eat() {}
    public void eat(String food) {}

    boolean Tail;

    public boolean isTail() {
        return Tail;
    }

    public void setTail(boolean tail) {
        Tail = tail;
    }
}
