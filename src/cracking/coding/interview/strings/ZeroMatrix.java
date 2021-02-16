package cracking.coding.interview.strings;

public class ZeroMatrix {

    private int[][] mat;

    public ZeroMatrix(int[][] mat) {
        this.mat = mat;
        printMat();
    }

    public int[][] zeroMat() {

        boolean[] row = new boolean[mat.length];
        boolean[] column = new boolean[mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }

        }

        for (int i = 0; i < row.length; i++) {
            if (row[i])
                nullifyRow(i);
        }

        for (int i = 0; i < column.length; i++) {
            if (column[i])
                nullifyColumn(i);
        }

        printMat();
        return mat;
    }

    private void nullifyRow(int row) {
        for (int j = 0; j < mat[row].length; j++) {
            mat[row][j] = 0;
        }
    }

    private void nullifyColumn(int col) {
        for (int i = 0; i < mat.length; i++) {
            mat[i][col] = 0;
        }
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

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, {4, 5, 0}, {0, 8, 9}};

        ZeroMatrix zeroMatrix = new ZeroMatrix(mat);
        zeroMatrix.zeroMat();


    }

}
