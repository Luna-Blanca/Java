package Chapter4;

public class ForSumFrom1To100 {
    public static void main(String[] args) {
        int result = 0;

        for(int i=0; i<=100; i++) {
            result += i;
        }
        System.out.println("1부터 100까지의 합 = " + result);
    }
}
