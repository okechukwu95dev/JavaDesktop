package com.sg.foundations.Exercises.DataStructures;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListPractice {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();
        List<Boolean> truths = new ArrayList<>();
        List<Character> chars = new ArrayList<>();

        strings.add("A");
        strings.add("C");
        strings.add("A");



        System.out.println(strings);
//
//        for (int i = 0; i < strings.size();i++){
//            System.out.println(strings.get(i));
//        }

        for (String currentString : strings){
            System.out.println(currentString);
        }

        Iterator<String> iterator = strings.iterator();







    }


}
