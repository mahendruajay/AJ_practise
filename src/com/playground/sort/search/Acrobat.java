package com.playground.sort.search;

public class Acrobat implements Comparable<Acrobat> {
    private int height;
    private int weight;

    public Acrobat(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWeight() {
        return this.weight;
    }

    @Override
    public int compareTo(Acrobat other) {
        if (this.height != other.getHeight()) {
            return ((Integer) height).compareTo(other.getHeight());
        } else {
            return ((Integer) weight).compareTo(other.getWeight());
        }

    }

    public boolean isBefore(Acrobat other) {
        if (this.height < other.getHeight() && this.weight < other.getWeight()) {
            return true;
        } else {
            return false;
        }
    }

}
