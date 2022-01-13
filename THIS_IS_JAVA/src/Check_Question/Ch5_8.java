package Check_Question;

public class Ch5_8 {
    public static void main(String[] args) {
        int[][] array = {{95, 86}, {83, 92, 96}, {78, 83, 93, 87, 88}};

        int sum = 0;
        double avg = 0.0;
        int num1 = 0, num2 = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.println("int[" + i + "][" + j + "] = " + array[i][j]);
                num1 = array[i].length;
                sum += array[i][j];
            }
            num2 = num1 + num2;
        }

        avg = (double) sum / num2;

        System.out.println(" ");

        System.out.println("sum = " + sum);
        System.out.println("avg = " + avg);
    }
}
