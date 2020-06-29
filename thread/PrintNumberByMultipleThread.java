package com.thread;

import java.util.concurrent.SynchronousQueue;

class Th1 implements Runnable {
    String str ;

    public Th1(String str) {
        this.str = str;
    }

    @Override
    public  void run() {
        for (int i = 1; i < 10; i = i + 2) {
        //    str.notify();
            synchronized(str) {
                System.out.println("value of i==" + i);
                try {
                    str.wait(50);
                } catch (InterruptedException e) {
                    System.out.println("Exception");
                }
              //  System.out.println("vipul");
            }
        }

    }
}

class Th2 implements Runnable {
    String str ;
    public Th2(String str) {
        this.str = str;
    }
    @Override
    public void run() {
        for (int i = 2; i < 10; i = i + 2) {
        ///   str.notify();
            synchronized(str) {
                System.out.println("value of i2==" + i);
                try {
                    str.wait(50);
                } catch (InterruptedException e) {
                    System.out.println("Exception");
                }
            }

        }
    }
}

public class PrintNumberByMultipleThread {

    public static void main(String[] args) {
        String s1="vipul";
        Th1 th1 = new Th1(s1);
        Th2 th2 = new Th2(s1);
        Thread thread1 = new Thread(th1);
        Thread thread2 = new Thread(th2);
        thread1.start();
        thread2.start();


    }


}
