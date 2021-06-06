package pattern_based.searching_sorting;

import java.util.Arrays;

public class Heap<E extends Comparable<? super E>> {

    private int heapSize;
    private E[] heap;

    public Heap(E[] heap) {
        this.heap = heap;
        this.heapSize = 0;
        printHeap();
        buildHeap();
        printHeap();

    }

    public E[] heapSort() {
        while (heapSize > 0) {
            swap(0, heapSize - 1);
            heapSize--;
            heapify(0);
        }
        printHeap();
        return Arrays.copyOf(heap, heap.length);
    }

    public void insert(E element) {

        if (heapSize == heap.length) {
            return;
        } else {
            heapSize++;
            heap[heapSize - 1] = element;

            int index = heapSize - 1;
            rollUpToParent(index);

        }
    }

    public void increaseKey(int index, E value) {
        if (heapSize > 0 && index < heapSize) {
            if (heap[index].compareTo(value) == 1) {
                return;
            } else {
                heap[index] = value;
                rollUpToParent(index);
            }
        }
        printHeap();
    }


    private void rollUpToParent(int index) {
        int parent = getParent(index);
        while (index > 0 && heap[parent].compareTo(heap[index]) == -1) {
            swap(index, parent);
            index = parent;
            parent = getParent(index);
        }
    }

    public E extractMax() {
        if (heapSize > 0) {
            E max = getMax();
            heap[0] = heap[heapSize - 1];
            heapSize--;
            heapify(0);
            return max;
        }
        return null;
    }

    public E getMax() {
        if (heapSize > 0) {
            return heap[0];
        }
        return null;
    }

    public void printHeap() {

        System.out.println("--- HEAP ---");
        int len = heap.length;
        int prev = 0;
        int rowElements = 0;
        while (len != 0) {
            prev = rowElements;
            rowElements = (rowElements * 2) + 1;
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = prev; (j < rowElements && j < heap.length); j++) {

                stringBuilder.append(heap[j]);

                stringBuilder.append("  ");
            }
            System.out.println(stringBuilder.toString());
            len = len / 2;
        }
        System.out.println("------");
    }

    private void buildHeap() {
        heapSize = heap.length;
        for (int i = heap.length / 2; i >= 0; i--) {
            heapify(i);
        }
    }

    private void heapify(int index) {

        int leftIndex = getLeftIndex(index);
        int rightIndex = getRightIndex(index);
        int largest = index;

        if (leftIndex < heapSize &&
                heap[leftIndex].compareTo(heap[largest]) == 1) {
            largest = leftIndex;
        }

        if (rightIndex < heapSize &&
                heap[rightIndex].compareTo(heap[largest]) == 1) {
            largest = rightIndex;
        }
        if (index != largest) {
            swap(index, largest);
            heapify(largest);
        }

    }

    private void swap(int some, int other) {
        E temp = heap[some];
        heap[some] = heap[other];
        heap[other] = temp;
    }

    private int getLeftIndex(int index) {
        return (2 * index) + 1;
    }

    private int getRightIndex(int index) {
        return (2 * index) + 2;
    }

    private int getParent(int index) {
        return (index - 1) / 2;
    }

    public static void main(String[] args) {
        int[] randomArray = new RandomArray(10).generateGivenBound(2, 22);
        Integer[] arr = new Integer[randomArray.length];
        for (int i = 0; i < randomArray.length; i++) {
            arr[i] = randomArray[i];
        }

//        Integer[] arr = {10, 2, 5, 6, 7, 1, 3, 11, 4};
        Heap<Integer> maxHeap = new Heap<Integer>(arr);

        maxHeap.increaseKey(5, 15);
        System.out.println("Get max is: " + maxHeap.getMax());
        Integer max = maxHeap.extractMax();
        maxHeap.printHeap();

        maxHeap.insert(34);

        maxHeap.printHeap();

        maxHeap.heapSort();
    }


}
