package Chapter2;

public class FromIntToDouble {
    public static void main(String[] args) {
        int num1 = 1234567890;
        int num2 = 1234567890;

        double num3 = num2;
        num2 = (int) num1;

        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
        System.out.println("num3 = " + num3);

        int result = num1 - num2;
        System.out.println(result);
    }
}
