package blind75.TopKFrequentElements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TopKFrequentElements {

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[k];

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        MaxHeap heap = new MaxHeap();
        for (int i : map.keySet()) {
            heap.insert(i, map.get(i));
        }

        for (int i = 0; i < k; i++) {
            arr[i] = heap.remove();
        }
        return arr;
    }

    public static void main(String[] args) {
        // Test 1
        int[] t1 = new int[]{1, 1, 1, 2, 2, 3, 5, 6};
        int k1 = 2;
        int[] exp1 = new int[]{1, 2};
        int[] op1 = topKFrequent(t1, k1);
        if (Arrays.equals(op1, exp1)) {
            System.out.println("Test Case 1: Success");
        } else {
            System.out.println("Test Case 1: Failed");
        }


        // Test 2
        int[] t2 = new int[]{1, 1, 1, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6};
        int k2 = 3;
        int[] exp2 = new int[]{5, 4, 6};
        int[] op2 = topKFrequent(t2, k2);
        if (Arrays.equals(op2, exp2)) {
            System.out.println("Test Case 2: Success");
        } else {
            System.out.println("Test Case 2: Failed");
        }
    }
}

class MaxHeap {

    public List<Node> heap;

    public class Node {
        public int value;
        public int frequency;

        public Node(int val, int freq) {
            value = val;
            frequency = freq;
        }
    }


    public MaxHeap() {
        heap = new ArrayList<>();
    }

    private void swap(int index1, int index2) {
        Node temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int left(int index) {
        return (index * 2) + 1;
    }

    private int right(int index) {
        return (index * 2) + 2;
    }

    public void insert(int value, int freq) {
        heap.add(new Node(value, freq));
        int currentIdx = heap.size() - 1;

        while (currentIdx > 0 && heap.get(currentIdx).frequency > heap.get(parent(currentIdx)).frequency) {
            swap(currentIdx, parent(currentIdx));
            currentIdx = parent(currentIdx);
        }
    }


    private void sinkDown(int index) {

        int maxValue = index;

        while (true) {
            int left = left(index);
            int right = right(index);

            if (left < heap.size() && heap.get(maxValue).frequency < heap.get(left).frequency) {
                maxValue = left;
            }

            if (right < heap.size() && heap.get(maxValue).frequency < heap.get(right).frequency) {
                maxValue = right;
            }

            if (maxValue != index) {
                swap(maxValue, index);
                index = maxValue;
            } else {
                return;
            }
        }
    }

    public Integer remove() {
        if (heap.size() == 0) {
            return null;
        } else if (heap.size() == 1) {
            return heap.remove(0).value;
        } else {
            Node max = heap.get(0);
            heap.set(0, heap.remove(heap.size() - 1));
            sinkDown(0);
            return max.value;
        }
    }
}
