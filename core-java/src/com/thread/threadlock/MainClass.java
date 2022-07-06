package com.thread.threadlock;

public class MainClass {
    public static void main(String[] args) throws InterruptedException {
        Shared s1 = new Shared();
        Shared s2 = new Shared();
        Runnable r1 = () -> {
            s1.test1(s2);
        };
        Runnable r2 = () -> {
            s2.test1(s1);
        };
        Thread th1 = new Thread(r1);
        th1.start();
        Thread th2 = new Thread(r2);
        th2.start();


        th1.stop();
        th2.stop();
        System.out.println(th1.getState() + "::" + th1.getName());
        System.out.println(th2.getState() + "::" + th2.getName());

    }
}
