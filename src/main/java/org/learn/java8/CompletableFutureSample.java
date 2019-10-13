package org.learn.java8;

import java.util.concurrent.CompletableFuture;

/**
 * Created by vinay on 1/5/19.
 */
public class CompletableFutureSample {
    public static int compute() {
        System.out.println("COMPUTE "+Thread.currentThread());
        return 2;
    }
    public static void printIt(int data) {
        System.out.println("PRINT IT "+data+" "+Thread.currentThread());
    }

    public static CompletableFuture<Integer> create() {
        System.out.println(Thread.currentThread());
        return CompletableFuture.supplyAsync(() -> compute());
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread());
        create().thenAccept(data -> printIt(data));
    }
}
