package com.problem;

import java.util.Stack;

public class BalancedBrackets {
    static boolean areBracketsBalanced(String expr) {
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < expr.length(); i++) {
            if(expr.charAt(i) == '{' || expr.charAt(i) == '(' || expr.charAt(i) == '[') {
                stack.push(expr.charAt(i));
            } else if(expr.charAt(i) == '}' || expr.charAt(i) == ')' || expr.charAt(i) == ']') {
                if(stack.empty()) {
                    return false;
                }
                stack.pop();
            }
        }
        if(stack.empty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String expr = "{}";
        System.out.println("This string areBracketsBalanced ::  " + areBracketsBalanced(expr));
    }
}
