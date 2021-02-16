package playground.StacksQueues;

import java.util.ArrayList;
import java.util.List;

public class MyStack {
    List<Integer> stack;

    int capacity;
    int size;

    public MyStack(int capacity) {
        this.capacity = capacity;
        stack = new ArrayList<Integer>();
    }

    public void push(int value) {
        stack.add(value);
        size++;
    }

    public int pop() {
        size--;
        return stack.remove(stack.size() - 1);
    }

    public boolean isFull() {
        return capacity == stack.size();
    }

    public boolean isEmpty() {
        return stack.size() == 0;
    }

    public int removeBottom() {
        size--;
        return stack.remove(0);
    }

    public List<Integer> getStack() {
        return stack;
    }

}
