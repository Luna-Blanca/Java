package DAY_09;

import java.util.Scanner;

public class Example1 {
    public static void main(String[] args) {

        int num = 100;
        int[] numlist = new int[3];
        System.out.println("numlist = " + numlist);
        System.out.println("numlist[0] = " + numlist[0]);

        Scanner[] scnlist = new Scanner[3];
        System.out.println("scnlist = " + scnlist);
        System.out.println("scnlist[0] = " + scnlist[0]);

        Scanner scan = new Scanner(System.in);
        scnlist[0] = scan;
        scnlist[1] = new Scanner(System.in);
        scnlist[2] = new Scanner(System.in);
        for(int i = 0; i<scnlist.length; i++) {
            System.out.println("scnlist[" + i + "] = " + scnlist[i]);
        }
    }
}
