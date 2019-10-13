package org.learn;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by vinay on 5/5/19.
 */
public class Itinerary {
    public static void main(String[] args) {

        Map<String, String> cityPair = new HashMap<>();

        cityPair.put("SFO","HKO");
        cityPair.put("YYZ","SFO");
        cityPair.put("YUL","YYZ");
        cityPair.put("HKO","ORD");


    }

    private static void printItinary(Map<String, String> cityPairs, String startingCity) {
        String dest = cityPairs.get(startingCity);
        Iterator<String> iter =  cityPairs.keySet().iterator();
        while(iter.hasNext()) {

        }
    }
}
