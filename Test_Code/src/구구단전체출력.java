import java.util.Scanner;

public class 구구단전체출력 {
    public static void printDan(int a) {
        System.out.println(a + "단");
        for (int i = 1; i < 10; i++) {
            System.out.println(a + "*" + i + "=" + i * a);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("첫번째 숫자를 입력해주세요 : ");
        int a = scan.nextInt();
        System.out.print("마지막 숫자를 입력해주세요 : ");
        int b = scan.nextInt();
        for (int i = a; i <= b; i++) {
            printDan(i);
        }
    }
}
