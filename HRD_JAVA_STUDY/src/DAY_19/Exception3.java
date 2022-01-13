package DAY_19;

import java.util.Random;

public class Exception3 {
    public static void main(String[] args) {
        Random rm = new Random();
        int num = rm.nextInt();

        System.out.println(num);
        try {
            if ((num % 2) == 0) {
                throw new Exception("짝수!!!");
            } else {
                throw new Exception("홀수!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
