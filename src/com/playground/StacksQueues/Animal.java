package com.playground.StacksQueues;

public abstract class Animal {

    int order;

    String name;

    public Animal(String name) {
        this.name = name;
    }

    public boolean isOlderThan(Animal a) {
        return this.order < a.order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

}
