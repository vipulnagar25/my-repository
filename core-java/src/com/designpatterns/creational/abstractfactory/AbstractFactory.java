package com.designpatterns.creational.abstractfactory;

public abstract class AbstractFactory {
    public abstract Pet getPet(String pet);
    public abstract Human getHuman(String human);
}