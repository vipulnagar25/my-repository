package com.thread.threadlock;

public class Shared {
    synchronized void test1(Shared s){
        System.out.println("test1 begin");
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        s.test2(this);
        System.out.println("test1 end");
    }
    synchronized void test2(Shared s){
        System.out.println("test2 begin");
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        s.test1(this);
        System.out.println("test2 end");
    }
}
