package com.sg.foundations.flowcontrol.whiles;

import java.util.Random;

public class LazyTeenager {

    public static void main(String[] args) {
            boolean isClean = false; // state of room
            int parentCounter = 0; //instruction from the parent
            int cleaningChance = 10; // chance the child will clean their room
            int randomChanceChildWillClean;// threshold for cleaning to take place

            //initialise random number
            Random randomizer = new Random();
            randomChanceChildWillClean = randomizer.nextInt(100)+1;
            System.out.println(randomChanceChildWillClean);

            do
            {
                System.out.println("Clean your room " + parentCounter);//Parent says clean your room

                if (parentCounter >= 7 )
                {
                    System.out.println("No X box for you");
                    break;
                }

                //check if the chance is greater than the random
                // generated threshold for him to clean
                if (cleaningChance >= randomChanceChildWillClean)
                {
                    isClean = true;
                    System.out.println("Thanks for cleaning");
                }

                cleaningChance += 10;
                parentCounter+=1;
            }
            while(!isClean);
        }
}
