package DAY_13;

public class 생성자 {
    // Field
    private String name;
    private int age;


    // Constructor
    public 생성자() {
        this("NULL", 0);
        // name = "NULL";
        // age = 0;
    }

    public 생성자(String name) {
        this(name, 0);
        // this.name;
        // age = 0;
    }

    public 생성자(int age) {
        this("NULL", age);
        // name = "NULL";
        // this.age;
    }

    public 생성자(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method
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
