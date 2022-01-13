import java.util.Arrays;

public class 피보나치수열_향상 {
    static int[] cache = new int[10000];

    public static int fibo_hard(int n) {
        if (cache[n] != -1) {
            return cache[n];
        }

        if (n == 1 || n == 2) {
            return 1;
        }
        cache[n] = fibo_hard(n - 1) + fibo_hard(n - 2);
        return cache[n];
    }

    public static int fibo_simple(int n) {
        if (n == 1 || n == 2)
            return 1;
        return fibo_simple(n - 1) + fibo_simple(n - 2);
    }

    public static void main(String[] args) {
        Arrays.fill(cache, -1);

        long start = System.nanoTime();
        fibo_simple(50);
        long end = System.nanoTime();
        System.out.println("Fibo - simple : " + (end - start) / 1000000.0 + "ms");

        start = System.nanoTime();
        fibo_hard(50);
        end = System.nanoTime();
        System.out.println("Fibo - hard : " + (end - start) / 1000000.0 + "ms");
    }
}
