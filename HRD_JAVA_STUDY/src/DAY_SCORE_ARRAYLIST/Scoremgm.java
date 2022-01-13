package DAY_SCORE_ARRAYLIST;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class Scoremgm {
    //Field
    ScoreVO score;
    Scanner scan = new Scanner(System.in);
    ArrayList<ScoreVO> scorelist;
    int count;

    //Constructor
    public Scoremgm() {
        init();
    }

    //Method

    /** 학생수 정의 **/
    public void init() {
        System.out.print("학생수를 입력해주세요>>");
        int number = scan.nextInt();
        if (number != 0) {
            scorelist = new ArrayList<ScoreVO>(number);
            System.out.println("학생수----->>" + number);
            showMenu();
        } else {
            System.out.println("학생수를 다시 입력해주세요");
            init();
        }
    }


    /** 메뉴출력 **/
    public void showMenu() {
        System.out.println("=================================================");
        System.out.println("   성적 관리 프로그램 : ScoreVO 객체 활용 ");
        System.out.println("-------------------------------------------------");
        System.out.println("  1.등록   2.출력  3.수정  4.삭제  5.종료\t");
        System.out.println("=================================================");

        choiceMenu();
    }

    /** 메뉴선택 **/
    public void choiceMenu() {
        System.out.print("메뉴선택>");
        int menu = scan.nextInt();

        switch (menu) {
            case 1:
                insert();    //등록
                break;
            case 2:
                show();        //출력
                break;
            case 3:
                update();    //수정
                break;
            case 4:
                delete();    //삭제
                break;
            case 5:
                quit();    //종료
                break;
            default:
                System.out.println("메뉴 준비중입니다.");
                choiceMenu();
        }//switch
    }

    /** 등록 **/
    public void insert() {
        score = new ScoreVO();

        System.out.print("이름>");
        score.setName(scan.next());
        System.out.print("국어>");
        score.setKor(scan.nextInt());
        System.out.print("영어>");
        score.setEng(scan.nextInt());
        System.out.print("수학>");
        score.setMath(scan.nextInt());

        scorelist.add(score);
        System.out.println("-- 등록이 완료 되었습니다 --");

        choiceMenu();
    }

    /** 출력 **/
    public void show() {
        if (scorelist.size() != 0) {
            System.out.println("--------------------------------------------");
            System.out.println("학생명\t국어\t영어\t수학\t총점\t평균");
            System.out.println("--------------------------------------------");

            //향상된 for : for(요소의 데이터타입 변수 : 배열객체 ){  실행문;	}
            for (ScoreVO score : scorelist) {
                //if(score != null) {
                System.out.print(score.getName() + "\t");
                System.out.print(score.getKor() + "\t");
                System.out.print(score.getEng() + "\t");
                System.out.print(score.getMath() + "\t");
                System.out.print(score.getTot() + "\t");
                System.out.print(score.getAvg() + "\n");
                //}
            }
            System.out.println("--------------------------------------------");
        } else {
            System.out.println("-- 등록된 데이터가 존재하지 않습니다. 등록부터 진행해주세요 --");
        }
        choiceMenu();
    }

    /** 인덱스 검색 **/
    public ScoreVO searchIndex(String label) {  //searchIndex("수정");   searchIndex("삭제");
        ScoreVO search_score = null;

        //1. 수정할 학생명 입력
        System.out.print(label + "- 학생명>");
        String name = scan.next();

        //2. 학생명 찾기 ---> 있는지, 없는지 체크 결과 반환
        for (ScoreVO score : scorelist) {
            if (score.getName().equals(name)) {
                search_score = score;
            }
        }

        return search_score;
    }


    /** 수정 **/
    public void update() {
        if (scorelist.size() != 0) {
            ScoreVO score = searchIndex("수정");

            if (score != null) {
                System.out.print("국어>");
                score.setKor(scan.nextInt());
                System.out.print("영어>");
                score.setEng(scan.nextInt());
                System.out.print("수학>");
                score.setMath(scan.nextInt());

                System.out.println(" -- 수정이 완료 되었습니다 --");

            } else {
                System.out.println("-- 학생명이 존재하지 않습니다 --");
            }

        } else {
            System.out.println("-- 등록된 데이터가 존재하지 않습니다. 등록부터 진행해주세요 --");
        }

        choiceMenu();
    }

    /** 삭제 **/
    public void delete() {
        if (scorelist.size() != 0) {
            ScoreVO score = searchIndex("삭제");

            if (score != null) {
                Iterator<ScoreVO> ie = scorelist.iterator();
                while (ie.hasNext()) {
                    ScoreVO ie_score = ie.next();
                    if (score == ie_score) {
                        ie.remove();
                    }
                }

                System.out.println("-- 삭제가 완료되었습니다 --");

            } else {
                System.out.println("-- 학생명이 존재하지 않습니다 --");
            }

        } else {
            System.out.println("-- 등록된 데이터가 존재하지 않습니다. 등록부터 진행해주세요 --");
        }

        choiceMenu();
    }

    /** 종료 **/
    public void quit() {
        System.out.print("정말로 종료하시겠습니까(y/n)>");
        String choice = scan.next();
        if (choice.equals("n")) {
            choiceMenu();
        } else {
            System.out.println("-- 프로그램을 종료합니다 --");
            System.exit(0);
        }

    }
}
