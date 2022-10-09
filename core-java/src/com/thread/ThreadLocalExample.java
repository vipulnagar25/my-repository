package com.thread;

import java.util.concurrent.Callable;

class MyNewThread implements Runnable {
    private static ThreadLocal<Object> userContext = new ThreadLocal<>();

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "test");
        userContext.set(Thread.currentThread());
        System.out.println(userContext.get().toString()+"from"+userContext);
    }
}


public class ThreadLocalExample {

    public static void main(String[] args) {
        MyNewThread myNewThread=new MyNewThread();
        Thread t1=new Thread(myNewThread);
        t1.start();
        Thread t2=new Thread(myNewThread);
        t2.start();
        //t1.ge
    }
}
