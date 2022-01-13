package DAY_09;

import java.util.Scanner;

public class Example_self {

    public static void printSystemln(String message) {
        System.out.println("𝑺𝒀𝑺𝑻𝑬𝑴 : " + message);
    }

    public static void printSystem(String message) {
        System.out.print("𝑺𝒀𝑺𝑻𝑬𝑴 : " + message);
    }

    public static void main(String[] args) {
        boolean loop = true;
        boolean seloop = true;
        String[] subject = {"C", "C++", "C#", "JAVA", "Python"};
        String[] student = new String[10];
        int[][] scores = new int[10][5];
        int count = 0;
        String studentname = "학생명";
        Scanner scan = new Scanner(System.in);

        while (loop) {
            // 사용자로부터 명칭/번호 입력받음
            String choice = null;
            System.out.println("➖ ➖ ➖ ➖ ➖ ➖ ➖ ➖ ➖ ➖");
            printSystem("학점 프로그램 실행");
            System.out.println("1 . 등록\n2 . 출력\n3 . 수정\n4 . 삭제\n5 . 종료");
            System.out.println("➖ ➖ ➖ ➖ ➖ ➖ ➖ ➖ ➖ ➖");
            System.out.print("𝑵𝒖𝒎𝒃𝒆𝒓 𝒐𝒓 𝑾𝒐𝒓𝒅 > ");
            choice = scan.nextLine();
            System.out.println();

            if (choice.equalsIgnoreCase("등록") || choice.equals("1")) {  // 등록 , 1번 선택시
                if (count < student.length) { // 추가한 학생의 수가 전체 길이보다 작을 경우
                    for (int x = count; x < student.length; x++) {
                        for (int i = count; i < student.length; i++) { // 학생의 점수 받기
                            System.out.printf("%4s > ", studentname);
                            student[count] = scan.nextLine(); // student[count]번째에 저장
                            for (int j = 0; j < scores[i].length; j++) {
                                System.out.printf("%7s > ", subject[j]);
                                scores[i][j] = scan.nextInt();
                                scan.nextLine();
                            }
                            count++;

                            System.out.println();
                            System.out.print("𝑺𝒀𝑺𝑻𝑬𝑴 : 등록을 계속 진행하시겠습니까? (Y/N) > ");
                            String check = scan.nextLine();

                            if (check.trim().equalsIgnoreCase("n")) {
                                System.out.println("𝑺𝒀𝑺𝑻𝑬𝑴 : 등록을 종료합니다.");
                                System.out.println();
                                break;
                            } else if (count == student.length) {
                                System.out.println("𝑺𝒀𝑺𝑻𝑬𝑴 : 저장공간이 가득 찼습니다.");
                                System.out.println();
                                break;
                            } else if (!check.trim().equalsIgnoreCase("y")) {
                                System.out.println("𝑺𝒀𝑺𝑻𝑬𝑴 : 알 수 없는 선택입니다.");
                                System.out.println();
                                break;
                            } else {
                                System.out.println("𝑺𝒀𝑺𝑻𝑬𝑴 : 등록을 반복합니다.");
                                System.out.println();
                            }
                        }
                        x = student.length;
                    }
                }
            } else if (choice.equalsIgnoreCase("출력") || choice.equals("2")) {  // 출력 , 2번 선택시
                if (count != 0) {
                    System.out.println("𝑺𝒀𝑺𝑻𝑬𝑴 : 데이터 출력");
                    System.out.printf("%-7s", studentname); // 학생명 출력
                    for (int x = 0; x < subject.length; x++) {
                        System.out.printf("%-7s", subject[x]); // 과목들 일렬로 출력
                    }
                    System.out.println();
                    for (int i = 0; i < count; i++) {
                        System.out.printf("%-7s", student[i]);
                        for (int j = 0; j < scores[i].length; j++) {
                            System.out.printf("%-7s", scores[i][j]);
                        }
                        System.out.println();
                    }
                } else {
                    System.out.println("𝑺𝒀𝑺𝑻𝑬𝑴 : 데이터가 없습니다. 데이터를 등록해주세요.");
                }
                System.out.println();
            } else if (choice.equalsIgnoreCase("수정") || choice.equals("3")) {  // 수정 , 3번 선택시
                if (count != 0) {
                    System.out.println("𝑺𝒀𝑺𝑻𝑬𝑴 : 수정하실 데이터의 \'학생명\'을 입력해주세요.");
                    System.out.print(" > ");
                    String check = scan.nextLine();
                    int i;
                    for (i = 0; i < count; i++) { // 검색한 학생이 있는지 0~i까지 돌림
                        if (student[i].equalsIgnoreCase(check)) { // student[i]에 있는 값과 검색값이 동일한지 체크
                            System.out.printf("%-4s", studentname);
                            for (int a = 0; a < subject.length; a++) {
                                System.out.printf("%-7s", subject[a]);
                            }
                            System.out.println();
                            System.out.printf("%-4s", student[i]);
                            for (int j = 0; j < subject.length; j++) {
                                System.out.printf("%-7d", scores[i][j]);
                            }
                            break;
                        }
                    }
                    if (count == i) {
                        System.out.println("𝑺𝒀𝑺𝑻𝑬𝑴 : \'" + check + "\'의 데이터가 존재하지 않습니다.");
                        System.out.println();
                    }

                    while (seloop) {
                        System.out.println("𝑺𝒀𝑺𝑻𝑬𝑴 : 수정하실 데이터의 \'학생명\'을 입력해주세요.");
                        System.out.println("𝑺𝒀𝑺𝑻𝑬𝑴 : 종료를 원하실 경우 \'종료\'라고 입력해주세요.");
                        System.out.print(" > ");
                        String check1 = scan.nextLine();
                        if (check1.equals("종료")) {
                            seloop = false;
                            System.out.println("𝑺𝒀𝑺𝑻𝑬𝑴 : 수정을 종료합니다.");
                        } else {
                            for (int k = 0; k < count; k++) { // 검색한 학생이 있는지 0~i까지 돌림
                                if (check1.equalsIgnoreCase(student[k])) { // student[i]에 있는 값과 검색값이 동일한지 체크
                                    System.out.printf("%-4s", studentname);
                                    for (int a = 0; a < subject.length; a++) {
                                        System.out.printf("%-7s", subject[a]);
                                    }
                                    System.out.println();
                                    System.out.printf("%-4s", student[k]);
                                    for (int j = 0; j < subject.length; j++) {
                                        System.out.printf("%-7d", scores[k][j]);
                                    }
                                }
                                //i = count;
                            }
                            System.out.println("𝑺𝒀𝑺𝑻𝑬𝑴 : \'" + check1 + "\'의 데이터가 존재하지 않습니다.");
                        }
                    }
                } else {
                    System.out.println("𝑺𝒀𝑺𝑻𝑬𝑴 : 데이터가 없습니다. 데이터를 등록해주세요.");
                }
                System.out.println();
            } else if (choice.equalsIgnoreCase("삭제") || choice.equals("4")) {  // 삭제 , 4번 선택시
                if (count != 0) {
                    System.out.println("𝑺𝒀𝑺𝑻𝑬𝑴 : 삭제하실 데이터의 \'학생명\'을 입력해주세요.");
                    System.out.print(" > ");
                    String check = scan.nextLine();
                    for (int i = 0; i < count - 1; i++) { // 검색한 학생이 있는지 0~i까지 돌림
                        if (student[i].equalsIgnoreCase(check)) { // student[i]에 있는 값과 검색값이 동일한지 체크
                            System.out.printf("%-4s", studentname);
                            for (int a = 0; a < count - 1; a++) {
                                student[a] = student[a + 1];
                                for (int b = 0; b < subject.length; b++) {
                                    scores[a][b] = scores[a + 1][b];
                                }
                            }
                            count--;
                            System.out.println("𝑺𝒀𝑺𝑻𝑬𝑴 : 삭제가 완료되었습니다.");
                            System.out.println();
                            System.out.println("𝑺𝒀𝑺𝑻𝑬𝑴 : 데이터 출력");
                            System.out.printf("%-7s", studentname); // 학생명 출력
                            for (int x = 0; x < subject.length; x++) {
                                System.out.printf("%-7s", subject[x]); // 과목들 일렬로 출력
                            }
                            System.out.println();
                            for (int a1 = 0; a1 < count; a1++) {
                                System.out.printf("%-7s", student[a1]);
                                for (int j = 0; j < scores[a1].length; j++) {
                                    System.out.printf("%-7s", scores[a1][j]);
                                }
                                System.out.println();
                            }
                        }
                        //i = count;
                    }
                    System.out.println("𝑺𝒀𝑺𝑻𝑬𝑴 : \'" + check + "\'의 데이터가 존재하지 않습니다.");
                    System.out.println();
                } else if (choice.equalsIgnoreCase("종료") || choice.equals("5")) {  // 종료 , 5번 선택시
                    loop = false;
                    System.out.println("𝑺𝒀𝑺𝑻𝑬𝑴 : 학점 프로그램 종료");
                }

            }
        }
    }
}