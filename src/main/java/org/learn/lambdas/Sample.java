package org.learn.lambdas;

/**
 * Created by vinay on 13/4/19.
 */
public class Sample {
    public static void main(String[] args) {
        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("In another thread");
            }
        });
        th.start();

        new Thread(() -> System.out.println("In Lambda thread")).start();

        System.out.println("In main thread");
    }
}
