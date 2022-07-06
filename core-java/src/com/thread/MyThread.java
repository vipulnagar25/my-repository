package com.thread;

public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Start of  myMyThread");
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("END of  myMyThread");
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        MyThread myThread = new MyThread();
        myThread.start();

        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("By Runnable");
        };
        myThread.join();
        Thread t1 = new Thread(runnable);
        t1.start();
        System.out.println(t1.currentThread().getState());


    }
}
