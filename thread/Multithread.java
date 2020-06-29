package com.thread;

//Java code for thread creation by implementing 
//the Runnable Interface 
class MultithreadingDemo extends Thread {
	String myName;

	public MultithreadingDemo(String name) {
		myName = name;
	}

	public void run() {
		for (int i = 1; i <= 5; i++) {
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				System.out.println(e);
			}
			System.out.println(Thread.currentThread().isDaemon());  
			System.out.println(i + this.myName+Thread.currentThread().getName());
		}
	}
}

//Main Class 
class Multithread {
	public static void main(String[] args) {

		MultithreadingDemo t1 = new MultithreadingDemo("vipul");
		t1.setPriority(1);
		t1.setDaemon(true);
		MultithreadingDemo t2 = new MultithreadingDemo("nagar");
		t2.setPriority(10);
		// MultithreadingDemo t3=new MultithreadingDemo();
		t1.start();
		System.exit(0);
		try {
			//t1.join(50);
		} catch (Exception e) {
			System.out.println(e);
		}

		t2.start();
		// t3.start();
	}
}
