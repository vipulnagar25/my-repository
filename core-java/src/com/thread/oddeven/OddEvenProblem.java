package com.thread.oddeven;

import java.util.Map;
import java.util.SortedMap;

class MyRunnable implements Runnable {
    public int PRINT_NUMBERS_UPTO = 10;
    static int number = 1;
    int remainder;
    static Object lock = new Object();

    MyRunnable(int remainder) {
        this.remainder = remainder;
    }

    @Override
    public void run() {
        while(number < PRINT_NUMBERS_UPTO) {
            synchronized(lock) {
                while(number % 2 != remainder) { // wait for numbers other than remainder
                    try {
                        lock.wait();
                    } catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " " + number);
                System.out.println(lock);
                number++;
                lock.notifyAll();
            }
        }
    }
}


public class OddEvenProblem {

    public static void main(String[] args) {
        System.out.println(MyRunnable.lock);
        MyRunnable oddRunnable = new MyRunnable(1);
        MyRunnable evenRunnable = new MyRunnable(0);
        Thread th1 = new Thread(evenRunnable, "even");
        th1.start();
        Thread th2 = new Thread(oddRunnable, "odd");
        th2.start();
    }
}
