package com.java8;

import java.util.*;
import java.util.stream.Collectors;
class Person{
    String name;
    String id;
    public Person(String name, String id) {
        this.name = name;
        this.id = id;
    }



}
public class JavaStreams {
    public static boolean isNumber(String s1) {
        try {
            Integer.parseInt(s1);
            return true;
        } catch(Exception e) {
            return false;
        }


    }

    public static void main(String args[]) {
        List<String> list = new ArrayList<>();
        list.add("Vipul");
        list.add("Kumar");
        list.add("Nagar");
        list.add("123");
        list.add("456");
        list.add("789");
        list.add("yes");
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        List<String> list1 = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(list1);
        List<List<Integer>> number = new ArrayList<>();
        // adding the elements to number arraylist
        number.add(Arrays.asList(1, 2));
        number.add(Arrays.asList(3, 4));
        number.add(Arrays.asList(5, 6));
        number.add(Arrays.asList(7, 8));

        System.out.println("List of list-" + number);

        // using flatmap() to flatten this list
        List<Integer> flatList
                = number.stream()
                .flatMap(numberList -> numberList.stream())
                .collect(Collectors.toList());
        System.out.println(flatList);




        List<Person> l1=new ArrayList<>();
        l1.add(new Person("vipul","1"));
        l1.add(new Person("vipul1","11"));
        List<Person> l2=new ArrayList<>();
        l2.add(new Person("vipul","1"));
        l2.add(new Person("vipul12","112"));
        System.out.println(l1.stream().filter(e-> l2.stream().anyMatch(e1->e1.name.equals(e.name))).findAny().get().name);

    }
}
