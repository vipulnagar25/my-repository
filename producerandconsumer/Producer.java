package com.producerandconsumer;


import javafx.scene.input.KeyCode;

import java.util.Queue;
import java.util.Random;

public class Producer extends Thread {
    Queue<Integer> queue;
    int max_size;

    public Producer(Queue<Integer> queue, int max_size, String name) {
        super(name);
        this.queue = queue;
        this.max_size = max_size;
    }

    @Override
    public void run() {
        int value = 0;
        while (true) {
            synchronized (queue) {
                while (queue.size() == max_size) {
                    try {
                        System.out.println("Producer will be in wait bocz of  queue is full ");
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(Thread.currentThread().getName() + "added by" + value);
                queue.add(value);
                value++;
                queue.notifyAll();

            }


        }


    }
}
