package com.collectionrnd;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Program {
    public static void main(String[] args) {
int i=1*2;
        List<Emp> em1=new ArrayList<>();
        Emp emp1 = new Emp("vipul", 29);
        Emp emp2 = new Emp("vipul1", 3);
        Emp emp3 = new Emp("vipul1", 23);
        Emp emp4 = new Emp("vipul1", 24);
        Emp emp5 = new Emp("vipul1", 24);
        em1.add(emp1);
        em1.add(emp2);
        em1.add(emp3);
        em1.add(emp4);
        Map<Emp, String> map = new HashMap<>();
        map.put(emp1, "vipul");
        map.put(emp2, "vipul1");
        //   map.put(emp1, "vipul2");
        //System.out.println(map.size());
       // System.out.println(map);
     //   em1.sort((e1,e2)->e1.getAge()- e2.getAge());
    //  List<Emp> ee=  em1.stream().sorted((e1,e2)->e2.getAge()-e1.getAge()).limit(3).collect(Collectors.toList());
       List<Emp>ee1= em1.stream().distinct().collect(Collectors.toList());
        System.out.println(ee1);
       // System.out.println(ee);
       // System.out.println(em1);
    }
}
