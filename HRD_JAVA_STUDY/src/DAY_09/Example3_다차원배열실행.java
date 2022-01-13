package DAY_09;

public class Example3_다차원배열실행 {
    public static void main(String[] args) {
        int[][] sc = new int[3][3];

        sc[0][1] = 100;
        sc[0][2] = 200;

        for (int i = 0; i < sc.length; i++) {
            for (int j = 0; j < sc[i].length; j++) {
                System.out.println("sc[" + i + "][" + j + "] = " + sc[i][j]);
            }
        }
        System.out.println();

        System.out.println("=== 3차원 배열");
        int[][][] sc1 = new int[5][5][5];
        for (int i = 0; i < sc1.length; i++) {
            for (int j = 0; j < sc1[i].length; j++) {
                System.out.println(" * sc1[" + i + "][" + j + "]" );
                for (int k = 0; k < sc1[j].length; k++) {
                    sc1[i][j][k] = (int) (Math.random() * 100);
                    System.out.println("sc1[" + i + "][" + j + "][" + k + "] = " + sc1[i][j][k]);
                }
            }
        }
    }
}
