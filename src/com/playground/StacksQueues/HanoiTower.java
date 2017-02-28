package com.playground.StacksQueues;

import java.util.Stack;

public class HanoiTower {
    Stack<Integer> discs;
    int index = 1;

    public HanoiTower(int index) {
        discs = new Stack<Integer>();
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public boolean addDisk(int disc) {
        if (!discs.isEmpty() && discs.peek() <= disc) {
            return false;
        } else {
            discs.push(disc);
            return true;
        }
    }

    public boolean moveTopTo(HanoiTower tower) {
        int top = discs.pop();

        if (tower.addDisk(top)) {
            System.out.println("Move disc " + top + " from tower " + index
                    + " to tower " + tower.getIndex());
            return true;
        } else {
            return false;
        }
    }

    public void moveDisks(int discs, HanoiTower destination, HanoiTower buffer) {
        if (discs > 0) {
            moveDisks(discs - 1, buffer, destination);
            moveTopTo(destination);
            buffer.moveDisks(discs - 1, destination, this);
        }
    }
}
