package Chapter4;

public class IfElseIfElse {
    public static void main(String[] args) {
        int score = (int)(Math.random()*100);
        System.out.println("점수는 : " + score);

        if (score >= 90) {
            System.out.println("점수가 100~90 사이 입니다.");
            System.out.println("등급은 A 입니다.");
        } else if (score >= 80) {
            System.out.println("점수가 89~80 사이 입니다.");
            System.out.println("등급은 B 입니다.");
        } else if (score >= 70) {
            System.out.println("점수가 79~70 사이 입니다.");
            System.out.println("등급은 C 입니다.");
        } else {
            System.out.println("점수가 70 미만 입니다.");
            System.out.println("등급은 D 입니다.");
        }
    }
}
