package Chapter3;

public class StringEquals {
    public static void main(String[] args) {
        String strVar1 = "신민철";
        String strVar2 = "신민철";
        String strVar3 = new String("신민철");

        System.out.println("strVar1 == strVar2 = " + (strVar1 == strVar2));
        System.out.println("strVar1 == strVar3 = " + (strVar1 == strVar3));
        System.out.println("strVar2 == strVar3 = " + (strVar2 == strVar3));
        System.out.println("strVal1.equals(strVar3) = " + strVar1.equals(strVar3));
    }
}
