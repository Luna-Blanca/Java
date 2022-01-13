package DAY_14;

public class WrapperClassTest {
    public static void main(String[] args) {
        Integer number1 = new Integer(100);
        Integer number2 = new Integer("100");

        System.out.println("number1 > " + number1);
        System.out.println("number2 > " + number2);
        System.out.println("number1 > " + System.identityHashCode(number1));
        System.out.println("number2 > " + System.identityHashCode(number2));

        if (number1 == number2) {
            System.out.println("같다");
        } else {
            System.out.println("다르다");
        }

        if (number1.equals(number2)) {
            System.out.println("같다");
        } else {
            System.out.println("다르다");
        }
    }
}
