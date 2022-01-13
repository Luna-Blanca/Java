package DAY_10;
/** set - 입력 받기 get - 반환 **/
public class ScoreVO {
    String name;
    int kor, eng, math, tot;
    double avg;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }
    public int getKor() {
        return kor;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }
    public int getEng() {
        return eng;
    }

    public void setMath(int math) {
        this.math = math;
    }
    public int getMath() {
        return math;
    }

    public void setTot(int Tot) {
        this.tot = Tot;
    }
    public int getTot() {
        return kor+eng+math;
    }

    public void getAvg(double avg) {
        this.avg = avg;
    }
    public double getAvg() {
        return getTot()/3;
    }
}
