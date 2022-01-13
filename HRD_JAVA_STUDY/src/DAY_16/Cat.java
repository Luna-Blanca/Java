package DAY_16;

public class Cat extends Animal implements AnimalAct {
    boolean Tail;

    public Cat() { }
    public void sleep() {}
    public void eat() {}
    public void eat(String food) {}

    public Cat(String name, int age, int type) {
        super(name, age, type);
    }

    public boolean isTail() {
        return Tail;
    }

    public void setTail(boolean tail) {
        Tail = tail;
    }
}
