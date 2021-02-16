package playground.StacksQueues;

import java.util.Stack;

public class MyQueue {

    Stack<Integer> s1;
    Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }

    public void offer(int value) {
        s1.push(value);
    }

    public int poll() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty");
        }
        shiftStacks();
        return s2.pop();

    }

    public boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    public int peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty");
        }
        shiftStacks();
        return s2.peek();
    }

    private void shiftStacks() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();

        myQueue.offer(1);
        myQueue.offer(2);
        myQueue.offer(3);
        myQueue.offer(4);

        try {
            System.out.println(myQueue.poll());
            System.out.println(myQueue.poll());

            myQueue.peek();

            System.out.println(myQueue.poll());
            System.out.println(myQueue.poll());

            System.out.println(myQueue.poll());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        myQueue.offer(4);

    }

}
