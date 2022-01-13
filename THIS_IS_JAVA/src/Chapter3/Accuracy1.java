package Chapter3;

public class Accuracy1 {
    public static void main(String[] args) {
        int apple = 1;
        double pieceUnit = 0.1;
        int number = 7;

        double result = apple - number*pieceUnit;

        System.out.println("사과 1 개에서");
        System.out.println("0.7 조각을 제외하면");
        System.out.println(result + "조각이 남는다.");
    }
}
