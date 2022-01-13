package DAY_06;

public class Example6_9to9 {
    public static void main(String[] args) {
        int num1, num2 = 0;

        for (int i = 0; i < 20; i++) {
            System.out.println(i+"행을 시작합니다.");
            for (int j = 0; j < 9; j++) {
                System.out.println(i + " * " + j + " = " + (i * j));
            }
            System.out.println(" ");
        }
    }
}
