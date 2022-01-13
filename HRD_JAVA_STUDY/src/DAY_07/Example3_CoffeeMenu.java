package DAY_07;

import java.util.Scanner;

public class Example3_CoffeeMenu {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int coin = 0;
        String myCoffeeSize = null;
        String myCoffeeDegree = null;

        boolean flag = true;

        while (flag) {
            int mainCheck = 0;

            //① 메뉴 확인
            System.out.println("MAIN");
            System.out.println("현재 잔액 : " + coin);
            System.out.println("1 . 잔액충전");
            System.out.println("2 . 메뉴");
            System.out.println("3 . 종료");
            System.out.println("---------------------");
            System.out.println("메뉴를 선택해주세요.");
            System.out.print("→ ");
            mainCheck = scan.nextInt();

            // 1-1 잔돈 충전
            if (mainCheck == 1) {
                System.out.println();
                System.out.println("얼마를 충전하시겠습니까?");
                System.out.print("충전 금액 : ");
                coin += scan.nextInt();
                // 1-2 메뉴 선택
            } else if (mainCheck == 2) {
                String menu = null;
                if (coin == 0) {
                    System.out.println("잔액이 없습니다.");
                    System.out.println();
                    continue;
                } else {
                    int menuCheck = 0;
                    int menuAgain = 0;
                    String first = null;
                    String second = null;
                    System.out.println();
                    System.out.println("1 . 아메리카노 [ 1,000 ]");
                    System.out.println("2 . 라떼 [ 1,500 ]");
                    System.out.println("3 . 티 [ 1,200 ]");
                    System.out.println("4 . 음료 [ 1,500 ]");
                    System.out.print("→ ");
                    menuCheck = scan.nextInt();
                    if (menuCheck == 1) {
                        if (coin <= 1000) {
                            System.out.println("잔액이 부족합니다.");
                            System.out.println();
                            continue;
                        } else {
                            System.out.println("확인 : \"아메리카노\"를 고르셨습니다.");
                            coin -= 1000;
                            menu = "아메리카노";
                        }
                    } else if (menuCheck == 2) {
                        if (coin <= 1500) {
                            System.out.println("잔액이 부족합니다.");
                            System.out.println();
                            continue;
                        } else {
                            System.out.println("확인 : \"라떼\"를 고르셨습니다.");
                            coin -= 1500;
                            menu = "라떼";
                        }
                    } else if (menuCheck == 3) {
                        if (coin <= 1200) {
                            System.out.println("잔액이 부족합니다.");
                            System.out.println();
                            continue;
                        } else {
                            System.out.println("확인 : \"티\"를 고르셨습니다.");
                            coin -= 1200;
                            menu = "티";
                        }
                    } else if (menuCheck == 4) {
                        if (coin <= 1500) {
                            System.out.println("잔액이 부족합니다.");
                            System.out.println();
                            continue;
                        } else {
                            System.out.println("확인 : \"음료\"를 고르셨습니다.");
                            coin -= 1500;
                            menu = "음료";
                        }
                    }
                }

                // 온도와 크기 선택
                System.out.println();
                System.out.println("온도 : ICE / HOT");
                System.out.println("크기 : SHORT / TALL / GRANDE");
                System.out.println("온도와 크기를 선택해주세요.");
                System.out.print("→ ");

                // 1-2-1(1) 온도와 크기 값으로 넣기
                String first = scan.next();
                String second = scan.next();

                // 1-2-1(2) 온도와 크기 자동으로 배치
                if ((first.equalsIgnoreCase("ice")) || (first.equalsIgnoreCase("HOT"))) {
                    myCoffeeDegree = first;
                    myCoffeeSize = second;
                } else {
                    myCoffeeDegree = second;
                    myCoffeeSize = first;
                }

                // 1-2-1(3) 음료, 온도, 크기 재확인
                System.out.println();
                System.out.println("음료 : " + menu);
                System.out.println("온도 : " + myCoffeeDegree.toUpperCase());
                System.out.println("크기 : " + myCoffeeSize.toUpperCase());
                System.out.println();
                try {
                    Thread.sleep(500);
                    System.out.println("현재 커피가 나오고 있습니다.");
                    for (int i = 1; i <= 3; i++) {
                        int time = 4;
                        time -= i;
                        Thread.sleep(500);
                        System.out.println(time);
                    }
                    Thread.sleep(500);
                    System.out.println("커피가 추출되었습니다.");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (mainCheck == 3) {
                System.out.println();
                System.out.println("시스템을 종료합니다.");
                flag = false;
            }
            System.out.println();
        }
    }
}
