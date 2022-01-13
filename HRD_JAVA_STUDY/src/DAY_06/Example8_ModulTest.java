package DAY_06;

public class Example8_ModulTest {
    public static void main(String[] args) {
        int num = (int) (Math.random() * 100);


        do {
            int count = num;
            if (count == 0) {
                System.out.println("현재 확인하기 어려운 수 입니다.");
            } else {
                if (count % 2 == 0) {
                    System.out.println("현재의 숫자는 짝수입니다.");
                    System.out.println("출력된 숫자 - " + num);
                } else {
                    System.out.println("현재의 숫자는 홀수입니다.");
                    System.out.println("출력된 숫자 - " + num);
                }
            }
        } while (num != 80);
    }
}
