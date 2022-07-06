package com.compare;

import java.util.*;

public class Manager {
    public static void main(String[] args) {
        Person person = new Person();
        person.setAge(21);
        person.setName("vipul");
        person.setLastName("nagar");
        Person person1 = new Person();
        person1.setAge(20);
        person1.setName("shalu");
        person1.setLastName("nagar");
        List<Person> personList = new ArrayList<>();
        personList.add(person);
        personList.add(person1);
        System.out.println(personList);
        System.out.println("===============================");
        Collections.sort(personList);
       /* System.out.println(personList);
        System.out.println("===============================");
        Collections.sort(personList, new NameSorter());
        System.out.println(personList);
        System.out.println("===============================");
        Collections.sort(personList, new AgeSorter());
        System.out.println(personList);*/


    }
}
