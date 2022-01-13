package Chapter2;

public class OperationPromotionExample {
    public static void main(String[] args) {
        byte byteValue1 = 10;
        byte byteValue2 = 20;
        int intValue1 = byteValue1 + byteValue2;
        System.out.println("byteValue1 + byteValue2 = " + intValue1);

        char charValue1 = 'A';
        char charValue2 = 1;
        int intValue2 = charValue1 + charValue2;
        System.out.println("유니코드 : " + intValue2);
        System.out.println("출력문자 = " + (char)intValue2);

        int intValue3 = 10;
        int intValue4 = intValue3/4;
        System.out.println("intValue3 / 4 = " + intValue4);

        int intValue5 = 10;
        double doubleValue = intValue5 / 4.0;
        System.out.println("intValue5 / 4.0 = " + doubleValue);
    }
}
