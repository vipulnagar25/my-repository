package com.designPattern.creational.singleton;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializedSingleton implements Serializable {

    private static final long serialVersionUID = -7604766932017737115L;

    private SerializedSingleton() {
    }

    private static class SingletonHelper {
        private static final SerializedSingleton instance = new SerializedSingleton();
    }

    public static SerializedSingleton getInstance() {
        return SingletonHelper.instance;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        System.out.println("writeObject");
    }
    private void readObject(ObjectInputStream in) throws IOException,ClassNotFoundException {
        System.out.println("readObject");
    }
    protected Object readResolve() {
        System.out.println("readResolve");
        return getInstance();
    }
}
