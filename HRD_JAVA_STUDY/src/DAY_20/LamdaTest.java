package DAY_20;

public class LamdaTest {
    public static void main(String[] args) {
        LamdaClass2 lam1 = new LamdaClass2();
        System.out.println("lam1 = " + lam1.sum(10, 20));

        Lamda lam2 = new Lamda() {
            @Override
            public int sum(int x, int y) {
                return x+y;
            }
        };
        System.out.println("lam2 = " + lam2.sum(10, 300));

        Lamda lam3 = (int x, int y) -> {
            return x+y;
        };
        System.out.println("lam3 = " + lam3.sum(20, 3020));


    }
}
