package org.start.recursion_dynamic;

public class Point {

    int row;
    int col;

    public Point(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public String toString() {
        return "{" + row + ", " + col + "}";
    }
}
