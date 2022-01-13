
public class Circle extends Figure{

    private float PI = 3.14f;
    public Circle(float width, float height) {
        super(width, height);
        // TODO Auto-generated constructor stub
    }
    public float calcPerimeter() {
        // 2*pi*반지름
        return (float) (PI*width);
    }
    
    public float calcArea() {
        // pi * 반지름 * 반지름
        return (float) (PI * (width*0.5) * (width*0.5));
    }
    
}
