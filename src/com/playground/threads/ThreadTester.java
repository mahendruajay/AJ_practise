package com.playground.threads;

import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

public class ThreadTester {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Queue<String> myQueue = new PriorityBlockingQueue<String>(20);

        MyThread t1 = new MyThread(myQueue);
        MyThread t2 = new MyThread(myQueue);
        MyThread t3 = new MyThread(myQueue);
        MyThread t4 = new MyThread(myQueue);

        t1.setName("Ajay");
        t2.setName("Anu");
        t3.setName("Tuffy");
        t4.setName("Gnu");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        for (int i = 0; i < 15; i++) {
            synchronized (myQueue) {
                System.out.println("Main Peeking..");
                for (String str : myQueue) {
                    System.out.println(str);
                }

                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted Exception " + e);
                }
            }

        }

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted Exception " + e);
        }

        System.out.println("Final Parse...");
        for (String str : myQueue) {
            System.out.println(str);
        }

    }

}
