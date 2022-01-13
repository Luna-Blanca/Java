package Chapter2;

public class CastExample {
    public static void main(String[] args) {
        int intValue = 44032;
        char charValue = (char) intValue;
        System.out.println(charValue); //가

        long longValue = 500;
        intValue = (int) longValue;
        System.out.println(intValue);  //500

        double doubleValue = 3.14;
        intValue = (int) doubleValue;
        System.out.println(intValue);    //3

        char charValeu = '가';
        double doubleValue1 = (double) charValue;
        System.out.println(doubleValue1);   //44032.0
    }
}
