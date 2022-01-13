package DAY_10;

import java.util.Scanner;

public class Scoremgm {
    ScoreVO score;
    Scanner scan = new Scanner(System.in);
    ScoreVO[] scorelist;
    int count;

    /** 학생수 정의 **/


    /** 메뉴 출력 **/
    public void showMenu() {
        System.out.println("-----------------------");
        System.out.println("성적 관리 프로그램 : 2차원 배열");
        System.out.println("1 . 등록\n2 . 출력\n3 . 수정\n4 . 삭제\n5 . 종료");
        System.out.println("-----------------------");
    }

    /** 메뉴 선택 **/
    public void choiceMenu() {
        System.out.println("메뉴선택 > ");
        int menu = scan.nextInt();

        switch(menu) {
            case 1: //등록
                insert();
                break;
            case 2: //출력
                show();
                break;
            case 3://수정
                update();
                break;
            case 4: //삭제
                delete();
                break;
            case 5: //종료
                exit();
                break;
            default: //기타
                System.out.println("메뉴를 준비중입니다.");
        }
    }

    /** 등록 **/
    public void insert() {

    }

    /** 출력 **/
    public void show() {

    }

    /** 수정 **/
    public void update() {

    }

    /** 삭제 **/
    public void delete() {

    }

    /** 종료 **/
    public void exit() {

    }
}
