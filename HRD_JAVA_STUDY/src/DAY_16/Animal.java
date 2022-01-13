package DAY_16;

public class Animal {
    public static final int PERSON = 1;
    public static final int DOG = 2;
    public static final int CAT = 3;

    String name;
    int age;
    int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Animal() {
    }

    public Animal(String name, int age, int type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }

    public void sleep() {
        System.out.println("zzz...");
    }

    public void eat() {
        System.out.println("eat");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
