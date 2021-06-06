package pattern_based.recursion.ik.live.session_prac1.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueen {

    public static void main(String[] args) {
        NQueen nQueen = new NQueen();
        nQueen.nQueen(5);
    }

    public void nQueen(int boardSize) {
        nQueenHelper(boardSize, 0, new ArrayList<>());
    }

    public void nQueenHelper(int boardSize, int row, List<Integer> slate) {

        if (row == boardSize) {
            System.out.println("Board is: " + slate);
            return;
        } else {
            for (int currCol = 0; currCol < boardSize; currCol++) {
                if (isValid(row, currCol, slate)) {
                    slate.add(currCol);
                    nQueenHelper(boardSize, row + 1, slate);
                    slate.remove(slate.size() - 1);
                }
            }
        }

    }

    public boolean isValid(int currRow, int currCol, List<Integer> slate) {
        // validate current placement is not in the same column
        for (Integer oldCol : slate) {
            if (oldCol == currCol) {
                return false;
            }
        }

        // validate current placement is not on a diagonal
        for (int oldRow = 0; oldRow < slate.size(); oldRow++) {
            int rowDist = Math.abs(oldRow - currRow);
            int colDist = Math.abs(slate.get(oldRow) - currCol);
            if (rowDist == colDist) {
                return false;
            }
        }

        return true;
    }
}
