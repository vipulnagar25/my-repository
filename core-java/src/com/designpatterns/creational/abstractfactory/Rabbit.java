package com.designpatterns.creational.abstractfactory;

class Dog implements Pet {
    @Override
    public void eat() {
        System.out.println("Dog is eating, woof!");
    }
}

class Cat implements Pet {
    @Override
    public void eat() {
        System.out.println("Cat is eating, meow!");
    }
}

public class Rabbit implements Pet {
    @Override
    public void eat() {
        System.out.println("Rabbit is eating, squeak!");
    }
}