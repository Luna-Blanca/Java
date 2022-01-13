package Chapter6;

public class Car3 {
    String company;
    String model;
    String color;
    int maxSpeed;

    Car3(){

    }

    Car3(String model) {
        this.model = model;
    }

    Car3(String model, String company) {
        this.model = model;
        this.company = company;
    }

    Car3(String model, String company, String color) {
        this.model = model;
        this.company = company;
        this.color = color;
    }

    Car3(String model, String company, String color, int maxSpeed) {
        this.model = model;
        this.company = company;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }
}
