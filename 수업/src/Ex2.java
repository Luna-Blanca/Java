
public class Ex2 extends Figure{

    public Ex2(float width, float height) {
        super(width, height);
        // TODO Auto-generated constructor stub
    }
    /*
     * Figure라는 추상클래스에는 width, height가 변수가 있고,
     * 둘레구하기(calcPerimeter) , 넓이구하기(calcArea) 메소드가 있다.
     * 메소드의 인자는 없다. 삼각형, 사각형, 원(radius반지름은 width의 반으로 계산)을 구현해보시오.
     */
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Rect Rect1 = new Rect(50,20);
        Triangle tri1 = new Triangle(20, 10);
        Circle Circle1 = new Circle(10, 10);
        
        System.out.println(Rect1.calcPerimeter());
        System.out.println(Rect1.calcArea());
        System.out.println(tri1.calcPerimeter());
        System.out.println(tri1.calcArea());
        System.out.println(Circle1.calcPerimeter());
        System.out.println(Circle1.calcArea());
    }
    
    
     
}
