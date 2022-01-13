package DAY_09;

public class Example2_이차원배열 {
    public static void main(String[] args) {

        int[][] numList = new int[2][4];
        numList[0][2] = 100;
        numList[1] = new int[4];

        System.out.println("numList = " + numList);
        System.out.println("numList[0] = " + numList[0]);
        System.out.println("numList[1] = " + numList[1]);
        System.out.println("numList[0][2] = " + numList[0][2]);
    }
}
