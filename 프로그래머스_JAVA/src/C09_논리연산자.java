public class C09_논리연산자 {
    public static void main(String[] args) {
        boolean b1 = true;
        boolean b2 = false;
        boolean b3 = true;

        System.out.println("T && F " + (b1 && b2));
        System.out.println("T && T " + (b1 && b3));
        System.out.println("T || F " + (b1 || b2));
        System.out.println("T || T " + (b1 || b3));

        System.out.println("!T " + !b1);
        System.out.println("T ^ F " + (b1 ^ b2));
        System.out.println("T ^ T " + (b1 ^ b3));

        int score = 88;
        if (score >= 70 && score <= 100) {
            System.out.println("성공");
        } else {
            System.out.println("실패");
        }
    }
}
