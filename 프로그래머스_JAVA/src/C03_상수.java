public class C03_상수 {
    public static void main(String[] args) {
        int i = 10;
        i = 5;
        System.out.println("i = " + i);

        final int A = 10;
        //final의 경우 상수이기에 값을 다시 바꿀 수 없다. 또한 대문자를 사용한다.
        System.out.println("A = " + A);

        double circleArea;
        final double PI = 3.14159;
        circleArea = 3 * 3 * PI;
        System.out.println("circleArea = " + circleArea);
    }
}
