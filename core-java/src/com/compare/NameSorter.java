package com.compare;

import java.util.Comparator;

public class NameSorter implements Comparator<Person> {


    @Override
    public int compare(Person p1, Person p2) {
        return p1.name.compareTo(p2.name);
    }
}
