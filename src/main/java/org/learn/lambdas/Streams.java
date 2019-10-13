package org.learn.lambdas;

import java.util.Arrays;
import java.util.List;

/**
 * Created by vinay on 14/4/19.
 */
public class Streams {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,4,2,5,3,7,2,9,0,8,3,9);

        //Sum the odd numbers
        int sum = 0;
        for (int e : numbers) {
            if (e % 2 != 0) {
                sum += e;
            }
        }
        System.out.println(" SUM : "+sum);

        System.out.println(" NEW SUM : "+
        numbers.stream()
                .filter(e -> e%2 != 0)
                .mapToInt(e -> e * 1)
                .sum());

        System.out.println(" EVEN SUM : "+
                numbers.stream()
                        .filter(e -> e%2 == 0)
                        .reduce(0, Integer::sum));
    }
}
