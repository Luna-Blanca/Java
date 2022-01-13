package Check_Question;

import java.io.IOException;
import java.util.Scanner;

public class Ch4_1 {
    public static void main(String[] args) throws IOException {
        boolean run = true;
        double totalMoney = 0;
        int keyCode;

        Scanner scanner = new Scanner(System.in);

        while (run) {
            double addMoney = 0;
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            System.out.println("1 . 예금 | 2 . 출금 | 3 . 잔고 | 4 . 종료");
            System.out.println("잔고 \t" + totalMoney);
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            System.out.println("선택 > ");

            keyCode = scanner.nextInt();

            if (keyCode == 1) {
                System.out.println(" ");
                System.out.println("얼마를 예금하시겠습니까?");
                System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
                System.out.println("1 . 1만원" + "\t" + "2 . 2만원" + "\t" + "3 . 5만원" + "\t" + "4 . 10만원" + "\t" + "5 . 20만원" + "\t" + "6 . 50만원");
                System.out.println("7 . 기타 금액");
                System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

                keyCode = scanner.nextInt();

                if (keyCode == 1) {   //1번 눌렀을 경우 1만원
                    addMoney += 10000;
                } else if (keyCode == 2) {   //2번 눌렀을 경우 2만원
                    addMoney += 20000;
                } else if (keyCode == 3) {    //3번 눌렀을 경우 5만원
                    addMoney += 50000;
                } else if (keyCode == 4) {   //4번 눌렀을 경우 10만원
                    addMoney += 100000;
                } else if (keyCode == 5) {   //5번 눌렀을 경우 20만원
                    addMoney += 200000;
                } else if (keyCode == 6) {   //6번 눌렀을 경우 50만원
                    addMoney += 500000;
                } else if (keyCode == 7) {
                    System.out.println(" ");
                    System.out.println("얼마를 입금하시겠습니까?");
                    addMoney += scanner.nextDouble();
                } else {
                    System.out.println(" ");
                    System.out.println("메뉴를 다시 선택해주세요.");
                }
                totalMoney += addMoney;
                System.out.println(" ");
                System.out.println("입금액 \t" + addMoney);
                System.out.println("잔액 \t" + totalMoney);
                System.out.println(" ");

            } else if (keyCode == 2) {
                System.out.println(" ");
                System.out.println("얼마를 출금하시겠습니까?");
                System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
                System.out.println("1 . 1만원" + "\t" + "2 . 2만원" + "\t" + "3 . 5만원" + "\t" + "4 . 10만원" + "\t" + "5 . 20만원" + "\t" + "6 . 50만원");
                System.out.println("7 . 기타 금액");
                System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

                keyCode = scanner.nextInt();

                if (keyCode == 1) {   //1번 눌렀을 경우 1만원
                    addMoney += 10000;
                } else if (keyCode == 2) {   //2번 눌렀을 경우 2만원
                    addMoney += 20000;
                } else if (keyCode == 3) {    //3번 눌렀을 경우 5만원
                    addMoney += 50000;
                } else if (keyCode == 4) {   //4번 눌렀을 경우 10만원
                    addMoney += 100000;
                } else if (keyCode == 5) {   //5번 눌렀을 경우 20만원
                    addMoney += 200000;
                } else if (keyCode == 6) {   //6번 눌렀을 경우 50만원
                    addMoney += 500000;
                } else if (keyCode == 7) {
                    System.out.println(" ");
                    System.out.println("얼마를 출금하시겠습니까?");
                    addMoney += scanner.nextDouble();
                } else {
                    System.out.println(" ");
                    System.out.println("메뉴를 다시 선택해주세요.");
                }
                totalMoney -= addMoney;
                System.out.println(" ");
                System.out.println("입금액 \t" + addMoney);
                System.out.println("잔액 \t" + totalMoney);
                System.out.println(" ");

            } else if (keyCode == 3) {
                System.out.println(" ");

            } else if (keyCode == 4) {
                System.out.println(" ");
                System.out.println("시스템을 종료합니다.");
                run = false;
            }
        }
        System.out.println();
    }
}
