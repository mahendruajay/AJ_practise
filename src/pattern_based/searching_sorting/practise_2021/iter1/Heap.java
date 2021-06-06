package pattern_based.searching_sorting.practise_2021.iter1;

import java.util.Arrays;

public class Heap {

    private int heapSize = 0;
    private int[] heap;

    private int getLeft(int i){
        return (2*i) + 1;
    }

    private int getRight(int i){
        return (2*i) + 2;
    }

    private int getParent(int i){
        return (i-1)/2;
    }

    public Heap(int[] input){
        heap = Arrays.copyOf(input, input.length);
        heapSize = heap.length;
        buildHeap();

    }

    private void buildHeap(){
        System.out.println("Before heap build  = " + Arrays.toString(heap));
        for(int i = heap.length/2; i>=0; i-- ){
            heapify(i);
        }
    }

    private void heapify(int i){
        int largest_index = i;
        int left_index = getLeft(i);

        if(left_index < heapSize && heap[left_index] > heap[largest_index]){
            largest_index = left_index;
        }
        int right_index = getRight(i);

        if(right_index < heapSize && heap[right_index] > heap[largest_index]){
            largest_index = right_index;
        }

        if(largest_index != i){
            swap(i, largest_index);
            heapify(largest_index);
        }

    }

    private boolean isHeapEmpty(){
        if(heapSize <= 0){
            return true;
        } else{
            return false;
        }
    }

    public int extractMax(){
        if (isHeapEmpty()){
            return Integer.MIN_VALUE;
        }

        int max = heap[0];
        swap(0, heapSize-1);
        heapSize--;
        heapify(0);
        return max;
    }

    public void sort(){
        while(!isHeapEmpty()){
            extractMax();
        }
    }

    public boolean increaseKey(int key, int value){
        if(key > heapSize-1 || value <= heap[key]){
            return false;
        }
        heap[key] = value;
        int parent_index = getParent(key);

        while(parent_index >=0 && heap[parent_index] < heap[key]){
            swap(key, parent_index);
            key = parent_index;
            parent_index = getParent(key);
        }

        return true;
    }

    public void printHeap(){
        System.out.print("Heap = [");
        for(int i=0; i< heapSize; i++){
            System.out.print(heap[i] + " ");
        }
        System.out.println("]");
        System.out.println("Heap Array: " + Arrays.toString(heap));
    }



    private void swap(int first, int second){
        int temp = heap[first];
        heap[first] = heap[second];
        heap[second] = temp;
    }

    public static void main(String[] args) {
        int[] input = {10,5,2,8,5,1};

        Heap heap = new Heap(input);
        heap.printHeap();

//        int max = heap.extractMax();
//        heap.sort();
        heap.increaseKey(5, 20);
        heap.printHeap();
        heap.increaseKey(0, 30);
        heap.printHeap();
    }
}
