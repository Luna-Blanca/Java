package DAY_06;

public class Example4_for {
    public static void main(String[] args) {

        int sum = 0;

        for(int i = 0; i<10; i++) {
            System.out.println(i + " . 우리는 자바를 배우고 있습니다.");
        }

        System.out.println("");

        //1~10까지의 숫자와 합계를 출력
        for(int i = 0; i<11; i++) {
            System.out.println(i);
            sum += i;
        }
        System.out.println("합계 = " + sum);
    }
}
