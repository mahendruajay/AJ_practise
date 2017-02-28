package org.start.recursion_dynamic;

import java.util.Arrays;

public class NQueenProblem {

    public static void main(String[] args) {

        NQueenProblem nQueenProblem = new NQueenProblem();
        int queens = 4;
        Position[] positions = new Position[queens];
        boolean hasSolution = nQueenProblem.findNQueenSolution(queens, 0, positions);
        if (hasSolution) {
            Arrays.stream(positions).forEach(position -> {
                System.out.println("Row: " + position.row + " Col: " + position.col);
            });
        } else {
            System.out.println("No solution..");
        }

    }

    class Position {
        int row;
        int col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }


    public boolean findNQueenSolution(int n, int row, Position[] positions) {
        if (n == row) {
            return true;
        }

        // Check each column for a position
        for (int col = 0; col < n; col++) {
            boolean foundPosition = true;

            // check if not attacked by queens on each of the previous rows
            // row-col and row+col always gives you diagonal
            for (int queen = 0; queen < row; queen++) {
//                if (positions[queen].col == col || positions[queen].row - positions[queen].col == row - col ||
//                        positions[queen].row + positions[queen].col == row + col)
                if (isDiagonal(positions[queen], row, col) || isSameColumn(positions[queen], col)) {
                    foundPosition = false;
                    break;
                }

            }
            if (foundPosition) {
                positions[row] = new Position(row, col);
                if (findNQueenSolution(n, row + 1, positions)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isDiagonal(Position queenPosition, int currRow, int currCol) {
        if (queenPosition.row - queenPosition.col == currRow - currCol ||
                queenPosition.row + queenPosition.col == currRow + currCol) {
            return true;
        }
        return false;
    }

    private boolean isSameColumn(Position queenPosition, int currCol) {
        if (queenPosition.col == currCol) {
            return true;
        }
        return false;
    }

}
