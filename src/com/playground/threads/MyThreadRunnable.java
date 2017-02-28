package com.playground.threads;

import java.util.Queue;

public class MyThreadRunnable implements Runnable {

    private Queue<String> myQueue;

    public MyThreadRunnable(Queue<String> inputQueue) {
        this.myQueue = inputQueue;
    }

    public void run() {
        print();
    }

    public Queue<String> getMyQueue() {
        return myQueue;
    }

    private synchronized void print() {
        for (int i = 0; i < 10; i++) {
            if (i % 3 == 0) {
                String threadName = Thread.currentThread().getName();
                System.out.println("In :" + threadName + " Count - " + i);
                System.out.println("Adding " + threadName + " to queue");
                myQueue.offer(Thread.currentThread().getName());
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted Exception: " + e);
            }
        }
    }
}
