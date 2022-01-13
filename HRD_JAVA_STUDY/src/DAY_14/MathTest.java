package DAY_14;

public class MathTest {
    public static void main(String[] args) {
        System.out.println("3753.375의 절대값 ------> " + Math.abs(3753.375));
        System.out.println("3753.375의 반올림 ------> " + Math.round(3753.375));
        System.out.println("3753.975의 반올림 ------> " + Math.round(3753.975));
        System.out.println("3753.975의 절삭 ------> " + Math.floor(3753.975));
        System.out.println("100,30의 max ---->" + Math.max(100, 30));
        System.out.println("100,30의 min ---->" + Math.min(100, 30));
        System.out.println("난수 발생 ---->" + Math.random());
        int number = (int)Math.floor(Math.random()*10000);
        System.out.println("정수 난수 발생 ---->" + number);
    }
}
