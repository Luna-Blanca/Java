package Chapter6;

public class Car4 {
    String model;
    String company;
    String color;
    int maxSpeed;
    int speed;

    Car4(String model) {
        this(model, "람보르기니", "black", 250, 80);
    }

    Car4(String model, String company, String color, int maxSpeed, int speed) {
        this.model = model;
        this.company = company;
        this.color = color;
        this.maxSpeed = maxSpeed;
        this.speed = speed;
    }

}