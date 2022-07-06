package com.collectionframework;

import java.util.HashSet;
import java.util.Set;

public class SetProgram {
    public static void main(String[] args) {
        Set<Farmer> set = new HashSet<>();
        Farmer farmer1 = new Farmer(1, "vipul", "wheat");
        Farmer farmer2 = new Farmer(1, "vipul", "wheat");
        Farmer farmer3 = new Farmer(2, "he", "wheat");
        Farmer farmer4 = new Farmer(2, "he", "wheat");
        Farmer farmer5 = new Farmer(3, "chotu", "wheat");
        set.add(farmer1);
        set.add(farmer2);
        set.add(farmer3);
        set.add(farmer4);
        set.add(farmer5);
        System.out.println(set.size());

    }
}
