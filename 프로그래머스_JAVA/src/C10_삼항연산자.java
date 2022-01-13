public class C10_삼항연산자 {
    public static void main(String[] args) {
        int b1 = (5 > 4) ? 50 : 40;
        int b2 = (5 < 4) ? 50 : 40;

        System.out.println("b1 = " + b1 + "\nb2 = " + b2);

        if (5 > 4) {
            b1 = 70;
        } else {
            b1 = 100;
        }
        System.out.println("New b1 = " + b1);
    }
}
