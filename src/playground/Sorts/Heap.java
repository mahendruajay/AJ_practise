package playground.Sorts;

public class Heap<E extends Comparable<? super E>> {
    private E[] heap;
    private int heapSize;

    public Heap(E[] heap) {
        this.heap = heap;
        heapSize = 0;
    }

    public void buildHeap() {
        if (null == heap || heap.length <= 1) {
            return;
        }

        int mid = (0 + heap.length) / 2;

        heapSize = heap.length;

        for (int i = mid; i >= 0; i--) {
            heapify(i);
        }
    }

    private int getLeft(int index) {
        return (2 * index) + 1;
    }

    private int getRight(int index) {
        return (2 * index) + 2;
    }

    private int getParent(int index) {
        return (index - 1) / 2;
    }

    private void heapify(int index) {

        int leftIndex = getLeft(index);
        int rightIndex = getRight(index);
        int largest = index;

        if (leftIndex < heapSize
                && heap[leftIndex].compareTo(heap[largest]) == 1) {
            largest = leftIndex;
        }
        if (rightIndex < heapSize
                && heap[rightIndex].compareTo(heap[largest]) == 1) {
            largest = rightIndex;
        }

        if (index != largest) {
            E temp = heap[index];
            heap[index] = heap[largest];
            heap[largest] = temp;
            heapify(largest);
        }

    }

    public E getMax() {
        if (heapSize > 0) {
            return heap[0];
        }
        return null;
    }

    public E extractMax() {
        if (heapSize > 0) {
            E max = heap[0];
            heap[0] = heap[heapSize - 1];
            heapSize--;
            heapify(0);

            return max;
        }
        return null;
    }

    public void increseKey(int index, E key) {
        if (heapSize > 0 && index < heapSize) {
            if (heap[index].compareTo(key) == 1) {
                return;
            } else {
                heap[index] = key;

                int parent = getParent(index);
                while (index > 0 && heap[parent].compareTo(heap[index]) == -1) {
                    E temp = heap[index];
                    heap[index] = heap[parent];
                    heap[parent] = temp;

                    index = parent;
                    parent = getParent(index);
                }
            }
        }
    }

    public void insertElement(E data) {
        if (heapSize == heap.length) {
            return;
        }

        heapSize++;
        heap[heapSize - 1] = data;

        int index = heapSize - 1;
        int parent = getParent(index);

        while (index > 0 && heap[parent].compareTo(heap[index]) == -1) {
            E temp = heap[index];
            heap[index] = heap[parent];
            heap[parent] = temp;

            index = parent;
            parent = getParent(index);
        }

    }

    public void heapSort() {
        for (int i = heapSize - 1; i >= 0; i--) {
            E temp = heap[0];
            heap[0] = heap[heapSize - 1];
            heap[heapSize - 1] = temp;
            heapSize--;

            heapify(0);
        }

        for (int i = 0; i < heap.length; i++) {
            System.out.print(heap[i] + ", ");
        }

    }

    public void printHeap() {
        for (int i = 0; i < heap.length; i++) {
            System.out.print(heap[i] + ", ");
        }

        System.out.println();
    }
}
