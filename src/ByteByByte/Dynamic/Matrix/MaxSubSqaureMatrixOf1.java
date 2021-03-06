package ByteByByte.Dynamic.Matrix;

/*
Given a 2D array of 1s and 0s, find the largest square subarray of all 1s.
 */

public class MaxSubSqaureMatrixOf1 {

    public static void main(String[] args) {

    }


    public int subarray(int[][] arr) {
        int x = arr.length;
        if (x == 0) return 0;
        int y = arr[0].length;
        if (y == 0) return 0;
        int max = 0;
        int[][] sizes = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (i == 0 || j == 0) {
                    sizes[i][j] = arr[i][j];
                } else if (arr[i][j] == 1) {
                    sizes[i][j] = Math.min(Math.min(sizes[i][j - 1],
                            sizes[i - 1][j]),
                            sizes[i - 1][j - 1]) + 1;
                }
                if (sizes[i][j] > max) max = sizes[i][j];
            }
        }

        return max;
    }


}
