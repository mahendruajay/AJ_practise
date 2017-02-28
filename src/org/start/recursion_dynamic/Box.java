package org.start.recursion_dynamic;

public class Box {


    private int length;
    private int width;
    private int height;

    public Box(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Box[] rotate() {
        Box[] boxes = new Box[3];

        boxes[0] = getRotatedBox(height, length, width);
        boxes[1] = getRotatedBox(length, width, height);
        boxes[2] = getRotatedBox(width, height, length);

        return boxes;

    }

    public Box getRotatedBox(int height, int side1, int side2) {
        int length;
        int width;

        length = side1 > side2 ? side1 : side2;
        width = side1 > side2 ? side2 : side1;

        Box box = new Box(length, width, height);
        return box;
    }

    public boolean canFitOnTopOf(Box box) {
        return (this.length < box.getLength()) && (this.width < box.getWidth());

    }

    @Override
    public String toString() {
        return "Dimension is: " + length + " " + width + " " + height + "\n";
    }
}
