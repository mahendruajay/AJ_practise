package playground.CircularBuffer;

public class CircularBuffer {

    private String[] bufferContainer = null;
    private int rear;
    private int front;

    public CircularBuffer(int n) {
        bufferContainer = new String[n];
        rear = 0;
        front = -1;
    }

    private boolean isBufferFull() {
        return false;
    }

    private boolean isBufferEmpty() {
        return false;
    }

    public void add(String inputElement) {
        bufferContainer[rear] = inputElement;

        if (rear == front) {
            if (front == bufferContainer.length - 1 && !frontNextNull(front)) {
                front = 0;
            } else if (!frontNextNull(front)) {
                front++;
            }
        }

        adjustRearAndFront();

    }

    public String remove() {
        if (front == -1) {
            front = 0;
        }
        if (bufferContainer[front] == null) {
            return null;
        }

        String element = bufferContainer[front];
        bufferContainer[front] = null;
        adjustFrontAndRear();
        return element;

    }

    private void adjustRearAndFront() {
        if (rear == bufferContainer.length - 1) {
            if (front == -1) {
                front = 1;
            }
            rear = 0;
        } else {
            rear++;
        }

    }

    private void adjustFrontAndRear() {
        if (front == bufferContainer.length - 1) {
            front = 0;
        } else {
            front++;
        }
    }

    public void print() {
        for (String element : bufferContainer) {
            System.out.println("Element :" + element);
        }
    }

    private boolean frontNextNull(int front) {
        if (front == bufferContainer.length - 1) {
            return null == bufferContainer[0];
        } else {
            return null == bufferContainer[front + 1];
        }

    }
}
