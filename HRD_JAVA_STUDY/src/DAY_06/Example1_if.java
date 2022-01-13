package DAY_06;

import java.util.Scanner;

public class Example1_if {
    public static void main(String[] args) {
        // 제어문 : if문 for문 break문 while문 if-else문 switch문 continue문

        int randomNum = (int) (Math.random() * 6) + 1;
        Scanner scan = new Scanner(System.in);

        System.out.print("숫자를 입력해주세요. → ");
        int num = scan.nextInt();

        if (num > 5) {
            System.out.println("입력받은 숫자는 " + num + "입니다.");
            System.out.println("결과값은 참입니다!");
        } else {
            System.out.println("입력받은 숫자는 " + num + "입니다.");
            System.out.println("결과값은 거짓입니다!");
        }

        System.out.println(" ");

        if (randomNum > 5) {
            System.out.println("참입니다!");
        } else {
            System.out.println("현재의 숫자는 " + randomNum + "입니다.");
            System.out.println("거짓입니다!");
        }
        System.out.println("‼ 프로그램을 종료합니다.");
    }
}
