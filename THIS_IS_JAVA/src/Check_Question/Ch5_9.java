package Check_Question;

import java.util.Scanner;

public class Ch5_9 {
    public static void main(String[] args) {
        boolean run = true;
        int studentNum = 0;
        int[] scores = null;
        Scanner scanner = new Scanner(System.in);

        while (run) {
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            System.out.println("1 . 학생수 | 2 . 점수입력 | 3 . 점수리스트 | 4 . 분석 | 5 . 종료");
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            System.out.println("선택 > ");

            int selectNo = scanner.nextInt();

            if (selectNo == 1) {
                System.out.println("학생수 >");
                studentNum = scanner.nextInt(); //학생 수 입력
                scores = new int[studentNum]; //입력받은 학생 수 만큼 배열 만들기
                System.out.println("학생수 > " + studentNum); //입력받은 학생 수 출력
                System.out.println(" ");
            } else if (selectNo == 2) {
                for (int i = 0; i < studentNum; i++) {
                    System.out.println("scores[" + i + "] = "); //scores[i번째] =
                    scores[i] = scanner.nextInt();
                }
            } else if (selectNo == 3) {
                for (int i = 0; i < studentNum; i++) {
                    System.out.println("scores[" + i + "] = " + scores[i]);
                }
            } else if (selectNo == 4) {
                System.out.println("분석을 시작합니다.");
                int sum = 0;
                int max = 0;
                for (int i = 0; i < studentNum; i++) {
                    sum = sum + scores[i];
                }
                System.out.println("전체 점수 = " + sum);
                for (int i = 0; i < studentNum; i++) {
                    if (max > scores[i]) {
                        max = max;
                    } else {
                        max = scores[i];
                    }
                }
                System.out.println("최고 점수 = " + max);
                double avg = (double) sum / scores.length;
                System.out.println("평균 점수 = " + avg);
            } else if (selectNo == 5) {
                System.out.println("시스템을 종료합니다.");
                break;
            }
            System.out.println();
        }
    }
}
