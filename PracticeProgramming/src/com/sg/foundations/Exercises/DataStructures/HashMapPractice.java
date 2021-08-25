package com.sg.foundations.Exercises.DataStructures;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapPractice {

    public static void main(String[] args) {
        Map<String, Integer> populations = new HashMap<>();

        populations.put("boy", 1);
        populations.put("girl", 2);
        populations.put("z", 4);

        Set<String> keys = populations.keySet();
        Collection<Integer> populationValues = populations.values();

        System.out.println(populations.keySet());
        System.out.println(populationValues);

        for (Integer currentPopulation : populationValues){
            System.out.println(currentPopulation);
        }

        for (String key: keys){
            System.out.println(key);
            System.out.println(populations.get(key));
        }

    }






}

