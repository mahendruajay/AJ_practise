package cracking.coding.interview.practice20.arrays_and_strings;

import java.util.ArrayList;
import java.util.List;

public class ZeroMatrix {

    public static void main(String[] args) {
        int[][] mat = {{1,0,3}, {3,4,5}, {7,8,0}};
        printMat(mat);
        zeroMatrix(mat);
        printMat(mat);
    }



    public static void zeroMatrix(int[][] mat){
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        for(int i=0; i< mat.length; i++){
            for(int j=0; j< mat[0].length; j++){
                if(mat[i][j] == 0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for(int i: rows){
            for(int j=0; j< mat[0].length; j++){
                mat[i][j] = 0;
            }
        }

        for(int j: cols){
            for(int i=0; i< mat.length; i++){
                mat[i][j] = 0;
            }
        }

    }

    public static void printMat(int[][] mat){

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
}
