import java.io.IOException;
import java.util.Scanner;

public class _testCode2 {
    public static void main(String[] args) throws IOException {
        boolean run = true;
        int totalMoney = 0;
        int keyCode;

        Scanner scanner = new Scanner(System.in);

        while (run) {
            int addMoney = 0;
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            System.out.println("1 . 예금 | 2 . 출금 | 3 . 잔고 | 4 . 종료");
            System.out.println("잔고 \t" + totalMoney);
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            System.out.println("선택 > ");

            keyCode = System.in.read();

            if (keyCode == 49) {
                System.out.println(" ");
                System.out.println("얼마를 예금하시겠습니까?");
                System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
                System.out.println("1 . 1만원" + "\t" + "2 . 2만원" + "\t" + "3 . 5만원" + "\t" + "4 . 10만원" + "\t" + "5 . 20만원" + "\t" + "6 . 50만원");
                System.out.println("7 . 기타 금액");
                System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

                keyCode = System.in.read();

                switch (keyCode) {
                    case 1:
                        addMoney += 10000;
                        break;
                    case 2:
                        addMoney += 20000;
                        break;
                    case 3:
                        addMoney += 50000;
                        break;
                    case 4:
                        addMoney += 100000;
                        break;
                    case 5:
                        addMoney += 200000;
                        break;
                    case 6:
                        addMoney += 500000;
                        break;
                    case 7:
                        System.out.println(" ");
                        System.out.println("얼마를 예금하시겠습니까?");
                        addMoney += scanner.nextDouble();
                        break;
                    default:
                        System.out.println(" ");
                        System.out.println("메뉴를 다시 선택해주세요.");
                        break;
                }

                totalMoney += addMoney;
                System.out.println(" ");
                System.out.println("입금액 \t" + addMoney);
                System.out.println("잔액 \t" + totalMoney);
                System.out.println(" ");

            } else if (keyCode == 50) {
                System.out.println(" ");
                System.out.println("얼마를 출금하시겠습니까?");
                System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
                System.out.println("1 . 1만원" + "\t" + "2 . 2만원" + "\t" + "3 . 5만원" + "\t" + "4 . 10만원" + "\t" + "5 . 20만원" + "\t" + "6 . 50만원");
                System.out.println("7 . 기타 금액");
                System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

                keyCode = System.in.read();

                switch (keyCode) {
                    case 1:
                        addMoney += 10000;
                        break;
                    case 2:
                        addMoney += 20000;
                        break;
                    case 3:
                        addMoney += 50000;
                        break;
                    case 4:
                        addMoney += 100000;
                        break;
                    case 5:
                        addMoney += 200000;
                        break;
                    case 6:
                        addMoney += 500000;
                        break;
                    case 7:
                        System.out.println(" ");
                        System.out.println("얼마를 출금하시겠습니까?");
                        addMoney += scanner.nextDouble();
                        break;
                    default:
                        System.out.println(" ");
                        System.out.println("메뉴를 다시 선택해주세요.");
                        break;
                }

                totalMoney -= addMoney;
                System.out.println(" ");
                System.out.println("출금액 \t" + addMoney);
                System.out.println("잔액 \t" + totalMoney);
                System.out.println(" ");

            } else if (keyCode == 51) {
                System.out.println(" ");

            } else if (keyCode == 52) {
                System.out.println(" ");
                System.out.println("시스템을 종료합니다.");
                run = false;
            }
        }
        System.out.println();
    }
}
