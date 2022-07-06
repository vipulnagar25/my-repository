package com.basic;

class Override1 {
    public Override1 test() {
        return new Override2();
    }

}

class Override2 extends Override1 {
    public Override1 test() {
        return new Override1();//covariant
    }
}

public class Override extends Override2 {

    public static void main(String[] args) {
        System.out.println("Override");
    }

}
