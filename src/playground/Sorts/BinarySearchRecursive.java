package playground.Sorts;

public class BinarySearchRecursive {

    /**
     * @param args
     */
    public static void main(String[] args) {
        BinarySearchRecursive search = new BinarySearchRecursive();

        int[] input = {1, 3, 4, 5, 8, 10, 11, 15};

        int result = search.binarySearch(input, 0, input.length - 1, 0);

        System.out.println(result);

    }

    public int binarySearch(int[] input, int start, int end, int target) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;
        int midValue = input[mid];
        if (midValue == target) {
            return mid;
        } else if (midValue < target) {
            return binarySearch(input, mid + 1, end, target);
        } else {
            return binarySearch(input, start, mid - 1, target);
        }

    }
}
