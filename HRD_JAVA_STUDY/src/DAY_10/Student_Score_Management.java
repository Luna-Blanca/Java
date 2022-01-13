package DAY_10;

import java.util.Scanner;

public class Student_Score_Management {
    public static void main(String[] args) {
        startMenu startMenu = new startMenu();

        boolean flag = true;
        Scanner scan = new Scanner(System.in);


        while(flag) {
            String choice = null;

            startMenu.line();
            startMenu.printSystemln("학생 성적 관리 프로그램");
            startMenu.menu();
            startMenu.line();
            System.out.print("𝑵𝒖𝒎𝒃𝒆𝒓 𝒐𝒓 𝑾𝒐𝒓𝒅 > ");
            choice = scan.nextLine();
            System.out.println();


        }
    }
}
