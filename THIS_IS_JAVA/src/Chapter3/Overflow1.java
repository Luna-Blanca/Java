package Chapter3;

public class Overflow1 {
    public static void main(String[] args) {
        int x = 100000000;
        int y = 100000000;
        int z = x * y;
        System.out.println("z = " + z);
    }
}
