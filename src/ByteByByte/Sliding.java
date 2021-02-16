package ByteByByte;

import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

public class Sliding {

    void maxSlidingWindow(int A[], int n, int w, int B[]) {
        Deque<Integer> Q = new LinkedList<>();
        for (int i = 0; i < w; i++) {
            while (!Q.isEmpty() && A[i] >= A[Q.peekLast()])
                Q.pollLast();
            Q.offerLast(i);
        }
        for (int i = w; i < n; i++) {
            B[i - w] = A[Q.peekFirst()];
            while (!Q.isEmpty() && A[i] >= A[Q.peekLast()])
                Q.pollLast();
            while (!Q.isEmpty() && Q.peekFirst() <= i - w)
                Q.pollFirst();
            Q.offerLast(i);
        }
        B[n - w] = A[Q.peekFirst()];
    }

    public static void main(String[] args) {
        int[] arr = {6, 5, 4, 2, 3, 7};
        Collections.reverse(Arrays.asList(arr));
        int[] out = new int[15];
        Sliding sliding = new Sliding();
        sliding.maxSlidingWindow(arr, arr.length, 3, out);
    }

}
