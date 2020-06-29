package com.producerandconsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerAndConsumer {
    public static void main(String[] args) {
        BlockingQueue ss=new LinkedBlockingQueue();
        Queue<Integer> queue = new LinkedList<>();
        Producer producer = new Producer(queue, 10, "Producer");
        Consumer consumer = new Consumer(queue, 10, "Consumer");
        producer.start();
        consumer.start();


    }


}
