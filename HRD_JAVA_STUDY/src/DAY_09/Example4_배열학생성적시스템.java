package DAY_09;

import java.util.Scanner;

public class Example4_배열학생성적시스템 {
    public static void main(String[] args) {
        System.out.println("--------------------");
        System.out.println("성적관리 프로그램 : 1차원 배열");
        System.out.println("1 . 등록 2 . 출력 3 . 수정 4 . 삭제 5 . 종료");
        System.out.println("--------------------");

        Scanner scan = new Scanner(System.in);
        String[] sublist = {"국어", "수학", "영어", "자바", "파이썬"};
        String[] namelist = new String[3];
        int[][] scorelist = new int[3][5];
        boolean flag = true;
        int count = 0;

        while (flag) {
            System.out.print("메뉴선택 > ");
            int menu = scan.nextInt();

            switch (menu) {
                case 1:
                    System.out.println("등록");
                    if (count < namelist.length) {
                        for (int i = count; i < namelist.length; i++) {
                            // 학생명 입력
                            System.out.print("학생명 > ");
                            namelist[i] = scan.next();
                            int tot = 0;

                            // 점수 입력
                            for (int j = 0; j < scorelist[i].length; j++) {
                                if (j < sublist.length) {
                                    System.out.print(sublist[j] + "> ");  // 과목출력
                                    scorelist[i][j] = scan.nextInt();  // 점수입력
                                    tot += scorelist[i][j];  //입력받은 점수를 누적 합산
                                } else if (j == sublist.length) {
                                    scorelist[i][j] = tot;
                                } else if (j == sublist.length + 1) {
                                    scorelist[i][j] = tot / sublist.length;
                                }
                                /*
                                if (j == 0) {
                                    System.out.print("국어점수 > ");
                                    scorelist[i][j] = scan.nextInt();
                                } else if (j == 1) {
                                    System.out.print("수학점수 > ");
                                    scorelist[i][j] = scan.nextInt();
                                } else if (j == 2) {
                                    System.out.print("영어점수 > ");
                                    scorelist[i][j] = scan.nextInt();
                                } else if (j == 3) {
                                    scorelist[i][j] = scorelist[i][0] + scorelist[i][1] + scorelist[i][2];
                                } else {
                                    scorelist[i][j] = (scorelist[i][3] / 3);
                                }
                                */
                            }
                            count++;
                            System.out.print("계속 진행하시겠습니까? (Y/N) > ");
                            String reg_con = scan.next();
                            if (reg_con.equalsIgnoreCase("n")) {
                                // 등록종료
                                i = namelist.length;
                                System.out.println("등록을 종료합니다.");
                            } else {
                                // 추가 등록 > 저장공간 확인
                                if (count == namelist.length) {
                                    System.out.println("저장공간이 부족합니다.");
                                }
                            }
                        }

                    } else {
                        System.out.println("저장공간이 가득 찼습니다.");
                    }
                    break;
                case 2:  // 출력
                    if (count != 0) {
                        System.out.println("학생명\t국어\t영어\t수학\t총점\t평균");

                        for (int i = 0; i < namelist.length; i++) {
                            System.out.print(namelist[i] + "\t");
                            for (int j = 0; j < scorelist[i].length; j++) {
                                System.out.print(scorelist[i][j] + "\t");
                            }
                            System.out.println();
                        }
                    } else {
                        System.out.println("데이터가 존재하지 않습니다.");
                    }
                    break;
                case 3:  // 수정
                    if (count != 0) {
                        System.out.print("수정할 학생명 > ");
                        String update_name = scan.next();


                        int idx = -1;
                        for (int i = 0; i < namelist.length; i++) {
                            if (namelist[i].equalsIgnoreCase(update_name)) {
                                idx = i;
                                i = namelist.length;
                            }
                        }

                        int tot = 0;
                        if (idx != -1) {
                            for (int i = 0; i < sublist.length; i++) {
                                System.out.println(sublist[i] + " > ");
                                scorelist[idx][i] = scan.nextInt();
                                tot += scorelist[idx][i];
                            }

                            // 중첩, 평균
                            scorelist[idx][sublist.length] = tot;
                            scorelist[idx][sublist.length + 1] = tot / sublist.length;

                        } else {
                            System.out.println("수정할 데이터가 존재하지 않습니다.");

                        }
                    }
                    break;
                case 4: // 삭제

                    if (count != 0) {

                    } else {
                        System.out.println("데이터가 존재하지 않습니다. 데이터를 등록해주세요.");

                    }
                    break;
                case 5:
                    System.out.println("종료");
                    flag = false;
                    break;
                default:
                    System.out.println("메뉴를 준비중");

            }
        }
        System.out.println("프로그램 종료");
    }
}
