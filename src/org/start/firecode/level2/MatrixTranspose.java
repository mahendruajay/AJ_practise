package org.start.firecode.level2;

public class MatrixTranspose {

    public static void transposeMatrix(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }


    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 0}, {1, 0}};
        transposeMatrix(matrix);
    }
}
