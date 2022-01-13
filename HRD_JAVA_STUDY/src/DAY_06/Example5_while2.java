package DAY_06;

import java.util.Scanner;

public class Example5_while2 {
    public static void main(String[] args) {
        System.out.println("************** 성적관리 프로그램 **************");
        System.out.println("    등록(1)    ,    조회(2)    ,    종료(3)   ");
        System.out.println("************** 성적관리 프로그램 **************");

        Scanner scan = new Scanner(System.in);
        boolean flag = true;

        while (flag) {
            System.out.print("메뉴 선택 → ");
            int menu = scan.nextInt();

            switch (menu) {
                case 1:
                    System.out.println("등록\n");
                    break;
                case 2:
                    System.out.println("조회\n");
                    break;
                case 3:
                    System.out.println("종료\n");
                    flag = false;
                    break;
                default:
                    System.out.println("준비중인 사항입니다.\n");
            }
        }

        System.out.println("************** 프로그램 종료 **************");

    }
}
