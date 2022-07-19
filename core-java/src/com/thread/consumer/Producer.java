package com.thread.consumer;

import java.util.Queue;

public class Producer extends Thread {
    private final Queue sharedQ;
    static  int value=0;

    public Producer(Queue sharedQ) {
        super("Producer");
        this.sharedQ = sharedQ;
    }

    @Override
    public void run() {

       // for (int i = 0; i < 100; i++) {
          while(true){
            synchronized (sharedQ) {
                //waiting condition - wait until Queue is not empty
                while (sharedQ.size() >= 1) {
                    try {
                        System.out.println("Queue is full, waiting");
                        sharedQ.wait();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                System.out.println("producing : " + value);
                sharedQ.add(value++);
                sharedQ.notify();
            }
        }
    }
}


