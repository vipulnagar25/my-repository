package com.designpatterns.structural.proxy;

public class RealObjectImpl implements RealObject {
    @Override
    public void doSomething() {
        System.out.println("Performing work in real object");
    }

}
