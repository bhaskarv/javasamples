package org.learn;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by vinay on 1/5/19.
 */
public class MyExecutor {
    private static Integer process() {
    /*    if(sleep(10000)) {
            return 2;
        }
        return null;*/
        System.out.println("starting .... ");
        sleep(10000);
        System.out.println("done work!!!");
        return  2;
    }

    private static boolean sleep(int duration)  {
        try {
            Thread.sleep(duration);
            return  true;
        } catch (InterruptedException e) {
            System.out.println("Interrupted...");
            return false;
        }
    }

    public static void main(String[] args)  throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Future<Integer> task = executorService.submit(() -> process());

        System.out.println(task.isDone());
        Thread.sleep(10100);
        System.out.println(task.isDone());
        executorService.shutdown();
        executorService.awaitTermination(15000, TimeUnit.SECONDS);
    }
}
