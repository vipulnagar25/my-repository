package com.designpatterns.structural.facade;

class Lion implements Animal {
    @Override
    public void feed() {
        System.out.println("The lion is being fed!");
    }
}

class Wolf implements Animal {
    @Override
    public void feed() {
        System.out.println("The wolf is being fed!");
    }
}

public class Bear implements Animal {
    @Override
    public void feed() {
        System.out.println("The bear if being fed!");
    }
}
