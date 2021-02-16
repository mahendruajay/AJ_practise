package playground.StacksQueues;

import java.util.Stack;

public class SortStack {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        stack = sortStack(stack);

        if (null != stack) {
            // for (Integer val : stack)
            // {
            // System.out.print(val);
            // }
            while (!stack.isEmpty()) {
                System.out.print(stack.pop() + ", ");
            }
        }

    }

    public static Stack<Integer> sortStack(Stack<Integer> inputStack) {
        if (null == inputStack || inputStack.isEmpty()) {
            return null;
        }
        Stack<Integer> outputStack = new Stack<Integer>();

        while (!inputStack.isEmpty()) {
            int temp = inputStack.pop();
            while (!outputStack.isEmpty() && outputStack.peek() > temp) {
                inputStack.push(outputStack.pop());
            }
            outputStack.push(temp);
        }

        return outputStack;

    }

}
