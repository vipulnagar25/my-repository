package com.Java8;

import sun.rmi.runtime.NewThreadAction;

class A1 {
    public void show() {
        System.out.println("show of A1");
    }
}

class B1 extends A1 {
    public void show() {
        System.out.println("show of B1");
    }

    public void display() {
        System.out.println("display of B1");
    }
}


public class MainProgram {
    public static void main(String[] args) {
        A1 ss=new B1();
        B1 ss1= (B1) new A1();
        ss1.display();
    }

}
