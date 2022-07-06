package com.java8;


interface Interface_One {
    default void defaultMethod() {
        System.out.println("Interface_One::defaultMethod");
    }

}

interface Interface_Two {

    default void defaultMethod1() {
        System.out.println("Interface_Two::defaultMethod1");
    }
}

@FunctionalInterface
interface Check {
    int value = 10;

    int addition(int n1, int n2);

    static void static_print() {
        System.out.println("TestInterface::static_print ()");
    }

    default void static_print1() {
        System.out.println("TestInterface::static_print ()1");
    }
}

class OnlyStatic {
    static {
        System.out.println("vipul");
    }

    final static int value = 11;

}

abstract class OnlyAbstract {
    public abstract void test();

    static {
        System.out.println("vipul");
    }

    final static int value = 456;
}

public class FunctionalInterFace implements Interface_One, Interface_Two {
    public static void main(String[] args) {
        System.out.println("vipul-nagar");
        Check c2 = (s1, s2) -> s1 + s2;
        System.out.println(c2.addition(2, 3));
        Check.static_print();
        c2.static_print1();
        System.out.println(Check.value);
        System.out.println(OnlyStatic.value);
        System.out.println(OnlyAbstract.value);
        Interface_One managerProgram1 = new FunctionalInterFace();
        managerProgram1.defaultMethod();
        Interface_One managerProgram2 = new FunctionalInterFace();
        managerProgram2.defaultMethod();
    }


}
