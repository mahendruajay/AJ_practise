package com.playground.threads;

import java.util.PriorityQueue;
import java.util.Queue;

public class RunnableTester {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Queue<String> myQueue = new PriorityQueue<String>();

        MyThreadRunnable myThreadRunnable = new MyThreadRunnable(myQueue);

        Thread t1 = new Thread(myThreadRunnable);
        Thread t2 = new Thread(myThreadRunnable);
        Thread t3 = new Thread(myThreadRunnable);
        Thread t4 = new Thread(myThreadRunnable);

        t1.setName("Thread 1");
        t2.setName("Thread 2");
        t3.setName("Thread 3");
        t4.setName("Thread 4");
        t3.setPriority(10);

        try {

            t1.start();

            Thread.sleep(100);
            t2.start();

            Thread.sleep(500);
            t3.start();
            Thread.sleep(1000);
            t4.start();
            // t4.join();
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            System.out.println("InterruptedExcpetion" + e);
        }

        // try
        // {
        // t1.join();
        // t2.join();
        // t3.join();
        // t4.join();
        // } catch (InterruptedException e)
        // {
        // System.out.println("InterruptedException" + e);
        // }

        while (true) {

            System.out.println("Main Thread peeking.. "
                    + myThreadRunnable.getMyQueue().poll());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException" + e);
            }
        }

    }
}
