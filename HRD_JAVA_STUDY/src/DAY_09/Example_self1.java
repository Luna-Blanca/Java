package DAY_09;

import java.util.Scanner;

public class Example_self1 {

    public static void printSystemln(String message) {
        System.out.println("πΊππΊπ»π¬π΄ : " + message);
    }

    public static void printSystem(String message) {
        System.out.print("πΊππΊπ»π¬π΄ : " + message);
    }

    public static void line() {
        System.out.println("β β β β β β β β β β");
    }

    public static void startmenu() {
        String[] menu = {"λ±λ‘", "μΆλ ₯", "μμ ", "μ­μ ", "μ’λ£"};
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + 1 + " . " + menu[i]);
        }
    }

    public static void main(String[] args) {
        boolean loop = true;
        boolean seloop = true;
        String[] subject = {"C", "C++", "C#", "JAVA", "Python"};
        String[] student = new String[10];
        int[][] scores = new int[10][5];
        int count = 0;
        String studentname = "νμλͺ";
        Scanner scan = new Scanner(System.in);

        while (loop) {
            // μ¬μ©μλ‘λΆν° λͺμΉ­/λ²νΈ μλ ₯λ°μ
            String choice = null;
            line();
            printSystemln("νμ  νλ‘κ·Έλ¨ μ€ν");
            startmenu();
            line();
            System.out.print("π΅πππππ ππ πΎπππ > ");
            choice = scan.nextLine();
            System.out.println();

            if (choice.equalsIgnoreCase("λ±λ‘") || choice.equals("1")) {  // λ±λ‘ , 1λ² μ νμ
                if (count < student.length) { // μΆκ°ν νμμ μκ° μ μ²΄ κΈΈμ΄λ³΄λ€ μμ κ²½μ°
                    for (int x = count; x < student.length; x++) {
                        for (int i = count; i < student.length; i++) { // νμμ μ μ λ°κΈ°
                            System.out.printf("%4s > ", studentname);
                            student[count] = scan.nextLine(); // student[count]λ²μ§Έμ μ μ₯
                            for (int j = 0; j < scores[i].length; j++) {
                                System.out.printf("%7s > ", subject[j]);
                                scores[i][j] = scan.nextInt();
                                scan.nextLine();
                            }
                            count++;

                            System.out.println();
                            System.out.print("πΊππΊπ»π¬π΄ : λ±λ‘μ κ³μ μ§ννμκ² μ΅λκΉ? (Y/N) > ");
                            String check = scan.nextLine();

                            if (check.trim().equalsIgnoreCase("n")) {
                                System.out.println("πΊππΊπ»π¬π΄ : λ±λ‘μ μ’λ£ν©λλ€.");
                                System.out.println();
                                break;
                            } else if (count == student.length) {
                                System.out.println("πΊππΊπ»π¬π΄ : μ μ₯κ³΅κ°μ΄ κ°λ μ°Όμ΅λλ€.");
                                System.out.println();
                                break;
                            } else if (!check.trim().equalsIgnoreCase("y")) {
                                System.out.println("πΊππΊπ»π¬π΄ : μ μ μλ μ νμλλ€.");
                                System.out.println();
                                break;
                            } else {
                                System.out.println("πΊππΊπ»π¬π΄ : λ±λ‘μ λ°λ³΅ν©λλ€.");
                                System.out.println();
                            }
                        }
                        x = student.length;
                    }
                }
            } else if (choice.equalsIgnoreCase("μΆλ ₯") || choice.equals("2")) {  // μΆλ ₯ , 2λ² μ νμ
                if (count != 0) {
                    System.out.println("πΊππΊπ»π¬π΄ : λ°μ΄ν° μΆλ ₯");
                    System.out.printf("%-7s", studentname); // νμλͺ μΆλ ₯
                    for (int x = 0; x < subject.length; x++) {
                        System.out.printf("%-7s", subject[x]); // κ³Όλͺ©λ€ μΌλ ¬λ‘ μΆλ ₯
                    }
                    System.out.println();
                    for (int i = 0; i < count; i++) {
                        System.out.printf("%-7s", student[i]);
                        for (int j = 0; j < scores[i].length; j++) {
                            System.out.printf("%-7s", scores[i][j]);
                        }
                        System.out.println();
                    }
                } else {
                    System.out.println("πΊππΊπ»π¬π΄ : λ°μ΄ν°κ° μμ΅λλ€. λ°μ΄ν°λ₯Ό λ±λ‘ν΄μ£ΌμΈμ.");
                }
                System.out.println();
            } else if (choice.equalsIgnoreCase("μμ ") || choice.equals("3")) {  // μμ  , 3λ² μ νμ
                if (count != 0) {
                    System.out.println("πΊππΊπ»π¬π΄ : μμ νμ€ λ°μ΄ν°μ \'νμλͺ\'μ μλ ₯ν΄μ£ΌμΈμ.");
                    System.out.print(" > ");
                    String check = scan.nextLine();
                    int i;
                    for (i = 0; i < count; i++) { // κ²μν νμμ΄ μλμ§ 0~iκΉμ§ λλ¦Ό
                        if (student[i].equalsIgnoreCase(check)) { // student[i]μ μλ κ°κ³Ό κ²μκ°μ΄ λμΌνμ§ μ²΄ν¬
                            System.out.printf("%-4s", studentname);
                            for (int a = 0; a < subject.length; a++) {
                                System.out.printf("%-7s", subject[a]);
                            }
                            System.out.println();
                            System.out.printf("%-4s", student[i]);
                            for (int j = 0; j < subject.length; j++) {
                                System.out.printf("%-7d", scores[i][j]);
                            }
                            break;
                        }
                    }
                    if (count == i) {
                        System.out.println("πΊππΊπ»π¬π΄ : \'" + check + "\'μ λ°μ΄ν°κ° μ‘΄μ¬νμ§ μμ΅λλ€.");
                        System.out.println();
                    }

                    while (seloop) {
                        System.out.println("πΊππΊπ»π¬π΄ : μμ νμ€ λ°μ΄ν°μ \'νμλͺ\'μ μλ ₯ν΄μ£ΌμΈμ.");
                        System.out.println("πΊππΊπ»π¬π΄ : μ’λ£λ₯Ό μνμ€ κ²½μ° \'μ’λ£\'λΌκ³  μλ ₯ν΄μ£ΌμΈμ.");
                        System.out.print(" > ");
                        String check1 = scan.nextLine();
                        if (check1.equals("μ’λ£")) {
                            seloop = false;
                            System.out.println("πΊππΊπ»π¬π΄ : μμ μ μ’λ£ν©λλ€.");
                        } else {
                            for (int k = 0; k < count; k++) { // κ²μν νμμ΄ μλμ§ 0~iκΉμ§ λλ¦Ό
                                if (check1.equalsIgnoreCase(student[k])) { // student[i]μ μλ κ°κ³Ό κ²μκ°μ΄ λμΌνμ§ μ²΄ν¬
                                    System.out.printf("%-4s", studentname);
                                    for (int a = 0; a < subject.length; a++) {
                                        System.out.printf("%-7s", subject[a]);
                                    }
                                    System.out.println();
                                    System.out.printf("%-4s", student[k]);
                                    for (int j = 0; j < subject.length; j++) {
                                        System.out.printf("%-7d", scores[k][j]);
                                    }
                                }
                                //i = count;
                            }
                            System.out.println("πΊππΊπ»π¬π΄ : \'" + check1 + "\'μ λ°μ΄ν°κ° μ‘΄μ¬νμ§ μμ΅λλ€.");
                        }
                    }
                } else {
                    System.out.println("πΊππΊπ»π¬π΄ : λ°μ΄ν°κ° μμ΅λλ€. λ°μ΄ν°λ₯Ό λ±λ‘ν΄μ£ΌμΈμ.");
                }
                System.out.println();
            } else if (choice.equalsIgnoreCase("μ­μ ") || choice.equals("4")) {  // μ­μ  , 4λ² μ νμ
                if (count != 0) {
                    System.out.println("πΊππΊπ»π¬π΄ : μ­μ νμ€ λ°μ΄ν°μ \'νμλͺ\'μ μλ ₯ν΄μ£ΌμΈμ.");
                    System.out.print(" > ");
                    String check = scan.nextLine();
                    for (int i = 0; i < count - 1; i++) { // κ²μν νμμ΄ μλμ§ 0~iκΉμ§ λλ¦Ό
                        if (student[i].equalsIgnoreCase(check)) { // student[i]μ μλ κ°κ³Ό κ²μκ°μ΄ λμΌνμ§ μ²΄ν¬
                            System.out.printf("%-4s", studentname);
                            for (int a = 0; a < count - 1; a++) {
                                student[a] = student[a + 1];
                                for (int b = 0; b < subject.length; b++) {
                                    scores[a][b] = scores[a + 1][b];
                                }
                            }
                            count--;
                            System.out.println("πΊππΊπ»π¬π΄ : μ­μ κ° μλ£λμμ΅λλ€.");
                            System.out.println();
                            System.out.println("πΊππΊπ»π¬π΄ : λ°μ΄ν° μΆλ ₯");
                            System.out.printf("%-7s", studentname); // νμλͺ μΆλ ₯
                            for (int x = 0; x < subject.length; x++) {
                                System.out.printf("%-7s", subject[x]); // κ³Όλͺ©λ€ μΌλ ¬λ‘ μΆλ ₯
                            }
                            System.out.println();
                            for (int a1 = 0; a1 < count; a1++) {
                                System.out.printf("%-7s", student[a1]);
                                for (int j = 0; j < scores[a1].length; j++) {
                                    System.out.printf("%-7s", scores[a1][j]);
                                }
                                System.out.println();
                            }
                        }
                        //i = count;
                    }
                    System.out.println("πΊππΊπ»π¬π΄ : \'" + check + "\'μ λ°μ΄ν°κ° μ‘΄μ¬νμ§ μμ΅λλ€.");
                    System.out.println();
                } else if (choice.equalsIgnoreCase("μ’λ£") || choice.equals("5")) {  // μ’λ£ , 5λ² μ νμ
                    loop = false;
                    System.out.println("πΊππΊπ»π¬π΄ : νμ  νλ‘κ·Έλ¨ μ’λ£");
                }

            }
        }
    }
}