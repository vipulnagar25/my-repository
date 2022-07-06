package com.problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RemoDuplicateByStream {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("3");
        list.add("4");
        list.forEach(System.out::print);
        List<String> list2 = list.stream().distinct().collect(Collectors.toList());
        System.out.println();
        list2.forEach(System.out::print);
        System.out.println();
        List<String> list21 = list.stream().filter(i -> Collections.frequency(list, i) > 1).distinct().collect(Collectors.toList());
        System.out.println(list21);
        Map<String, Long> result = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(result);


    }
}
