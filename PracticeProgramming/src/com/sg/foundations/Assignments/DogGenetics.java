package com.sg.foundations.Assignments;

import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

public class DogGenetics {
    public static void main(String[] args) {

        Random rand = new Random();
        Scanner scan = new Scanner(System.in);

        String[] dogs = {"dogA", "dogB", "dogC", "dogD", "dogE"};
        int[] percentages = new int[5];//empty array with 5 elements
        int remainder = 100;

        System.out.println("What is your dog name? ");
        String dogName = scan.nextLine();
        System.out.println("Well then, I have this highly reliable report on "+  dogName + "'s prestigious background right here.");

        System.out.println( dogName + ", Your dog is: \n");

        for (int j = 0; j < percentages.length ; j++){
            percentages[j] = rand.nextInt(remainder);//random number from 0 to 100
            remainder -= percentages[j];//decrement the amount we are subtracting from
        }
        percentages[percentages.length-1] = remainder;
//        System.out.println(Arrays.toString(percentages));

        for (int i = 0; i < dogs.length ; i++){
            System.out.println( percentages[i] + "% " + dogs[i]);
        }

    }

}
