
public class Rect extends Figure{

    public Rect(float width, float height) {
        super(width, height);
        // TODO Auto-generated constructor stub
    }
    
    public float calcPerimeter() {
        //(가로+세로)*2
        return (width+height)*2;
    }
    
    public float calcArea() {
        //가로*세로
        return width*height;
    }

}
