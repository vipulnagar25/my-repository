package com.designpatterns.creational.singleton;


import java.io.ObjectStreamException;
import java.lang.reflect.Constructor;

public class SingleTon {
    private static SingleTon INSTANCE = null;
    public int variable = 10;

    private SingleTon() {
        if(INSTANCE != null) {
            throw new RuntimeException();
        }
    }

    public static SingleTon getInstance() {
        if(INSTANCE == null) { // double  mechanism
            synchronized(SingleTon.class) {
                if(INSTANCE == null) {
                    INSTANCE = new SingleTon();
                }
            }
        }
        return INSTANCE;
    }

    public Object clone() throws CloneNotSupportedException {
        // return INSTANCE
        throw new CloneNotSupportedException();
    }

    private Object readResolve() throws ObjectStreamException {
        System.out.println("At the time read object from file");
        return INSTANCE;
    }

    private Object writeReplace() throws ObjectStreamException {
        System.out.println("At the time write object into  file");
        return INSTANCE;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        SingleTon singleTon = getInstance();
        System.out.println(singleTon.variable + "  just do it");
        SingleTon singleTon1 = null;
        // try to break singleton design property
        try {
            Constructor constructor = SingleTon.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            singleTon1 = (SingleTon) constructor.newInstance();
        } catch(Exception ex) {
            System.out.println(ex);
        }

        System.out.println("Hashcode of Object 1 - " + singleTon.hashCode());
        System.out.println("Hashcode of Object 2 - " + singleTon1);
        // by cloning
        /*SingleTon singleTon2= (SingleTon) singleTon.clone();
        System.out.println(singleTon2.hashCode());*/


    }
}
