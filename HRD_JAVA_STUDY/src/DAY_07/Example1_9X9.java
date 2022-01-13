package DAY_07;

public class Example1_9X9 {
    public static void main(String[] args) {

        for (int i = 0; i < 20; i++) {
            for(int j = 1; j<20; j++) {
                System.out.print(j + " * " + i + " = " + (i*j) + "\t");
            }
            System.out.println(" ");
        }
    }
}
