package DAY_08;

import java.util.Scanner;

/**
 * 내용
 * - 성적관리 프로그램의 메뉴 : [ 등록, 조회, 수정, 삭제, 종료 ] 5가지로 구성 . while문
 * - 데이터 저장방식 : 1차원배열
 * - 데이터 : 학생명, 국어, 영어, 수학, 총합, 평균
 * - 기능 구형
 * 1) 등록 : 한 학생의 정보를 입력받아 등록완료 후, 추가 등록여부 선택 ( Y / N )
 * 만약 등록종료 상태에서 추가 등록을 원할 경우의 입력은 현재까지의 인덱스 다음에 추가
 * !! 저장공간이 부족할 경우 메세지를 출력
 * 2) 출력 : 현재 저장된 데이터들 시각화
 * 3) 수정 :
 * 4) 삭제 :
 * 5) 종료 : 프로그램을 종료
 */

public class Example1 {
    public static void main(String[] args) {

        // ↓ 데이터 저장할 크기 선언
        Scanner sc = new Scanner(System.in);
        String[] name = new String[3];
        int[] korean = new int[3];
        int[] english = new int[3];
        int[] math = new int[3];
        int[] total = new int[3];
        double[] avg = new double[3];
        int count = 0;
        boolean flag = true;

        while (flag) {
            // ↓ 시작화면
            System.out.println();
            System.out.println("======================================================");
            System.out.println("\uD835\uDE82\uD835\uDE83\uD835\uDE84\uD835\uDE73\uD835\uDE74\uD835\uDE7D\uD835\uDE83 \uD835\uDE82\uD835\uDE72\uD835\uDE7E\uD835\uDE81\uD835\uDE74 \uD835\uDE73\uD835\uDE70\uD835\uDE83\uD835\uDE70");
            System.out.println("1 . 등록 \t 2 . 출력 \t 3 . 수정 \t 4 . 삭제 \t 종료");
            System.out.println("======================================================");
            System.out.print("Select the MENU → ");
            int menu = sc.nextInt();

            switch (menu) {
                case 1:  // 등록
                    System.out.println();
                    System.out.println("SYSTEM : \"등록\"을 선택하셨습니다.");
                    if (count == name.length) {
                        System.out.println("!!!!!! : 현재 데이터가 가득찼습니다.");
                    } else {
                        for (int i = count; i < name.length; i++) {
                            int errorCount = 1;
                            System.out.print("학생명 : ");
                            name[i] = sc.next();
                            System.out.print("국어점수 : ");
                            korean[i] = sc.nextInt();
                            System.out.print("영어점수 : ");
                            english[i] = sc.nextInt();
                            System.out.print("수학점수 : ");
                            math[i] = sc.nextInt();
                            total[i] = korean[i] + english[i] + math[i];
                            avg[i] = (korean[i] + english[i] + math[i]) / 3.0;
                            count++;

                            System.out.println();
                            System.out.print("추가 등록을 원하십니까? ( Y / N ) → ");
                            String answer = sc.next();
                            if (answer.equalsIgnoreCase("n")) {
                                i = name.length;
                                System.out.println("등록이 완료되었습니다.");
                            } else if (answer.equalsIgnoreCase("y")) {
                                if (count == name.length)
                                    System.out.println("!!!!!! : 데이터가 가득 찼습니다.");
                            } else {
                                System.out.println("SYSTEM : 명령을 받아들일 수 없습니다.");
                                break;  // !! 현이에게 물어보기 continue가 안되는 이유
                            }
                        }
                    }
                    break;

                case 2:  // 출력
                    System.out.println();
                    System.out.println("SYSTEM : \"출력\"을 선택하셨습니다.");
                    if (count != 0) {
                        System.out.println("-----------------------------------------");
                        for (int i = 0; i < name.length; i++) {
                            try {
                                if (name[i].equals("null"))
                                    i = name.length;
                                System.out.println((i + 1) + ". " + name[i] + "\t" + korean[i] + "\t" + english[i] + "\t" + math[i] + "\t" + total[i] + "\t" + avg[i]);
                            } catch (NullPointerException e) {
                            }
                        }
                        System.out.println("-----------------------------------------");
                    } else {
                        System.out.println("!!!!!! : 데이터가 존재하지 않습니다.");
                    }
                    break;
                case 3:  // 수정
                    System.out.println();
                    System.out.println("SYSTEM : \"수정\"을 선택하셨습니다.");
                    if (count == 0) {
                        System.out.println("SYSTEM : 수정할 수 있는 데이터가 없습니다.");
                    } else {
                        System.out.print("SYSTEM : 학생명을 입력해주세요. → ");
                        String sname = sc.next();
                        int idx = 0;
                        int sysCode = 0;
                        boolean updata_index = false;
                        for (int i = 0; i < count; i++) {
                            if (name[i].equalsIgnoreCase(sname)) {
                                System.out.println("-----------------------------------------");
                                System.out.println("SYSTEM : 현재의 DATA");
                                System.out.println((i + 1) + ". " + name[i] + "\t" + korean[i] + "\t" + english[i] + "\t" + math[i] + "\t" + total[i] + "\t" + avg[i]);
                                System.out.println("-----------------------------------------");
                                updata_index = true;
                                idx = i;
                                i = count;
                            } else {
                                sysCode++;
                            }
                        }
                        if (sysCode > 3) {
                            System.out.println("SYSTEM : 해당 학생의 데이터가 존재하지 않습니다.");
                        }
                        if (updata_index == true) {
                            System.out.print("학생명 : ");
                            name[idx] = sc.next();
                            System.out.print("국어점수 : ");
                            korean[idx] = sc.nextInt();
                            System.out.print("영어점수 : ");
                            english[idx] = sc.nextInt();
                            System.out.print("수학점수 : ");
                            math[idx] = sc.nextInt();
                            total[idx] = korean[idx] + english[idx] + math[idx];
                            avg[idx] = (korean[idx] + english[idx] + math[idx]) / 3.0;
                            System.out.println("-----------------------------------------");
                            System.out.println("SYSTEM : 변경된 DATA");
                            System.out.println((idx + 1) + ". " + name[idx] + "\t" + korean[idx] + "\t" + english[idx] + "\t" + math[idx] + "\t" + total[idx] + "\t" + avg[idx]);
                            System.out.println("-----------------------------------------");
                        }
                    }
                    break;
                case 4:  // 삭제
                    System.out.println();
                    System.out.println("SYSTEM : \"삭제\"을 선택하셨습니다.");
                    if (count == 0) {
                        System.out.println("SYSTEM : 삭제할 수 있는 데이터가 없습니다.");
                    } else {
                        System.out.print("SYSTEM : 학생명을 입력해주세요. → ");
                        String rname = sc.next();
                        int idx = 0;
                        int sysCode = 0;
                        boolean updata_index = false;
                        System.out.println();
                        for (int i = 0; i < count; i++) {
                            if (name[i].equalsIgnoreCase(rname)) {
                                System.out.println((i + 1) + ". " + name[i] + "\t" + korean[i] + "\t" + english[i] + "\t" + math[i] + "\t" + total[i] + "\t" + avg[i]);
                                updata_index = true;
                                idx = i;
                                i = count;
                            } else {
                                sysCode++;
                            }
                        }
                        if (sysCode > 3) {
                            System.out.println("SYSTEM : 해당 학생의 데이터가 존재하지 않습니다.");
                        }
                        if (updata_index == true) {
                            for (int i = idx; i < name.length; i++) {
                                if (i != name.length - 1) {
                                    if (!name[i].equals("null")) {
                                        name[i] = name[i + 1];
                                        korean[i] = korean[i + 1];
                                        english[i] = english[i + 1];
                                        math[i] = math[i + 1];
                                        total[i] = korean[i + 1] + math[i + 1] + english[i + 1];
                                        avg[i] = (korean[i + 1] + math[i + 1] + english[i + 1]) / 3.0;
                                    }
                                } else {
                                    name[i] = null;
                                    korean[i] = 0;
                                    english[i] = 0;
                                    math[i] = 0;
                                    total[i] = 0;
                                    avg[i] = 0;
                                }
                            }
                            System.out.println("SYSTEM : 삭제가 완료되었습니다.");
                            count--;
                        }
                    }
                    break;
                case 5:  // 종료
                    System.out.println();
                    System.out.print("SYSTEM : \"종료\"을 선택하셨습니다.");
                    flag = false;
                    break;
                default:
                    System.out.println("SYSTEM : 현재의 메뉴는 구성이 되어있지 않습니다.");
            }
        }
    }
}
