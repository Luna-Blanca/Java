package Chapter3;

public class Accuracy2 {
    public static void main(String[] args) {
        int apple = 1;

        int totalPieces = apple * 10;
        int number = 7;
        int temp = totalPieces - number;

        double result = temp/10.0;

        System.out.println("사과 1 개에서");
        System.out.println("0.7 조각을 제외하면");
        System.out.println(result + " 조각이 남는다.");
    }
}
