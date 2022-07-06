package com.collectionframework;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapProgram {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        System.out.println(map.put("key1", "value1"));
        System.out.println(map.put("key1", "value1"));
        System.out.println(map.put("key2", "value2"));
        System.out.println(map.put(null, "check1"));
        System.out.println(map.put(null, "check"));
        System.out.println(map.size());
        Map<Farmer, String> map1 = new HashMap<>();
        Farmer farmer1 = new Farmer(1, "vipul", "wheat");
        Farmer farmer2 = new Farmer(1, "vipul", "wheat");
        Farmer farmer3 = new Farmer(2, "he", "wheat");
        Farmer farmer4 = new Farmer(2, "he", "wheat");
        Farmer farmer5 = new Farmer(3, "chotu", "wheat");
        System.out.println(map1.put(farmer1, "wheat1"));
        System.out.println(map1.put(farmer2, "wheat2"));
        System.out.println(map1.put(farmer3, "wheat3"));
        System.out.println(map1.put(farmer4, "wheat4"));
        System.out.println(map1.put(farmer5, "wheat5"));
        System.out.println(map1.size());
        System.out.println(32222 & 15);
        Map<String, Object> map2 = new Hashtable<>();
        map2.put("key1", "value1");
        map2.put("key1", "value1");
        map2.put("key2", "value2");
        //map2.put("key3", null);
        // map2.put(null, "value2");
        System.out.println(map2);
        Map<Farmer, String> map3 = new ConcurrentHashMap<>();


    }
}
