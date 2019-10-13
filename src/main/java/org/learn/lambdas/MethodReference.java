package org.learn.lambdas;

import java.util.Arrays;
import java.util.List;

/**
 * Created by vinay on 14/4/19.
 */
public class MethodReference {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10,20,42,51,32,76,54,12,60);

        Integer[] ints = {1,3,2,5};

        Arrays.stream(ints)
                .map(e -> 3 *  e)
                .forEach(System.out::println);

        System.out.println("SUM IS "+
        numbers.stream()
                .reduce(10, (total, e) -> Integer.sum(total, e)));


        System.out.println("SUM IS "+
                numbers.stream()
                        .reduce(0, Integer::sum));

        System.out.println("CONCAT : "+
                numbers.stream()
                        .map(String::valueOf)
                        //.reduce("",String::concat));
                        .reduce("",(carry, e) -> carry.concat(e+",")));

    }






}
