package DAY_09;

import java.util.Scanner;

public class Example4_도서관리 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[][] booklist = new String[3][4];
        String[] title = {"도서번호", "도서관", "저자", "가격"};
        boolean flag = true;
        int count = 0;

        while (flag) {
            System.out.print("메뉴 선택 > ");
            int menu = scan.nextInt();

            switch (menu) {
                case 1:  // 등록
                    if (count < booklist.length) {
                        for (int i = count; i < booklist.length; i++) {
                            for (int j = 0; j < booklist.length; j++) {
                                System.out.print(title[j] + " > ");
                                booklist[i][j] = scan.next();
                            }

                            count++;
                            System.out.print("등록을 계속 진행하시겠습니까? (Y/N) > ");
                            String answer1 = scan.next();

                            if (answer1.equalsIgnoreCase("n")) {
                                System.out.println("등록을 종료합니다.");
                                i = booklist.length;
                            } else {
                                if (count == booklist.length) {
                                    System.out.println("저장공간이 부족합니다.");
                                }
                            }
                        }
                    }
                    break;
                case 2: // 출력
                    if (count != 0) {
                        System.out.println("도서번호\t도서명\t저자\t가격");
                        for (int i = 0; i<booklist.length; i++) {
                            for (int j = 0; j < booklist[i].length; j++) {
                                System.out.print(booklist[i][j] + "\t");
                            }
                            System.out.println();
                        }
                    } else {
                        System.out.println("등록된 데이터가 없습니다. 데이터를 등록해주세요");
                    }
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    flag = false;
                    break;
                default:
            }
        }
    }
}
