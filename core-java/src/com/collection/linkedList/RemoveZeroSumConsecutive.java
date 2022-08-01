package com.collection.linkedList;

import java.util.LinkedList;
import java.util.Stack;

public class RemoveZeroSumConsecutive {
    public static void removeZeroSumConsecutive(LinkedList<Integer> linkedList) {
        Stack<Integer> stack = new Stack<>();
        linkedList.forEach(element -> {
            if (element > 0) {
                stack.push(element);
            }
            if (element < 0) {
                int sum = element;
                while (!stack.empty()) {
                    sum = sum + stack.pop();
                    if (sum == 0) {
                        break;
                    }

                }

            }


        });
        System.out.println(stack);

    }


    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        //1,2,-3,3,1
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(-3);
        linkedList.add(3);
        //linkedList.add(-2);
        linkedList.add(1);
        //linkedList.add(-1);
        removeZeroSumConsecutive(linkedList);
    }
}
