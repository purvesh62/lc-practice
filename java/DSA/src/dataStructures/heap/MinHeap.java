package dataStructures.heap;

import java.util.ArrayList;
import java.util.List;

public class MinHeap {
    private List<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }

    /*
     * Helper functions
     * */

    public List<Integer> getHeap() {
        return new ArrayList<>(heap);
    }

    private int leftChild(int index) {
        return (index * 2) + 1;
    }

    private int rightChild(int index) {
        return (index * 2) + 2;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private void swap(int index1, int index2) {
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    private void shrink(int index) {
        int minIndex = index;
        int size = heap.size();
        while (true) {
            int leftChild = leftChild(minIndex);
            int rightChild = rightChild(minIndex);

            if (leftChild < size && heap.get(minIndex) > heap.get(leftChild)) {
                minIndex = leftChild;
            }

            if (rightChild < size && heap.get(minIndex) > heap.get(rightChild)) {
                minIndex = rightChild;
            }

            if (index != minIndex) {
                swap(index, minIndex);
                index = minIndex;
            } else {
                break;
            }
        }
    }

    /*
     * Functional methods
     * */
    public void insert(int value) {
        heap.add(value);
        int current = heap.size() - 1;

        while (current > 0 && heap.get(current) < heap.get(parent(current))) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public Integer remove() {
        if (heap.size() == 0) {
            return null;
        }

        if (heap.size() == 1) {
            return heap.remove(0);
        }

        int minValue = heap.get(0);
        heap.set(0, heap.remove(heap.size() - 1));
        shrink(0);
        return minValue;
    }
}
