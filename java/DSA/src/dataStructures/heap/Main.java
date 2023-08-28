package dataStructures.heap;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void maxHeapTest() {
        MaxHeap heap = new MaxHeap();
        heap.insert(96);
        heap.insert(76);
        heap.insert(81);
        heap.insert(56);
        heap.insert(61);
        heap.insert(51);
        heap.insert(66);
        System.out.println(heap.getHeap());
        heap.remove();
        System.out.println(heap.getHeap());
    }

    public static void minHeapTest() {
        MinHeap heap = new MinHeap();
        heap.insert(99);
        heap.insert(12);
        heap.insert(16);
        heap.insert(18);
        heap.insert(13);
        heap.insert(21);
        System.out.println(heap.getHeap());
        heap.remove();
        System.out.println(heap.getHeap());
    }

    public static int findKthSmallest(int[] nums, int k) {
        MaxHeap maxHeap = new MaxHeap();

        // Iterate over every number in the input array.
        for (int num : nums) {
            // Insert current number into the datastructures.heap.
            // Heap property is maintained after each insertion.
            maxHeap.insert(num);

            // Check if datastructures.heap size exceeds 'k'.
            if (maxHeap.getHeap().size() > k) {
                // If size exceeds 'k', remove the largest number.
                // Heap property is maintained after each removal.
                maxHeap.remove();
            }
        }

        // At this point, the datastructures.heap contains the smallest 'k' numbers.
        // The largest number in the datastructures.heap is the kth smallest number in the array.
        // Therefore, we remove and return it.
        return maxHeap.remove();
    }

    public static List<Integer> streamMax(int[] nums) {
        MaxHeap maxHeap = new MaxHeap();
        List<Integer> maxStream = new ArrayList<>();

        for (int num : nums) {
            maxHeap.insert(num);
            // The datastructures.heap's root is always the maximum, so we add it to the result list
            maxStream.add(maxHeap.getHeap().get(0));
        }

        return maxStream;
    }

    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {7, 10, 4, 3, 20, 15};
        int k1 = 3;
        System.out.println("Test case 1:");
        System.out.println("Expected output: 7");
        System.out.println("Actual output: " + findKthSmallest(nums1, k1));
        System.out.println();

        // Test case 2
        int[] nums2 = {2, 1, 3, 5, 6, 4};
        int k2 = 2;
        System.out.println("Test case 2:");
        System.out.println("Expected output: 2");
        System.out.println("Actual output: " + findKthSmallest(nums2, k2));
        System.out.println();


        // Test case 3
        int[] nums3 = {9, 3, 2, 11, 7, 10, 4, 5};
        int k3 = 5;
        System.out.println("Test case 3:");
        System.out.println("Expected output: 7");
        System.out.println("Actual output: " + findKthSmallest(nums3, k3));
        System.out.println();
    }
}
