package CODING_TEST;

import java.sql.SQLOutput;

public class Multiplier {
    public static void main(String[] args) {
        String result = "";
        boolean find = true;

        while (find) {
            int num = (int) (Math.random() * 100);
            if (num == 100) {
                find = true;
            } else {
                result = String.valueOf(num);
                int num2 = (int) (Math.random() * 10000);
                int length = (int)(Math.log10(num2)+1);
                if (length == 4) {
                    String changenum = String.valueOf(num2);
                    char[] eachnum = changenum.toCharArray();
                    for (int i = 0; i < 4; i++) {
                        String a = String.valueOf(eachnum[i]);
                        System.out.println(a);
                        System.out.println(eachnum[i]);
                        String code;
                        if (a.equals("2") || a.equals("3")) {
                            code = "T";
                        } else if (a.equals("4") || a.equals("5")) {
                            code = "F";
                        } else if (a.equals("6") || a.equals("7")) {
                            code = "S";
                        } else if (a.equals("1") || a.equals("8")) {
                            code = "E";
                        } else {
                            code = "N";
                        }
                        result += code;
                    }
                    find = false;
                } else {
                    find = true;
                }
            }
        }

        System.out.println(result);
    }
}
