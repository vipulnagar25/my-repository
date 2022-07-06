package com.designpatterns.creational.abstractfactory;

class Child implements Human {
    @Override
    public void feedPet() {
        System.out.println("Child is feeding pet irresponsibly.");
    }
}

class Adult implements Human {
    @Override
    public void feedPet() {
        System.out.println("Adult is feeding pet responsibly.");
    }
}

public class Elder implements Human {
    @Override
    public void feedPet() {
        System.out.println("Elder is overfeeding the pet.");
    }
}