import java.util.Arrays;

public class Bubblesort {
    public static void main(String[] args) {
        int arr[] = {1, 7, 2, 8, 9, 6, 0, 5, 3, 4};

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = n - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
