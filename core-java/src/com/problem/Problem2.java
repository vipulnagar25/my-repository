package com.problem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Problem2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.forEach(ele->{
           list.remove("aaaa");

        });

        for(int i=0;i<list.size();i++){
         list.remove(i);
        }
        List<String> marvel = new CopyOnWriteArrayList<>();
        marvel.add("a");
        marvel.add("b");
        marvel.add("c");
        marvel.add("d");
        marvel.forEach(ele->{
          //  System.out.println(ele+"check");
          marvel.remove("a");
        });
        //System.out.print(marvel);
//        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            System.out.print(iterator.next() + ", ");
//            iterator.remove();
//        }
        System.out.print(list);

    }
}
