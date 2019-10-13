package org.learn.lambdas;

import java.util.Arrays;
import java.util.List;

/**
 * Created by vinay on 14/4/19.
 */
public class ParallelStream {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        //Sum of even numbers
        TimeIt.code(() -> {
        System.out.println("SUM : "+
                numbers.stream()
                .filter(e -> e%2 == 0)
                .mapToInt(ParallelStream::compute)
                .sum()); }
        );

        //Sum of even numbers - ParallelStream
        TimeIt.code(() -> {
            System.out.println("PARALLEL SUM : "+
                    numbers.parallelStream()
                            .filter(e -> e%2 == 0)
                            .mapToInt(ParallelStream::compute)
                            .sum()); }
        );

        System.out.println("TOTAL SUM : "+
                numbers.stream()
                        .filter(e -> e%2 == 0)
                        .mapToDouble(e -> e * 4.0)
                        .sum()
        );
    }

    public static int compute(int num) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return num * 2;
    }
}
