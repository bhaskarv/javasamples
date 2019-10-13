package org.learn.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * Created by vinay on 21/4/19.
 */
public class PredicateEx {

    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(new Apple(COLOR.RED, 200),
                                new Apple(COLOR.GREEN, 100),
                                new Apple(COLOR.RED,90),
                                new Apple(COLOR.GREEN,160)
                                );

        System.out.println("GREEN APPLES "+Apple.filterApples(apples, Apple::isGreen));
        System.out.println("BIG APPLES : "+Apple.filterApples(apples,Apple::isHeavy));
        System.out.println("BIG GREEN APPLES "+Apple.filterApples(apples, e -> e.isHeavy() && e.isGreen()));
        System.out.println("RED APPLES "+Apple.filterApples(apples, e-> COLOR.RED.equals(e.getColor())));
        System.out.println("SMALL APPLES "+Apple.filterApples(apples, e->e.getWeight() < 100));

        System.out.println(
        apples.stream()
                .filter(e->e.getWeight() > 70)
                .collect(Collectors.groupingBy(Apple::getColor)));

        System.out.println(
                apples.stream().filter(e->e.isGreen())
                                .map(Apple::getWeight)
                                    .collect(toList()));
    }
}
