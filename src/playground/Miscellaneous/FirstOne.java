package playground.Miscellaneous;

/*
 * Given a sorted array consisting 0's and 1's. find the index of first '1'. write a 
 * complete program which takes less time complexity. and playground all boundary conditions also.
 * Eg: If given array is 0,0,0,0,0,0,1,1,1,1 the out put should be 6.
 */

public class FirstOne {

    /**
     * @param args
     */
    public static void main(String[] args) {
        FirstOne first = new FirstOne();

        String str = "0000000011111";

        int index = first.firstOneIndex(str.toCharArray(), 0, str.length() - 1);

        System.out.println(index);

    }

    public int firstOneIndex(char[] input, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;
        if (input[mid] == '0') {
            if (mid == input.length - 1) {
                return -1;
            } else if (input[mid + 1] == '1') {
                return mid + 1;
            } else {
                return firstOneIndex(input, mid + 1, end);
            }
        } else if (input[mid] == '1') {
            if (mid == input.length - 1) {
                return mid;
            } else if (input[mid - 1] == '0') {
                return mid;
            } else {
                return firstOneIndex(input, start, mid - 1);
            }
        }

        return -1;

    }

}
