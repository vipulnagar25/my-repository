package com.collectionrnd;

public class Emp {
    public String name;
    public int age;

    public Emp(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int hashCode() {
        System.out.println("hashCode ==>"+super.hashCode());
        return 1;
    }

 /*   @Override
    public boolean equals(Object o) {
        System.out.println("equals ==>");
        return super.equals(o);
    }*/
}
