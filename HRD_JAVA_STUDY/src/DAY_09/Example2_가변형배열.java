package DAY_09;

public class Example2_가변형배열 {
    public static void main(String[] args) {
        int[][][] numList2 = new int[2][2][4];

        int[][] nL3 = new int[3][];
        nL3[0] = new int[1];
        nL3[1] = new int[2];
        nL3[2] = new int[3];

        System.out.println("nL3 = " + nL3);
        System.out.println("nL3[0] = " + nL3[0]);
        System.out.println("nL3[1] = " + nL3[1]);
        System.out.println("nL3[2] = " + nL3[2]);
    }
}
