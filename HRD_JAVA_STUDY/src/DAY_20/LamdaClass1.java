package DAY_20;

public class LamdaClass1 {
    public static void main(String[] args) {
        Lamda la = new Lamda() {
            @Override
            public int sum(int x, int y) {
                return x+y;
            }
        };
        System.out.println("la = " + la.sum(10, 30));
    }
}
