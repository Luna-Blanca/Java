package DAY_15;

public class ArrayVO {
    String name;
    int age;

    public ArrayVO() {
        this(null, 0);
    }

    public ArrayVO(String name) {
        this(name, 0);
    }

    public ArrayVO(int age) {
        this(null, age);
    }

    public ArrayVO(String name, int age) {
        this.name = name;
        this.age = age;
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
