package com.java8;

import java.util.LinkedList;
import java.util.List;

public class EraSure<T> {
    T data;

    public T getData() {
        return data;
    }

    public static void main(String[] args) {
        EraSure eraSure = new EraSure();
        eraSure.data = 10;
        List<String> list=new LinkedList<>();
        list.add("abc");

        System.out.println(eraSure.data);
    }
}
