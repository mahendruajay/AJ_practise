package org.start.stacks.and.queues;

import java.util.Stack;

public class StackMin extends Stack<StackMin.StackMinNode> {

    public void push(int value) {
        int min = Math.min(value, min());
        StackMinNode node = new StackMinNode(min, value);
        super.push(node);
    }

    public int min() {
        if (!this.isEmpty()) {
            return super.peek().getMin();
        } else {
            return Integer.MAX_VALUE;
        }
    }


    public class StackMinNode {
        public int getMin() {
            return min;
        }

        public int getValue() {
            return value;
        }

        private int min;
        private int value;

        public StackMinNode(int min, int value) {
            this.min = min;
            this.value = value;
        }
    }
}
