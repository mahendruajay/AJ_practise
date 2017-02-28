package org.start.arrays.and.strings;

public class RotateMatrix<E> {

    private E[][] mat;

    public RotateMatrix(E[][] mat) {
        this.mat = mat;
        printMat();
    }

    private void printMat() {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                builder.append(mat[i][j]);
                builder.append(" ");
            }
            builder.append("\n");
        }

        System.out.println(builder.toString());

    }

    public E[][] rotate() {
        for (int layer = 0; layer < (mat.length / 2); layer++) {
            int first = layer;
            int last = mat.length - 1 - layer;

            for (int i = first; i < last; i++) {
                int offset = last - (i - first);
                E temp = mat[i][last];
                mat[i][last] = mat[last][offset];
                mat[last][offset] = mat[offset][first];
                mat[offset][first] = mat[first][i];
                mat[first][i] = temp;
            }
        }

        printMat();
        return mat;
    }

    public static void main(String[] args) {
        Integer[][] mat2 = {{1, 2}, {3, 4}};
        Integer[][] mat3 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Integer[][] mat4 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};

        RotateMatrix rotateMatrix = new RotateMatrix(mat4);
        rotateMatrix.rotate();


    }
}
