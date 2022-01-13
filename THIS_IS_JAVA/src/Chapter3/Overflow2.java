package Chapter3;

public class Overflow2 {
    public static void main(String[] args) {
        long x = 100000000;
        long y = 100000000;
        long z = x * y;
        System.out.println("z = " + z);
    }
}
