package DAY_10;

/** set - 입력 받기 get - 반환 **/

public class ScoreBase {
    String name;
    int korean, english, math;
    int total;
    double avg;

    /** 이름 **/
    public void setName(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }

    /** 국어 **/
    public void setKorean(int korean){
        this.korean = korean;
    }
    public int getKorean() {
        return korean;
    }

    /** 영어 **/
    public void setEnglish(int english){
        this.english = english;
    }
    public int getEnglish() {
        return english;
    }

    /** 수학 **/
    public void setMath(int math) {
        this.math = math;
    }
    public int getMath() {
        return math;
    }

    /** 총합 **/
    public  void setTotal(int total) {
        this.total = total;
    }
    public int getTotal() {
        return korean + english + math;
    }

    /** 평균 **/
    public void setAvg(double avg) {
        this.avg = avg;
    }
    public double getAvg() {
        return getTotal() / 3;
    }
}
