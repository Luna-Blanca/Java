package DAY_07;

import java.util.ArrayList;
import java.util.Scanner;

public class Example3_Array_StudentData_UseClass {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Student> students = new ArrayList<>();

        // 1 . 첫 시작 문구
        System.out.println("\uD835\uDE82\uD835\uDE83\uD835\uDE84\uD835\uDE73\uD835\uDE74\uD835\uDE7D\uD835\uDE83 \uD835\uDE82\uD835\uDE72\uD835\uDE7E\uD835\uDE81\uD835\uDE74 \uD835\uDE73\uD835\uDE70\uD835\uDE83\uD835\uDE70");
        System.out.println("1 . \",\"는 사용하지 않도록 합니다.");
        System.out.println("2 . 입력이 다 끝난 이후에는 \"null\"을 입력해주시길 바랍니다.");

        // 2 . 끝낼 수 있는 무한루프 시작
        while (true) {
            System.out.print("학생명 , 국어 점수 , 수학 점수 , 영어 점수 를 입력해주세요. → ");

            String name = sc.next();
            // ↑ 입력을 받되, 'null'을 입력받으면 while문 종료
            if (name.equals("null"))
                break;

            Student std = new Student(name, sc.nextInt(), sc.nextInt(), sc.nextInt());
            // ↑ List에 학생명, 국어점수, 수학점수, 영어점수 넣기
            students.add(std);
            // ↑ List에 방금 입력받은 데이터를 추가
        }

        System.out.println();
        System.out.println("=======================================");
        System.out.println("!!! 학생의 성적 출력 !!!");
        System.out.println("이름 \t 국어 \t 수학 \t 영어 \t 총점 \t 평균");
        for (int j = 0; j < students.size(); j++) {
            Student student = students.get(j);
            System.out.print(student.name + "\t");
            System.out.print(student.korean + "\t");
            System.out.print(student.math + "\t");
            System.out.print(student.english + "\t");
            System.out.print(student.getTotal() + "\t");
            System.out.println(student.getAverage() + "\t");
        }
        System.out.println("=======================================");
    }

    private static class Student {
        public String name;
        public int korean;
        public int english;
        public int math;

        public Student(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        public int getTotal() {
            return (korean + english + math);
        }

        public double getAverage() {
            return (english + math + korean) / 3.0;
        }
    }
}
