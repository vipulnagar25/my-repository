package com.Java8;

import java.util.ArrayList;
import java.util.List;

public class AASA {
    public static List<Integer> sort(List<Integer> toSortArray) {
        for (int i = 0; i < toSortArray.size(); i++) {

            for (int j = toSortArray.size() - 1; j > i; j--) {
                if (toSortArray.get(i) > toSortArray.get(j)) {

                    int tmp = toSortArray.get(i);
                    toSortArray.set(i, toSortArray.get(i));
                    toSortArray.set(j, tmp);

                }

            }

        }
        return toSortArray;
    }

    public static void main(String[] args) {
        List<Integer> dd=new ArrayList<>();
                dd.add(1);
        dd.add(4);
        dd.add(2);
        sort(dd);
        System.out.println(dd);


    }
}

