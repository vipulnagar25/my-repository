package com.Java8;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class RndTesting {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> whatsYourNameFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            System.out.println(Thread.currentThread().getName()+":"+Thread.currentThread().getId());
            return "Rajeev";
        });
        CompletableFuture<String> greetingFuture = whatsYourNameFuture.thenApply(name -> {
            System.out.println(Thread.currentThread().getName()+":"+Thread.currentThread().getId());
            return "Hello " + name;
        });

// Block and get the result of the future.
        System.out.println(greetingFuture.get());

    }
}
