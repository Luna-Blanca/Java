public class 알고리즘 {

    public static void sum1(int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += i;
        }
        System.out.println("SUM = " + sum);
    }

    public static void sum2(int n) {
        System.out.println("SUM = " + n * (n + 1) / 2);
    }

    public static void sum3(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
            for (int j = 1; j <= n; j++) {
            }
        }
        System.out.println("SUM = " + sum);
    }

    public static void main(String[] args) {
        sum1(100);
        sum2(100);
        sum3(100);
    }
}
