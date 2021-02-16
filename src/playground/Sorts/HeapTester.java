package playground.Sorts;


public class HeapTester {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Heap<Integer> myHeap = new Heap<Integer>(arr);

        myHeap.printHeap();

        myHeap.buildHeap();
        myHeap.printHeap();

        System.out.println(myHeap.getMax());

        // System.out.println(myHeap.extractMax());

        myHeap.increseKey(7, 18);
        myHeap.printHeap();

        System.out.println(myHeap.extractMax());

        myHeap.insertElement(20);

        myHeap.heapSort();

    }
}
