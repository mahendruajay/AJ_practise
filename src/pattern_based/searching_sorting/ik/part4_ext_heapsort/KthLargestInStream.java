package pattern_based.searching_sorting.ik.part4_ext_heapsort;

/*
Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.

        Implement KthLargest class:

        KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
        int add(int val) Returns the element representing the kth largest element in the stream.



        Example 1:

        Input
        ["KthLargest", "add", "add", "add", "add", "add"]
        [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
        Output
        [null, 4, 5, 5, 8, 8]

        Explanation
        KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
        kthLargest.add(3);   // return 4
        kthLargest.add(5);   // return 5
        kthLargest.add(10);  // return 5
        kthLargest.add(9);   // return 8
        kthLargest.add(4);   // return 8

*/


import pattern_based.searching_sorting.ik.part3_partition_ext_qsort.KthLargest;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class KthLargestInStream {

    Queue<Integer> minHeap;
    List<Integer> stream;
    int kthLargest;

    public KthLargestInStream(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        stream = IntStream.of(nums).boxed().collect(Collectors.toList());

        kthLargest = k;
        for (int i = 0; i < nums.length; i++) {
            if (minHeap.size() < k) {
                minHeap.offer(nums[i]);
            } else if (minHeap.size() == k && nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
    }

    public static void main(String[] args) {
        int[] input = {4, 5, 8, 2};
        KthLargestInStream kthLargestInStream = new KthLargestInStream(3, input);
        System.out.println(kthLargestInStream.add(3));
        System.out.println(kthLargestInStream.add(5));
        System.out.println(kthLargestInStream.add(10));
        System.out.println(kthLargestInStream.add(9));
        System.out.println(kthLargestInStream.add(4));


    }

    public int add(int val) {
        stream.add(val);
        if (minHeap.size() < kthLargest) {
            minHeap.offer(val);
        } else if (minHeap.size() == kthLargest && val > minHeap.peek()) {
            minHeap.poll();
            minHeap.offer(val);
        }
        return minHeap.peek();
    }

}
