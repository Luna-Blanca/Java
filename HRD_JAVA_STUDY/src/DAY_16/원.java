package DAY_16;

public class 원 extends 도형 implements 도형인터페이스 {
    int 지름크기;

    public 원() {
        System.out.println("생성자 : 원");
    }

    public 원(String color, String name) {
        super(color, name);
    }

    public int get지름크기() {
        return 지름크기;
    }

    public void set지름크기(int 지름크기) {
        this.지름크기 = 지름크기;
    }

    public void draw() {
        System.out.println("원을 그린다.");
    }
}
