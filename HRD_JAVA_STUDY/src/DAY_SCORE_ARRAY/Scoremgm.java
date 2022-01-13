package DAY_SCORE_ARRAY;

import java.util.Scanner;

public class Scoremgm {
    ScoreVO score;
    Scanner scan = new Scanner(System.in);
    //ScoreVO[] scorelist = new ScoreVO[3];  //3명의 학생저장
    ScoreVO[] scorelist;
    int count;

    //Constructor
    //Method

    /** 학생수 정의 **/
    public void init() {
        //boolean flag = true;
        //while(flag) {
        System.out.print("학생수를 입력해주세요>>");
        int number = scan.nextInt();
        if (number != 0) {
            scorelist = new ScoreVO[number];
            System.out.println("학생수----->>" + number);
            showMenu();
            //	flag = false;
        } else {
            System.out.println("학생수를 다시 입력해주세요");
            init();
        }
        //}//while

        //showMenu();
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
        if (count < scorelist.length) {
            //1. 한 학생의 정보 입력받아 저장하는 ScoreVO 객체 생성
            //ScoreVO score = new ScoreVO();
            score = new ScoreVO();

            //2. scan 객체를 이용하여 학생정보 입력받아 ScoreVO 객체에 저장
            System.out.print("이름>");
            score.setName(scan.next());
            System.out.print("국어>");
            score.setKor(scan.nextInt());
            System.out.print("영어>");
            score.setEng(scan.nextInt());
            System.out.print("수학>");
            score.setMath(scan.nextInt());

            //3. 학생의 정보가 저장이 되면 scorelist에 추가하고, count를 하나 증가시킨다.
            scorelist[count] = score;
            count++;
            System.out.println("-- 등록이 완료 되었습니다 --");
        } else {
            System.out.println("-- 저장 공간이 부족합니다 --");
        }

        choiceMenu();
    }

    /** 출력 **/
    public void show() {
        if (count != 0) {
            System.out.println("--------------------------------------------");
            System.out.println("학생명\t국어\t영어\t수학\t총점\t평균");
            System.out.println("--------------------------------------------");

//			for(int i=0;i<count;i++) {
//				ScoreVO score = scorelist[i];
//				System.out.print(score.getName()+"\t");
//				System.out.print(score.getKor()+"\t");
//				System.out.print(score.getEng()+"\t");
//				System.out.print(score.getMath()+"\t");
//				System.out.print(score.getTot()+"\t");
//				System.out.print(score.getAvg()+"\n");
//			}

            //향상된 for : for(요소의 데이터타입 변수 : 배열객체 ){  실행문;	}
            for (ScoreVO score : scorelist) {
                if (score != null) {
                    System.out.print(score.getName() + "\t");
                    System.out.print(score.getKor() + "\t");
                    System.out.print(score.getEng() + "\t");
                    System.out.print(score.getMath() + "\t");
                    System.out.print(score.getTot() + "\t");
                    System.out.print(score.getAvg() + "\n");
                }
            }
            System.out.println("--------------------------------------------");
        } else {
            System.out.println("-- 등록된 데이터가 존재하지 않습니다. 등록부터 진행해주세요 --");
        }


        choiceMenu();
    }

    /** 인덱스 검색 **/
    public int searchIndex(String label) {  //searchIndex("수정");   searchIndex("삭제");

        //1. 수정할 학생명 입력
        System.out.print(label + "- 학생명>");
        String name = scan.next();

        //2. 학생명 찾기 ---> 인덱스 반환
        int idx = -1;
        for (int i = 0; i < count; i++) { //scorelist에 들어있는 ScoreVO 객체의 name 값을 비교
            ScoreVO score = scorelist[i];
            if (name.equals(score.getName())) {
                idx = i;
                i = scorelist.length;
            }
        }

        return idx;
    }


    /** 수정 **/
    public void update() {
        if (count != 0) {
            int idx = searchIndex("수정");

            //3. 학생(유) --> 수정데이터 입력받아 해당 인덱스에 넣기
            //   학생(무) --> 해당 학생이 없음을 출력
            if (idx != -1) {
                ScoreVO score = scorelist[idx];
                System.out.print("국어>");
                score.setKor(scan.nextInt());
                //scorelist[idx].setKor(scan.nextInt());  //새로운 국어점수를 입력받아 기존의 국어점수로 수정
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
        if (count != 0) {
            int idx = searchIndex("삭제");

            //3. 학생(유) --> 해당 인덱스의 데이터를 삭제 후 앞으로 하나씩 인덱스 이동시킴
            //   학생(무) --> 해당 학생이 없음을 출력
            if (idx != -1) {
                //삭제 진행해 주세요
                for (int i = idx; i < scorelist.length; i++) {
                    if (i != (scorelist.length - 1)) {
                        scorelist[i] = scorelist[i + 1];
                    } else {
                        scorelist[i] = null;
                    }
                }
                count--;

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
