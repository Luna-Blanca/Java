import java.util.Scanner;

public class 구구단 {
    public static void printDan(int a) {
        System.out.println(a + "단");
        for (int i = 1; i < 10; i++) {
            System.out.println(a + "*" + i + "=" + i * a);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("숫자를 입력해주세요 : ");
        int a = scan.nextInt();
        printDan(a);
    }
}
