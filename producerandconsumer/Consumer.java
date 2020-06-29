package com.producerandconsumer;

import java.util.Queue;

public class Consumer extends Thread {
    Queue<Integer> queue;
    int max_size;

    public Consumer(Queue<Integer> queue, int max_size, String name) {
        super(name);
        this.queue = queue;
        this.max_size = max_size;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                if (queue.isEmpty()) {
                    try {
                        System.out.println("consumer in wait state until producer will produce something");
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName()+"taken by"+queue.remove());
                queue.notifyAll();


            }


        }
    }
}
