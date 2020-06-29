package com.designPattern.creational.singleton;

public class Singleton {
    private static Singleton singleton;
    private Singleton() {
    }
    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();//instance will be created at request time
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {

        Singleton s1 = getSingleton();
    }
}
