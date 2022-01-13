package Chapter6;

import java.sql.SQLOutput;

public class Car3Ex {
    public static void main(String[] args) {
        Car3 myCar = new Car3("람보르기니");
        System.out.println("Car model \t" + myCar.model);
        System.out.println(" ");

        Car3 myCar1 = new Car3("람보르기니", "람보르기니");
        System.out.println("Car company \t" + myCar1.company);
        System.out.println("Car model \t" + myCar1.model);
        System.out.println(" ");

        Car3 myCar2 = new Car3("람보르기니", "람보르기니", "black");
        System.out.println("Car company \t" + myCar2.company);
        System.out.println("Car model \t" + myCar2.model);
        System.out.println("Car color \t" + myCar2.color);
    }
}
