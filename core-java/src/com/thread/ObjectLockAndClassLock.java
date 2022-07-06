package com.thread;

class SyncMethodClass implements Runnable {
    public synchronized void m1() {
        for(int i = 0; i < 10; i++) {
            System.out.println(i + "===" + Thread.currentThread().getName());
        }
    }

    @Override
    public void run() {

        synchronized(this) {
            m1();
        }
    }
}


public class ObjectLockAndClassLock {
    public static void main(String[] args) {
        SyncMethodClass smc = new SyncMethodClass();
        SyncMethodClass smc1 = new SyncMethodClass();
        Thread th1 = new Thread(smc);
        th1.start();

        Thread th2 = new Thread(smc1);
        System.out.println(th2.getState());
        th2.start();
        System.out.println(th2.getState());

    }
}