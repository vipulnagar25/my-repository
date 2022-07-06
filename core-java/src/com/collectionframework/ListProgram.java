package com.collectionframework;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListProgram {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("10");
        stringList.add("20");
        stringList.add("30");
        stringList.add("40");
        stringList.add("50");
        stringList.add("60");
        stringList.add("70");
        stringList.add("80");
        stringList.add("90");
        stringList.add("100");
        //  System.out.println(stringList);
        // stringList.add(0, "1");
        // stringList.remove(0);
        System.out.println(stringList);

        List<String> stringList1 = new LinkedList<>();
        stringList1.add("60");
        stringList1.add("70");
        stringList1.add("80");
        stringList1.add("90");
        stringList1.add("100");
        System.out.println(stringList1);

    }

}
