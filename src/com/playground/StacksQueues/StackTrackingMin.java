package com.playground.StacksQueues;

import java.util.Stack;

public class StackTrackingMin extends Stack<Integer> {

    /**
     *
     */
    private static final long serialVersionUID = -1659513488961603400L;
    Stack<Integer> minStack;

    public StackTrackingMin() {
        minStack = new Stack<Integer>();
    }

    @Override
    public Integer push(Integer value) {
        if (value <= min()) {
            minStack.push(value);
        }
        super.push(value);
        return value;
    }

    public Integer pop() {
        if (super.peek() == min()) {
            minStack.pop();
        }
        return super.pop();
    }

    public int min() {
        if (minStack.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return minStack.peek();
        }
    }

    public static void main(String[] args) {
        StackTrackingMin minStack = new StackTrackingMin();
        minStack.push(5);
        minStack.push(7);
        minStack.push(4);
        minStack.push(3);
        minStack.push(8);

        System.out.println(minStack.min());
        System.out.println(minStack.pop());
        System.out.println(minStack.pop());

        System.out.println(minStack.min());
        System.out.println(minStack.pop());
        System.out.println(minStack.min());

    }

}
