package DAY_06;

import java.util.ArrayList;
import java.util.Scanner;

public class Example9_checkNumber {
    public static void main(String[] args) {

//        boolean flag = true;
//        int[] number = new int[5];
//
//        Scanner scan = new Scanner(System.in);
//        System.out.print("숫자를 5개 입력해주세요. → ");
//
//        while (flag) {
//            for (int i = 0; i < number.length; i++) {
//                number[i] = scan.nextInt();
//                if (number[i] != 0) {
//                    System.out.println("현재의 숫자는 " + number[i] + "입니다.");
//                } else {
//                    System.out.println("현재의 숫자는 0 입니다.");
//                    System.out.println("0이라는 숫자는 제가 판독하기 어려운 값 입니다.");
//                    flag = false;
//                }
//            }
//        }
//        System.out.println("모든 숫자에 대한 판독이 끝났습니다.");
//
//        scan.close();

        boolean flag = true;
        int[] number = new int[5];

        Scanner scan = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();

        System.out.print("숫자를 5개 입력해주세요. → ");
        int arr1 = Integer.parseInt(scan.nextLine());

        while (flag) {
            for (int i = 0; i < arr1; i++) {
                String input = scan.nextLine();
                list.add(input);
                if (!input.equals("0")) {
                    System.out.println("현재의 숫자는 " + input + "입니다.");
                } else {
                    System.out.println("현재의 숫자는 0 입니다.");
                    System.out.println("0이라는 숫자는 제가 판독하기 어려운 값 입니다.");
                    flag = false;
                }
            }
        }
        System.out.println("모든 숫자에 대한 판독이 끝났습니다.");

        scan.close();

    }
}
