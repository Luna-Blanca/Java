package Chapter2;

public class PromotionExample {
    public static void main(String[] args) {
        byte byteValue = 10;                    //10
        int intValue = byteValue;               //10
        System.out.println(intValue);           //10

        char charValue = '가';                   //'가'
        intValue = byteValue;                   //10
        System.out.println("'가'의 유니코드 = " + intValue); //10

        intValue = 500;     //500
        long longValue = intValue;      //500
        System.out.println(longValue);      //500

        intValue = 200;     //200
        double doubleValue = intValue;      //200.0
        System.out.println(doubleValue);    //200.0
    }
}
