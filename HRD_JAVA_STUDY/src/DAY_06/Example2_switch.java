package DAY_06;

public class Example2_switch {
    public static void main(String[] args) {

        int num = (int) (Math.random() * 6) + 1;

        System.out.println("**********************************");
        System.out.println("숫자는 총 6개로 구성이 되어있습니다.");
        System.out.println("숫자의 경우 \"1 ~ 6\" 까지 입니다.");
        System.out.println("**********************************");

        switch (num) {
            case 1:
                System.out.println("현재 번호는 1번입니다.");
                break;
            case 2:
                System.out.println("현재 번호는 2번입니다.");
                break;
            case 3:
                System.out.println("현재 번호는 3번입니다.");
                break;
            case 4:
                System.out.println("현재 번호는 4번입니다.");
                break;
            case 5:
                System.out.println("현재 번호는 5번입니다.");
                break;
            case 6:
                System.out.println("현재 번호는 6번입니다.");
                break;
        }
    }
}
