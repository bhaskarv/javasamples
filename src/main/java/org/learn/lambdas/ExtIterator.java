package org.learn.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by vinay on 14/4/19.
 */
public class ExtIterator {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,5,2,6,9,0,10);

        for(int i=0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        for(int e:list) {
            System.out.println(e);
        }

        System.out.println(" CONSUMER ***** ");
        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });

        //Lambda
        System.out.println(" LAMBDA *** ");
        list.forEach( e -> System.out.println(e));

        list.forEach(System.out::println);
    }
}
