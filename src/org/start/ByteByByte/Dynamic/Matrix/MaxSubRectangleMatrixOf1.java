package org.start.ByteByByte.Dynamic.Matrix;

import org.start.ByteByByte.Dynamic.MaximumHistogram;

public class MaxSubRectangleMatrixOf1 {


    /**
     * Date 06/23/2014
     *
     * @author tusroy
     * <p>
     * Video link - https://youtu.be/2xvJ41-hsoE
     * <p>
     * Given a 2D matrix of 0s and 1s. Find largest rectangle of all 1s
     * in this matrix.
     * <p>
     * Maintain a temp array of same size as number of columns.
     * Copy first row to this temp array and find largest rectangular area
     * for histogram. Then keep adding elements of next row to this temp
     * array if they are not zero. If they are zero then put zero there.
     * Every time calculate max area in histogram.
     * <p>
     * Time complexity - O(rows*cols)
     * Space complexity - O(cols) - if number of cols is way higher than rows
     * then do this process for rows and not columns.
     * <p>
     * References:
     * http://www.careercup.com/question?id=6299074475065344
     */


    public int maximum(int input[][]) {
        int temp[] = new int[input[0].length];
        MaximumHistogram mh = new MaximumHistogram();
        int maxArea = 0;
        int area = 0;
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < temp.length; j++) {
                if (input[i][j] == 0) {
                    temp[j] = 0;
                } else {
                    temp[j] += input[i][j];
                }
            }
            area = mh.maxHistogram(temp);
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }

    public static void main(String args[]) {
        int input[][] = {{1, 1, 1, 0},
                {1, 1, 1, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 0, 0, 1},
                {1, 1, 1, 1}};
        MaxSubRectangleMatrixOf1 mrs = new MaxSubRectangleMatrixOf1();
        int maxRectangle = mrs.maximum(input);
        //System.out.println("Max rectangle is of size " + maxRectangle);
        assert maxRectangle == 8;
    }


}
