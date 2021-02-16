package cracking.coding.interview.practice20.arrays_and_strings;

public class RotateMatrix<E> {


    private E[][] mat;
    public RotateMatrix(E[][] mat){
        this.mat = mat;
    }

    public void printMat(){

        StringBuilder builder  = new StringBuilder();

        for(int i = 0; i< mat.length; i++){
            for(int j= 0; j< mat[0].length; j++){
                builder.append(mat[i][j]);
                builder.append(" ");
            }
            builder.append("\n");
        }

        System.out.println(builder.toString());
    }

    public void rotate(){
        for(int layer=0; layer < mat.length/2; layer++) {
            int start = layer;
            int end = mat.length -1 - layer;
            for(int i = start; i< end; i++){
                int offset = end - (i-start);
                E temp = mat[start][i];
                mat[start][i] = mat[offset][start];
                mat[offset][start] = mat[end][offset];
                mat[end][offset] = mat[i][end];
                mat[i][end] = temp;

            }
        }
    }


    public static void main(String[] args) {
        Integer[][] mat = {{1,2,3}, {4,5,6}, {7,8,9}};
        Integer[][] mat1 = {{1,2,3,4}, {5,6, 7,8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        RotateMatrix rotateMatrix = new RotateMatrix(mat1);
        rotateMatrix.printMat();
        rotateMatrix.rotate();
        rotateMatrix.printMat();

    }
}
