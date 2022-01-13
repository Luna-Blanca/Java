package Chapter6;

public class Car1Ex {
    public static void main(String[] args) {
        Car1 Car = new Car1();

        System.out.println("제작 회사 = " + Car.company);
        System.out.println("모델명 = " + Car.model);
        System.out.println("색상 = " + Car.color);
        System.out.println("최고 속도 = " + Car.maxSpeed);
        System.out.println("현재 속도 = " + Car.speed);

        Car.speed = 75;
        System.out.println("현재 속도 = " + Car.speed);
    }
}
