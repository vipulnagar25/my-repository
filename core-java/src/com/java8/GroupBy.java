package com.java8;


import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupBy {
    static class Item {
        private String name;
        private int qty;

        public String getName() {
            return name;
        }

        public int getQty() {
            return qty;
        }

        public BigDecimal getPrice() {
            return price;
        }

        private BigDecimal price;

        public Item(String name, int qty, BigDecimal price) {
            this.name = name;
            this.qty = qty;
            this.price = price;
        }
    }

    public static void main(String[] args) {
        List<String> items =
                Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya");
        Map<String, Long> map = items.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        //    System.out.println(map);
        Map<String, Long> finalMap = new LinkedHashMap<>();
        map.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue()
                        .reversed()).forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));

        // System.out.println(finalMap);
        List<GroupBy.Item> items1 = Arrays.asList(
                new GroupBy.Item("apple", 10, new BigDecimal("9.99")),
                new GroupBy.Item("banana", 20, new BigDecimal("19.99")),
                new GroupBy.Item("orange", 10, new BigDecimal("29.99")),
                new GroupBy.Item("watermelon", 10, new BigDecimal("29.99")),
                new GroupBy.Item("papaya", 20, new BigDecimal("9.99")),
                new GroupBy.Item("apple", 10, new BigDecimal("9.99")),
                new GroupBy.Item("banana", 10, new BigDecimal("19.99")),
                new GroupBy.Item("apple", 20, new BigDecimal("9.99"))
        );
        Map<String, Long> map1 = items1.stream().collect(Collectors.groupingBy(GroupBy.Item::getName, Collectors.counting()));
        System.out.println(map1);
        Map<String, Integer> sum = items1.stream().collect(Collectors.groupingBy(GroupBy.Item::getName, Collectors.summingInt(GroupBy.Item::getQty)));
        ;
        System.out.println(sum);
        List<String> uniqueList = items.stream().distinct().collect(Collectors.toList());
        System.out.println(uniqueList);
//       Map<String, List<Integer>> map4 = items.stream().collect(Collectors.groupingBy(Item::getName,Collectors.mapping(Item::getQty, Collectors.mapping(Item::getQty,
//                Collectors.toList()))));
//
//

       // System.out.println("Result 3 : " + result3);

//        map.entrySet().stream().sorted(Comparator.comparing(i -> i.getValue().Name))
//                .collect(Collectors.toMap(
//                        Map.Entry::getKey,
//                        Map.Entry::getValue,
//                        (e1, e2) -> e1, LinkedHashMap::new));


    }
}
