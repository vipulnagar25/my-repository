package com.immutable;

import java.util.HashMap;

public final class Student {

    private String name;
    private HashMap<String, String> map;
    private int stuId;

    private Address address;


    public String getName() {
        return name;
    }

    public HashMap<String, String> getMap() {
        return (HashMap<String, String>) map.clone();
    }

    public int getStuId() {
        return stuId;
    }

    public Address getAddress() throws CloneNotSupportedException {
        return (Address) address.clone();
    }

    public Student(int stuId, String name, HashMap<String, String> map, Address address) {
        this.stuId = stuId;
        this.name = name;
        this.map = map;
        this.address = address;
        System.out.println("Student setup done");
    }


}
