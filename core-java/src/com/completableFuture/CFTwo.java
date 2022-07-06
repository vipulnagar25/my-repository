package com.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CFTwo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> runnable = CompletableFuture.runAsync(() -> {

            System.out.println("executing runnable task with no result returned");

        });

        System.out.println("runnable result:" + runnable);


    }
}
