package DAY_13;

public class OverloadingMain {
    public static void main(String[] args) {
        OverloadingObject oo = new OverloadingObject();

        oo.setNumber("1234");
        System.out.println(oo.getNumber());

        oo.setNumber(10);
        System.out.println(oo.getNumber());

        oo.setNumber(12.345);
        System.out.println(oo.getNumber());

        oo.setNumber(10, 30);
        System.out.println(oo.getNumber());
    }
}
