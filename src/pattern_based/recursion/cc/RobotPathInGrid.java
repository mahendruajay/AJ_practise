package pattern_based.recursion.cc;

/*
Imagine a robot sitting on the upper left corner of a grid with r rows and c columns. The robot can move in only two directions.
It can go either right or down and certain cells are off limits such that the robot cannot step on them.
 */

import cracking.coding.interview.recursion_dynamic.RobotPath;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RobotPathInGrid {

    public static void main(String[] args) {
        int[][] grid = constructGrid(3, 3, 1);
        printGrid(grid);
        RobotPathInGrid robotPathInGrid = new RobotPathInGrid();
        List<List<Integer>> result = robotPathInGrid.findPath(grid);
        System.out.println("Result: " + result);
    }

    public static void printGrid(int[][] grid) {
        for (int[] row : grid) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    public static int[][] constructGrid(int row, int col, int blockers) {
        int[][] grid = new int[row][col];
        for (int i = 0; i < blockers; i++) {
            int randRow = new Random().nextInt(row);
            int randCol = new Random().nextInt(col);
            grid[randRow][randCol] = 1;

        }
        return grid;
    }

    public List<List<Integer>> findPath(int[][] grid) {
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> slate = new ArrayList<>();
        slate.add(List.of(0, 0));
        findPathHelper(grid, 0, 0, slate, result);
        return result;
    }

    public void findPathHelper(int[][] grid, int row, int col, List<List<Integer>> slate, List<List<Integer>> result) {
        if (row >= grid.length || col >= grid[0].length) {
            return;
        } else if (grid[row][col] == 1) {
            return;
        } else if (row == grid.length - 1 && col == grid[0].length - 1) {
            System.out.println(slate);
//            result.add(List.copyOf(slate));
            return;
        } else {
            slate.add(List.of(row + 1, col));
            findPathHelper(grid, row + 1, col, slate, result);
            slate.remove(slate.size() - 1);

            slate.add(List.of(row, col + 1));
            findPathHelper(grid, row, col + 1, slate, result);
            slate.remove(slate.size() - 1);
        }
    }
}
