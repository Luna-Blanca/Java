package DAY_06;

public class Example7_Modul {
    public static void main(String[] args) {
        int num = (int) (Math.random() * 100);

        if (num == 0) {
            System.out.println("시스템상으로 받아들일 수 없는 숫자입니다.");
        } else {
            if (num % 2 == 0) {
                System.out.println("현재 숫자는 _" + num + "_ 입니다.");
                System.out.println("해당 숫자는 짝수입니다.");
            } else {
                System.out.println("현재 숫자는 _" + num + "_ 입니다.");
                System.out.println("해당 숫자는 홀수입니다.");
            }
        }

    }
}
