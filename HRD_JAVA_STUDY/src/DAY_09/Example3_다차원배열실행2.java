package DAY_09;

public class Example3_다차원배열실행2 {
    public static void main(String[] args) {
        int[][] sc = new int[3][3];
        sc[0][1] = 100;
        sc[0][2] = 200;

        for (int[] arr : sc) {
            for (int num : arr) {
                System.out.print(num + "\t");
            }
            System.out.println();
        }
    }
}
