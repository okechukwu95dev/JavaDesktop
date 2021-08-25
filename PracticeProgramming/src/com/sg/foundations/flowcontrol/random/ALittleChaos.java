package com.sg.foundations.flowcontrol.random;

import java.util.Random;

public class ALittleChaos {

    public static void main (String[] args){

        //set up random
        Random randomizer = new Random();

        System.out.println("Random makes integers: " + randomizer.nextDouble());
        System.out.println("Random makes doubles: " + randomizer.nextInt());
        System.out.println("Random makes booleans: " + randomizer.nextBoolean());

        int num = randomizer.nextInt(50)+50;


        System.out.println("You can store a randomized result: " + num);
        System.out.println("And use it over and over again: " + num + ", " + num);

        System.out.println("Or just keep generating new values");
        System.out.println("Here's a bunch of numbers from 0 - 100: ");

        System.out.print(randomizer.nextInt(51) + 50 + ", ");


        System.out.print(randomizer.nextInt(101) + ", ");
        System.out.print(randomizer.nextInt(101) + ", ");
        System.out.print(randomizer.nextInt(101) + ", ");
        System.out.print(randomizer.nextInt(101) + ", ");
        System.out.println(randomizer.nextInt(101));
    }
}


