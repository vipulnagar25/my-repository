package com.thread;

class Test implements Runnable {
	@Override
	public void run() {
		System.out.println("Hey!!! "+Thread.currentThread().getName());
	}

}

public class Threadtesting {
	public static void main(String[] args) {
    Test t1= new Test();
    Thread th1=new Thread(t1);
    Thread th2 =new Thread(t1);
    th1.start();
    th2.start();
		
		
	}

}
