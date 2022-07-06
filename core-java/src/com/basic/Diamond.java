package com.basic;
interface GrandInter {
    public void test();
}

interface ParentInter  {
    public void test();
}

class Grand implements GrandInter,ParentInter{
    public void test() {
        System.out.println("Grand-class");
    }
}

class Parent {
    public void test() {
        System.out.println("Grand-class");
    }
}

public class Diamond {
    public static void main(String[] args) {
  try {

  }catch(Throwable e){

  }

    }
}
