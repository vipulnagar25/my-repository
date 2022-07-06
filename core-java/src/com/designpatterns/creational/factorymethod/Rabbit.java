package com.designpatterns.creational.factorymethod;

class Dog implements Animal {
    @Override
    public void eat() {
        System.out.println("Dog is eating, woof!");
    }
}

class Cat implements Animal {
    @Override
    public void eat() {
        System.out.println("Cat is eating, meow!");
    }
}

public class Rabbit implements Animal {
    @Override
    public void eat() {
        System.out.println("Rabbit is eating, squeak!");
    }
}
