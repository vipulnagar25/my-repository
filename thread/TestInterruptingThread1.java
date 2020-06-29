package com.thread;

class TestInterruptingThread1 extends Thread {
	String eee="ff";
	public void run() {
		try {
			wait();
			System.out.println("task");
		} catch (InterruptedException e) {
			throw new RuntimeException("Thread interrupted..." + e);
		}
	}

	public static void main(String args[]) {
		TestInterruptingThread1 t1 = new TestInterruptingThread1();
		t1.start();
		try {
			t1.interrupt();
		} catch (Exception e) {
			System.out.println("Exception handled " + e);
		}

	}
}
