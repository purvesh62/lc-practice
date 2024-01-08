package algorithms.bubbleSort;

import java.util.Arrays;

public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 9, 8, 7, 6, 5};

        bubbleSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
