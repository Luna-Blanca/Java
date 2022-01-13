package DAY_18.score_UI.Scoremgm;
/** set - 입력 받기 get - 반환 **/
public class ScoreVO {
    //Field
    String name;
    int kor, eng, math;

    //Constructor
    //Method
    public void setName(String name) {	this.name = name;	}
    public String getName() {	return name;	}
    public void setKor(int kor) { this.kor = kor; }
    public int getKor() { return kor; }
    public void setEng(int eng) {	this.eng = eng; }
    public int getEng() {	return eng;	}
    public void setMath(int math) {	this.math = math;	}
    public int getMath() {return math;}

    public int getTot() {
        return kor+eng+math;
    }

    public int getAvg() {
        return getTot()/3;
    }
}