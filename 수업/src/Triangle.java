
public class Triangle extends Figure{

    public Triangle(float width, float height) {
        super(width, height);
        // TODO Auto-generated constructor stub
    }
    public float calcPerimeter() {
        //(가로)*3
        return (width)*3;
    }
    
    public float calcArea() {
        //가로*세로*1/2
        return (float) (width*height*0.5);
    }
}
