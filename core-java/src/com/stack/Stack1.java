package com.stack;


public class Stack1 {
    Object[] elements;
    int stackSize;
    int capacity = 10;

    public Stack1() {
        elements = new Object[capacity];
        stackSize = 0;
    }

    public void push(Object obj) {
        if (stackSize == capacity) {
            alterCapacity();
            alterStack();
        }
        elements[stackSize++] = obj;
    }

    public void alterCapacity() {

        capacity = capacity + capacity << 1;
    }

    public Object pop() {
        Object obj = null;
        if (stackSize == 0) {
            System.out.println("there is nothing");
        } else {
            obj = elements[stackSize];
            elements[stackSize--] = null;

        }
        return obj;
    }

    public void alterStack() {

        Object[] newElements = new Object[capacity];
        for (int i = 0; i < elements.length; i++) {
            newElements[i] = elements[i];
        }
        this.elements = newElements;
    }

    public String printStack() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < stackSize; i++) {
            sb.append(elements[i]);
            if (i < stackSize - 1)
                sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }


    public static void main(String[] args) {
        Stack1 stack = new Stack1();
        stack.push("0");
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");
        stack.push("6");
        stack.push("7");
        stack.push("8");
        stack.push("9");
        stack.push("10");
        stack.push("11");
        stack.push("12");
        stack.push("13");
        System.out.println(stack.stackSize);
        System.out.println(stack.printStack());
        System.out.println(stack.pop());
        System.out.println(stack.stackSize);
        System.out.println(stack.printStack());
    }
}
