package algorithms.insertionSort;

import java.util.Arrays;

public class InsertionSort {

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;

            while (j > -1 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 2, 1, 5, 123, 125, 4323, 121};

        insertionSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
