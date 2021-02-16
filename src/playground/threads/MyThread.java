package playground.threads;

import java.util.PriorityQueue;
import java.util.Queue;

public class MyThread extends Thread {
    private Queue<String> myQueue = new PriorityQueue<String>();

    public MyThread(Queue<String> inputQueue) {
        this.myQueue = inputQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            insertAndPrint(i);
        }
    }

    private synchronized void insertAndPrint(int i) {
        String threadName = Thread.currentThread().getName();
        System.out.println("Inserting into Queue by thread: " + threadName);

        getMyQueue().offer(threadName + "_" + i);

        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            System.out.println("Interrupted Exception: " + e);
        }
    }

    public Queue<String> getMyQueue() {
        return myQueue;
    }

}
