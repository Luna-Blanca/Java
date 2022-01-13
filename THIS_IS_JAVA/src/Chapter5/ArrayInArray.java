package Chapter5;

public class ArrayInArray {
    public static void main(String[] args) {

        int[][] mathScores = new int[2][3];
        for (int i = 0; i < mathScores.length; i++) {
            for (int j = 0; j < mathScores[i].length; j++) {
                System.out.println("mathScores[" + i + "][" + j + "] = " + mathScores[i][j]);
            }
        }
        System.out.println();

        int[][] englishScores = new int[2][];
        englishScores[0] = new int[2];
        englishScores[1] = new int[3];
        for (int i = 0; i < englishScores.length; i++) {
            for (int j = 0; j < englishScores[i].length; j++) {
                System.out.println("englishScores[" + i + "][" + j + "] = " + englishScores[i][j]);
            }
        }
        System.out.println();

        int[][] JavaScores = {{95, 87}, {92, 96, 88}};
        for (int i = 0; i < JavaScores.length; i++) {
            for (int j = 0; j < JavaScores[i].length; j++) {
                System.out.println("JavaScript[" + i + "][" + j + "] = " + JavaScores[i][j]);
            }
        }
    }
}
