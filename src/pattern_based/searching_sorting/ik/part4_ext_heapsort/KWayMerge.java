package pattern_based.searching_sorting.ik.part4_ext_heapsort;

import java.util.*;

public class KWayMerge {

	Queue<QueueItem> minHeap = new PriorityQueue<>(new MergeComparator());

	public static void main(String[] args) {
		int[] arr1 = {3, 5, 10, 20, 100};
		int[] arr2 = {2, 35, 42};
		int[] arr3 = {1, 4, 7,};
		int[] arr4 = {9};

		KWayMerge kWayMerge = new KWayMerge();
		List<Integer> result = kWayMerge.kWayMerge(arr1, arr2, arr3, arr4);
		System.out.println("Result: " + result);

	}

	public List<Integer> kWayMerge(int[]... arr) {
		int[][] allArrs = new int[arr.length][];

		for (int i = 0; i < arr.length; i++) {
			allArrs[i] = arr[i];
		}

		List<Integer> result = new ArrayList<>();

		for (int i = 0; i < allArrs.length; i++) {
			minHeap.offer(new QueueItem(allArrs[i][0], i, 0));
		}

		while (!minHeap.isEmpty()) {
			QueueItem minItem = minHeap.poll();
			result.add(minItem.num);
			int nextArrItemIdx = minItem.arrItemIndex + 1;
			int arrIdx = minItem.arrIndex;
			if (nextArrItemIdx < allArrs[arrIdx].length) {
				minHeap.offer(new QueueItem(allArrs[arrIdx][nextArrItemIdx], arrIdx, nextArrItemIdx));
			}
		}

		return result;
	}

	public class QueueItem {
		int num;
		int arrIndex;
		int arrItemIndex;

		public QueueItem(int num, int arrIndex, int arrItemIndex) {
			this.num = num;
			this.arrIndex = arrIndex;
			this.arrItemIndex = arrItemIndex;
		}
	}

	public class MergeComparator implements Comparator<QueueItem> {

		@Override
		public int compare(KWayMerge.QueueItem item1, KWayMerge.QueueItem item2) {
			return Integer.compare(item1.num, item2.num);
		}
	}
}
