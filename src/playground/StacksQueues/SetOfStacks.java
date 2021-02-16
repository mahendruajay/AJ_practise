package playground.StacksQueues;

import java.util.ArrayList;
import java.util.List;

public class SetOfStacks {
    List<MyStack> stackSet;
    int capacity;

    public SetOfStacks(int capacity) {
        this.capacity = capacity;
        stackSet = new ArrayList<MyStack>();
    }

    public void push(int value) {
        MyStack last = getLastStack();
        if (null == last || last.isFull()) {
            MyStack stack = new MyStack(capacity);
            stack.push(value);
            stackSet.add(stack);
        } else {
            last.push(value);
        }
    }

    public int pop() throws StackEmptyException {
        MyStack last = getLastStack();
        if (null == last) {
            throw new StackEmptyException("SetOfStacks is empty");
        }
        int value = last.pop();
        if (last.isEmpty()) {
            stackSet.remove(stackSet.size() - 1);
        }

        return value;

    }

    public int popAt(int index) throws Exception {
        if (index > stackSet.size() - 1) {
            throw new Exception("index out of bounds");
        }
        if (index == stackSet.size() - 1) {
            return this.pop();
        }
        int value = stackSet.get(index).pop();

        for (int i = index; i < stackSet.size() - 1; i++) {
            int bottom = stackSet.get(i + 1).removeBottom();
            stackSet.get(i).push(bottom);
        }

        return value;

    }

    public MyStack getLastStack() {
        if (stackSet.size() == 0) {
            return null;
        } else {
            return stackSet.get(stackSet.size() - 1);
        }
    }

    public void print() {
        for (MyStack stack : stackSet) {
            for (int value : stack.getStack()) {
                System.out.print(value + ", ");
            }
            System.out.println();
        }
    }

}
