package com.playground.StacksQueues;

public class ThreeStacksUsingArray {

    private int stackSize;
    private int[] stack;
    private int[] stackPointer = {-1, -1, -1};

    public ThreeStacksUsingArray(int stackSize) {
        this.stackSize = stackSize;
        stack = new int[stackSize * 3];
    }

    public void push(int stackNum, int value) throws StackFullException {
        if (isFull(stackNum)) {
            throw new StackFullException("Stack is full");
        }
        stackPointer[stackNum]++;

        int position = getPositionInBuffer(stackNum);

        stack[position] = value;

    }

    public int pop(int stackNum) throws StackEmptyException {
        if (isEmpty(stackNum)) {
            throw new StackEmptyException("Stack is empty");
        }

        int position = getPositionInBuffer(stackNum);
        int value = stack[position];
        stackPointer[stackNum]--;
        return value;
    }

    public boolean isEmpty(int stackNum) {
        return stackPointer[stackNum] == -1;
    }

    public boolean isFull(int stackNum) {
        return stackPointer[stackNum] >= stackSize - 1;
    }

    private int getPositionInBuffer(int stackNum) {
        return (stackNum * stackSize) + stackPointer[stackNum];
    }
}
