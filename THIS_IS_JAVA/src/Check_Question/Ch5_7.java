package Check_Question;

public class Ch5_7 {
    public static void main(String[] args) {
        int max = 0;
        int[] array = {1, 5, 3, 8, 2};

        for (int i = 0; i < array.length; i++) {
            if(max > array[i]) {
                max = max;
            } else {
                max = array[i];
            }
        }
        System.out.println("max : " + max);
    }
}
