package DAY_16;

public abstract class 도형 {  //abstract class는 객체 생성 불가능, 즉 생성자 의미 X
    String 색상;
    String 이름;

    public 도형() {
        System.out.println("생성자 : 도형");
    }

    public 도형(String color, String name) {
        this.색상 = color;
        this.이름 = name;
    }

    public String get색상() {
        return 색상;
    }

    public void set색상(String 색상) {
        this.색상 = 색상;
    }

    public void 그린다() {
        System.out.println(색상 + " " + 이름 + "을 그린다");
    }

    public void draw() {
        System.out.println("도형을 그린다.");
    }

    //abstract public void draw();
}
