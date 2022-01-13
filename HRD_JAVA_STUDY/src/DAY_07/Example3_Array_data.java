package DAY_07;

import java.util.Arrays;
import java.util.Scanner;

public class Example3_Array_data {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("넣으실 데이터의 수를 입력해주세요. → ");
        int num = scan.nextInt();

        String[] str = new String[num];


        for(int i = 0; i<str.length; i++) {
            System.out.print((i+1) + "번째 데이터를 입력해주세요 → ");
            str[i] = scan.next();
            System.out.println((i+1) + "번째 데이터 입력이 완료했습니다.");
        }

        System.out.println(Arrays.toString(str));
    }
}
