package cracking.coding.interview.recursion_dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RobotPath {

    public static List<Point> getPath(boolean[][] grid, int row, int column, int targetRow, int targetCol) {

        List<Point> path = new ArrayList<>();
        Set<Point> failedPoints = new HashSet<>();

        getPath(grid, row, column, targetRow, targetCol, failedPoints, path);
        return path;


    }

    public static boolean getPath(boolean[][] grid, int row, int column, int targetRow, int targetCol, Set<Point> failedPoints, List<Point> path) {

        Point p = new Point(row, column);

        if (failedPoints.contains(p)) {
            return false;
        }

        if (isOutOfBounds(row, column, targetRow, targetCol) || isObstacle(grid, row, column)) {
            return false;
        }

        if (isAtTarget(row, column, targetRow, targetCol) ||
                getPath(grid, row + column, column, targetRow, targetCol, failedPoints, path) ||
                getPath(grid, row, row + column, targetRow, targetCol, failedPoints, path)) {
            path.add(p);
            return true;
        }


        failedPoints.add(p);
        return false;


    }

    public static boolean isAtTarget(int row, int column, int targetRow, int targetCol) {
        return (row == targetRow && column == targetCol);
    }

    public static boolean isOutOfBounds(int row, int column, int targetRow, int targetCol) {
        return (row > targetRow || column > targetCol);
    }

    public static boolean isObstacle(boolean[][] grid, int row, int column) {
        return grid[row][column] == false;
    }

    public static void main(String[] args) {
//        boolean[][] grid = {{true, true, true},
//                {true, true, true},
//                {true, true, true}};

        boolean[][] grid = new boolean[50][50];
        for (int i = 0; i < grid[0].length; i++) {
            Arrays.fill(grid[i], true);
        }
        grid[3][1] = false;


        List<Point> path = getPath(grid, 1, 1, 5, 3);

        System.out.println("Path is: ");
        path.stream().forEach(i -> System.out.print(i));

    }
}
