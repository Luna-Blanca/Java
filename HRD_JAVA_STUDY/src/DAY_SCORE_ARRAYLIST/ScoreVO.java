package DAY_SCORE_ARRAYLIST;

public class ScoreVO {
    String name;
    int kor, eng, math;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getTot() {
        return kor + eng + math;
    }

    public int getAvg() {
        return getTot()/3;
    }
}
