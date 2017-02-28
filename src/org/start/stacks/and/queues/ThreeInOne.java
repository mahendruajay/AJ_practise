package org.start.stacks.and.queues;

public class ThreeInOne {

    private int capacity;
    private int[] stack;
    private int[] stackPointer = {-1, -1, -1};

    public ThreeInOne(int capacity) {
        this.capacity = capacity;
        stack = new int[3 * capacity];
    }

    public void push(int stackNum, int value) throws Exception {
        if (isFull(stackNum)) {
            throw new Exception();
        } else {

            stackPointer[stackNum]++;
            stack[getPositionInStack(stackNum)] = value;
        }
    }

    public int pop(int stackNum) throws Exception {
        if (isEmpty(stackNum)) {
            throw new Exception();
        } else {
            int value = stack[getPositionInStack(stackNum)];
            stackPointer[stackNum]--;
            return value;
        }

    }

    public boolean isFull(int stackNum) {
        return stackPointer[stackNum] == capacity;
    }

    public boolean isEmpty(int stackNum) {
        return stackPointer[stackNum] == -1;
    }

    public int getPositionInStack(int stackNum) {
        return (stackNum * capacity) + stackPointer[stackNum];
    }

    public void printStackState() {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            builder.append("Stack " + i + ": ");
            for (int j = i * capacity; j < (i * capacity) + capacity; j++) {
                builder.append(stack[j] + " ");

            }
            builder.append("\n");
        }

        System.out.println(builder.toString());
    }

    public static void main(String[] args) throws Exception {
        ThreeInOne threeInOne = new ThreeInOne(10);
        threeInOne.push(0, 12);
        threeInOne.push(0, 15);
        threeInOne.push(1, 17);
        threeInOne.push(1, 2);
        threeInOne.push(2, 6);
        threeInOne.push(2, 27);

        threeInOne.pop(2);
        threeInOne.pop(2);
        threeInOne.pop(2);

        threeInOne.printStackState();
    }
}
