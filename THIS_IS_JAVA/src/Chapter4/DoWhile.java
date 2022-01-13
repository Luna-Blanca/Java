package Chapter4;

import java.util.Scanner;

public class DoWhile {
    public static void main(String[] args) {
        System.out.println("메세지를 입력해주세요.");
        System.out.println("프로그램을 종료하려면 Q를 눌러주세요.");

        Scanner scanner = new Scanner(System.in);
        String inputString;

        do {
            System.out.println("> ");
            inputString = scanner.nextLine();
            System.out.println(inputString);
        } while (!inputString.equals("Q"));

        System.out.println();
        System.out.println("프로그램 종료");
    }
}
