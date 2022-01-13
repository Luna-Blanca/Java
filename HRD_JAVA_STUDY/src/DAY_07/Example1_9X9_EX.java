package DAY_07;

import java.util.Scanner;

public class Example1_9X9_EX {
    public static void main(String[] args) {
        boolean flag = true;

        while(flag) {
            Scanner scan = new Scanner(System.in);
            System.out.println("종료를 원하실 경우 \"0 0\"을 입력해주세요");
            System.out.print("몇단부터 몇단까지 출력하시겠습니까? → ");

            int firstNum = scan.nextInt();
            int secondNum = scan.nextInt();
            int minNum = 0;
            int maxNum = 0;

            if (firstNum > secondNum) {
                minNum = secondNum;
                maxNum = firstNum;
            } else {
                minNum = firstNum;
                maxNum = secondNum;
            }

            int startNum = minNum;
            int endNum = maxNum;

            System.out.println();
            if (startNum != 0) {
                System.out.println("Console | 시작 숫자가 0이 아님을 확인했습니다.");
                if (endNum != 0) {
                    System.out.println("Console | 끝 숫자가 0이 아님을 확인했습니다.");
                    System.out.println();
                    for (int i = startNum; i <= endNum; i++) {
                        for (int j = 1; j < 10; j++) {
                            System.out.print(i + " X " + j + " = " + (j * i) + "\t");
                        }
                        System.out.println();
                    }
                    System.out.println();
                    System.out.println("Console | 모든 결과를 출력했습니다.");
                } else {
                    System.out.println("!!! 끝 숫자가 0이라 시스템을 종료합니다.");
                    flag = false;
                }
            } else {
                System.out.println("!!! 시작 숫자가 0이라 시스템을 종료합니다.");
                flag = false;
            }
            System.out.println();
        }
    }
}
