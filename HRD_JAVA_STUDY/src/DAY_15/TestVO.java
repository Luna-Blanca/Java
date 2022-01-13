package DAY_15;

public class TestVO {
    String name;
    int age;

    public TestVO(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public TestVO() {
        this(null, 0);
    }

    public TestVO(String name) {
        this(name, 30);
    }

    public TestVO(int age) {
        this(null, age);
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
