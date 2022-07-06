package com.immutable;

import com.sun.tools.javac.Main;

import java.util.HashMap;

public class Operation {
    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("check it");
        HashMap<String, String> map = new HashMap<>();
        map.put("key", "value");
        map.put("key1", "value1");
        Address address = new Address();
        address.setPinCode(246723);
        address.setStreet("main");
        Student student = new Student(1, "vipul", map, address);
        Address address1 = student.getAddress();
        address1.setStreet("vipul");
        System.out.println(student.getAddress().getStreet());

    }
}
