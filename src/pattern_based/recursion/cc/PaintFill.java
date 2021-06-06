package pattern_based.recursion.cc;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/*
Given a screen (represented by a two dimensional array of colors), a point and a new color,
fill in the surrounding area until the color changes from the original color.
 */

public class PaintFill {

    public static Color[][] buildGrid(int m, int n) {
        Color[][] grid = new Color[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = Color.randomColor();
            }
        }
        return grid;
    }

    public static void printGrid(Color[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        PaintFill paintFill = new PaintFill();

        Color[][] grid = buildGrid(4, 4);
        printGrid(grid);

        paintFill.paintFill(grid, 2, 2, Color.R);
        System.out.println();
        System.out.println();
        printGrid(grid);

    }

    public boolean paintFill(Color[][] grid, int row, int col, Color newColor) {
        if (grid[row][col] == newColor) {
            return false;
        } else {
            return paintFillHelper(grid, row, col, grid[row][col], newColor);
        }
    }

    public boolean paintFillHelper(Color[][] grid, int row, int col, Color oldColor, Color newColor) {
        if ((row < 0 || row >= grid.length) || (col < 0 || col >= grid[0].length)) {
            return false;
        } else {
            if (grid[row][col] == oldColor) {
                grid[row][col] = newColor;
                paintFillHelper(grid, row + 1, col, oldColor, newColor);
                paintFillHelper(grid, row - 1, col, oldColor, newColor);
                paintFillHelper(grid, row, col + 1, oldColor, newColor);
                paintFillHelper(grid, row, col - 1, oldColor, newColor);
            }
        }
        return true;
    }

    public enum Color {
        R, G, B;

        private static final List<Color> VALUES =
                Collections.unmodifiableList(Arrays.asList(values()));
        private static final int SIZE = VALUES.size();
        private static final Random RANDOM = new Random();

        public static Color randomColor() {
            return VALUES.get(RANDOM.nextInt(SIZE));
        }
    }
}
