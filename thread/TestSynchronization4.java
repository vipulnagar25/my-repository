package com.thread;
class Table1 {
	synchronized static void printTable(int n) {
		for (int i = 1; i <= 10; i++) {
			System.out.println(n * i+"::==::"+Thread.currentThread().getName());
			try {
				Thread.sleep(400);
			} catch (Exception e) {
			}
		}
	}
}

class MyThread3 extends Thread {
	public void run() {
		Table1.printTable(4);
	}
}

class MyThread4 extends Thread {
	public void run() {
		Table1.printTable(200);
	}
}

public class TestSynchronization4 {
	public static void main(String t[]) {
		MyThread3 t3 = new MyThread3();
		MyThread4 t4 = new MyThread4();
		t3.start();
		t4.start();
	}
}
