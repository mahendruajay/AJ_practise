package pattern_based.recursion.ik;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class NQueen {

    public static void main(String[] args) throws IOException {
        int boardSize =4;
        List<Integer> board = new ArrayList<>(3);
        List<List<Integer>> solutions = new ArrayList<>(3);
        placeNQueens(boardSize, 0, board, solutions);

        String[][] res1 =
                {{"--q-","q---","---q","-q--"}, {"-q--","---q","q---", "--q-"}};

//        print(res1);


        String[][] res =  convertBoard(boardSize, solutions);
        print(res);
    }

    public static void print(String[][] res) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int res_rowLength = res.length;
        for(int res_i = 0; res_i < res_rowLength; res_i++) {
            for(int res_j = 0; res_j < res[res_i].length; res_j++) {
                bw.write(String.valueOf(res[res_i][res_j]) + "\n");
            }
            if (res_i != res_rowLength - 1) {
                bw.write("\n");
            }
        }

        bw.close();

    }

    public static void placeNQueens(int boardSize, int row, List<Integer> board, List<List<Integer>> solutions){
        if(row == boardSize){
            System.out.println(board);
            solutions.add(new ArrayList<>(board));
        } else{
            for(int col=0; col< boardSize; col++){
                if (isSafe(board, row, col)) {
                    board.add(col);
                    placeNQueens(boardSize, row + 1, board, solutions);
                    board.remove(board.size() - 1);
                }
            }
        }
    }

    public static boolean isSafe(List<Integer> board, int row1, int col1){
        for(int col: board){
            if(col == col1){
                return false;
            }
        }

        for(int row=0; row<board.size(); row++){
            int rowDist = Math.abs(row1 -row);
            int colDist = Math.abs(board.get(row) - col1);
            if(rowDist == colDist){
                return false;
            }
        }

        return true;
    }

    public static String[][] convertBoard(int n, List<List<Integer>> solutions) throws IOException {

        String[][] res = new String[solutions.size()][n];

        for(int i=0; i< solutions.size(); i++){
            List<Integer> board = solutions.get(i);

            for(int row =0; row< board.size(); row++){
                char[] temp = new char[n];
                for(int j=0; j< n; j++){
                    temp[j] = '-';
                }
                temp[board.get(row)] = 'q';
                res[i][row] = new String(temp);
            }
        }
        return res;
    }
}
