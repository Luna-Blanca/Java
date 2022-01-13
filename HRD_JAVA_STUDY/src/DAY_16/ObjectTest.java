package DAY_16;

public class ObjectTest {
    public static void main(String[] args) {
        Car 개인차량 = new Car();
        Taxi 개인택시 = new Taxi();

        개인택시.name = "기아";
        개인택시.price = "174,800,000";
        개인택시.fares = 10;

        System.out.println(개인택시.getName());
        System.out.println(개인택시.getPrice());
        System.out.println(개인택시.getFares());
    }
}
