package Chapter5;

public class AdvanceFor1 {
    public static void main(String[] args) {
        //int[][] scores = {{83, 80, 82, 90}, {90, 80, 77, 90,80}}
        int[] scores1 = {83, 80, 82, 90};
        int[] scores2 = {90, 88, 77, 90, 80};

        int var1 = 0;


        for (int i : scores1) {
            int var2 = 0;
            for (int j : scores2) {
                System.out.println("int[" + var1 + "][" + var2 + "] = " + i + ", " + j);
                var2++;
            }
            var1++;
        }
        System.out.println(" ");
    }
}
