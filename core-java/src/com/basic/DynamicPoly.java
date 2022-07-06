package com.basic;

class Dynamic {
    int i = 10;

    void test(int i) {
        System.out.println("I am form Dynamic  ::" + i);

    }

}

public class DynamicPoly extends Dynamic {
    int i = 11;

    public void test(int i) {
        System.out.println("I am form DynamicPoly   ::" + i);

    }

    public static void main(String[] args) {
        Dynamic dynamic = new Dynamic();
        dynamic.test(dynamic.i);
        Dynamic dynamic1 = new DynamicPoly();
        DynamicPoly dynamic12 = new DynamicPoly();
        System.out.println(dynamic12.i);
        dynamic1.test(dynamic1.i);
    }

}
