package org.learn.lambdas;

/**
 * Created by vinay on 14/4/19.
 */
public class TimeIt {
    public static void code(Runnable block) {
        long start = System.nanoTime();
        try {
            block.run();
        } finally {
            long end = System.nanoTime();
            System.out.println("TIME taken(s) "+(end - start)/1.0e9);
        }
    }
}
