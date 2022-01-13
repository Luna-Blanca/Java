package Chapter3;

public class CompareOprator {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 10;
        boolean result1 = (num1 == num2);
        boolean result2 = (num1 != num2);
        boolean result3 = (num1 <= num2);
        boolean result4 = (num1 >= num2);
        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);
        System.out.println("resulr3 = " + result3);
        System.out.println("result4 = " + result4);

        char c1 = 'A';
        char c2 = 'B';
        boolean result5 = (c1 < c2);
        System.out.println("result5 = " + result5);
    }
}
