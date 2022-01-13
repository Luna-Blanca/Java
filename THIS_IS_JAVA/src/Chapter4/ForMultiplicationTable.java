package Chapter4;

public class ForMultiplicationTable {
    public static void main(String[] args) {
        //int j = 2;
        //System.out.println("*** " + j + "단" + " ***");

        for (int i = 2; i <= 9; i++) {
            System.out.println("*** " + i + "단" + " ***");
            for (int j = 2; j <= 9; j++) {
                System.out.println(i + " * " + j + " = " + (j * i));
            }
            System.out.println(" ");
        }
    }
}
