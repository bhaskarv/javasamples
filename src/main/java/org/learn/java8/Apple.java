package org.learn.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by vinay on 21/4/19.
 */
public class Apple {
    private COLOR color;
    private int weight;

    public Apple(COLOR color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public COLOR getColor() {
        return color;
    }

    public int getWeight() {
        return weight;
    }

    public boolean isGreen() {
        return COLOR.GREEN.equals(getColor());
    }

    public boolean isHeavy() {
        return getWeight() > 130;
    }

    public static List<Apple> filterApples(List<Apple> apples, Predicate<Apple> p) {
        List<Apple> filteredApples = new ArrayList<>(apples.size());
        for (Apple apple : apples) {
            if (p.test(apple)) {
                filteredApples.add(apple);
            }
        }
        return filteredApples;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color=" + color +
                ", weight=" + weight +
                '}';
    }
}
