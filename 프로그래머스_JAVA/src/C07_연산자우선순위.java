import javax.swing.*;

public class C07_연산자우선순위 {
    public static void main(String[] args) {
        int a = 5;
        int b = 10;
        int c = 15;

        int result1 = a+b*c;
        boolean result2 = a > 5 && b  < 5;
        int result3 = (a+b) * c;

        System.out.println("a - b * c = " + result1);
        System.out.println("(a + b ) * c = " + result3);
        System.out.println("a > 5 && b  < 5 = " + result2);

        int a1 = ++a;
        int result4 = a1 - 5;
        System.out.println("++a = " + a1);
        System.out.println("++a - 5 = " + result4);

        a = 5;
        int a2 = a++;
        int result5 = a2 - 5;
        System.out.println("a++ = " + a2);
        System.out.println("a++ - 5 = " + result5);
    }
}
