package com.queue;

public class Queue1 {

    Object[] elements;
    int queueSize;
    int capacity = 10;

    public Queue1() {
        elements = new Object[capacity];
        queueSize = 0;
    }

    public void add(Object obj) {
        if (queueSize == capacity) {
            alterCapacity();
            alterQueue();
        }

        elements[queueSize++] = obj;
    }

    public void alterCapacity() {

        capacity = capacity + capacity << 1;
    }

    public Object delete() {
        Object obj = null;
        if (queueSize == 0) {
            System.out.println("there is nothing");
        } else {
            obj = elements[0];
            alterQueueAfterDelete();
        }
        return obj;
    }

    public void alterQueue() {

        Object[] newElements = new Object[capacity];
        for (int i = 0; i < elements.length; i++) {
            newElements[i] = elements[i];
        }
        this.elements = newElements;
    }

    public void alterQueueAfterDelete() {
        Object[] newElements = new Object[capacity];
        for (int i = 1; i <=queueSize; i++) {
            newElements[i-1] = elements[i];
        }

        this.elements = newElements;

        queueSize--;

    }


    public String printQueue() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < queueSize; i++) {
            sb.append(elements[i]);
            if (i < queueSize - 1)
                sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        Queue1 queue = new Queue1();
        queue.add("12");
        queue.add("13");
        queue.add("14");
        System.out.println(queue.queueSize);
        System.out.println(queue.printQueue());
        queue.delete();
        System.out.println(queue.queueSize);
        System.out.println(queue.printQueue());


    }

}
