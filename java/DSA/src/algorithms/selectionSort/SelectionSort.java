package algorithms.selectionSort;

import java.util.Arrays;

public class SelectionSort {

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
     }

    public static void main(String[] args) {
        int[] arr = {10, 2, 4, 12, 123, 125, 4323, 121};

        selectionSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
