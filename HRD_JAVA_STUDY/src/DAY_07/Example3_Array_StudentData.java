package DAY_07;

import java.util.Scanner;

public class Example3_Array_StudentData {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        while(flag) {

            System.out.print("데이터를 얼마나 받을까요? → ");
            int count = sc.nextInt();

            String[] nameList = new String[count];
            int[] Korean = new int[count];
            int[] English = new int[count];
            int[] Math = new int[count];

            for(int i = 0; i<count; i++) {
                System.out.print("학생명 , 국어 점수 , 수학 점수 , 영어 점수 를 입력해주세요. → ");
                nameList[i] = sc.next();
                Korean[i] = sc.nextInt();
                Math[i] = sc.nextInt();
                English[i] = sc.nextInt();

                System.out.println("등록을 계속 진행하시겠습니까? (Y/N) →");
                String check = sc.next();
                if(check.equals("n")) {
                    System.out.println("등록을 종료합니다.");
                    i = count;
                }
            }

            System.out.println("학생의 성적 출력");
            System.out.println("NAME \t KOREAN \t MATH \t ENGLISH");
            for(int j = 0; j<count; j++) {
                if(nameList[j] != null) {
                    System.out.print(nameList[j] + "\t");
                    System.out.print(Korean[j] + "\t");
                    System.out.print(Math[j] + "\t");
                    System.out.print(English[j] + "\t");
                }
            }
            System.out.println("=======================================");
        }
    }
}
