package DAY_16;

public class 삼각형 extends 도형 implements 도형인터페이스 {

    public 삼각형() {
        System.out.println("생성자 : 삼각형");
    }

    public 삼각형(String color, String name) {
        super(color, name);
    }

    public void draw() {
        System.out.println("삼각형을 그린다.");
    }
}
