package com.java8;

import java.util.Optional;

public class ClassOptional {
    public static void main(String[] args) {
        String message = null;
        Optional<String> stringOptional = Optional.ofNullable(message);
        if(stringOptional.isPresent()) {
            System.out.println(stringOptional.get());
        } else {
            System.out.println("null-->");
        }
        System.out.println(stringOptional);
        Optional<String> stringOptional1 = Optional.ofNullable(message);
       // System.out.println(stringOptional1.get());


    }
}
