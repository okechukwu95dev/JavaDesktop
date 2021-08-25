package com.sg.foundations.flowcontrol.random;

import java.io.InputStream;
import java.util.Random;
import java.util.Scanner;

public class GuessMeMore {



    public static void main(String[] args) {
        int myInt = 30;
        String userNum = "";
        int userNumInt  = 0;


        //initialise scanner
        Scanner userInput = new Scanner(System.in);

        //initialise random
        Random randomizer = new Random();

        //use random to get next int
        //int random_integer = rand.nextInt(upperbound-lowerbound) + lowerbound;
        int random_integer  = randomizer.nextInt(200) -100;


        //do while loop asking the user for more input
        do {
            //ask user to pick number
            System.out.println("Please give me a number");
            userNum = userInput.nextLine();

            //Convert user input to integer
            userNumInt = Integer.parseInt(userNum);

            if (random_integer > userNumInt){
                System.out.println("Ha, nice try - too low! ");
            }

            if (random_integer < userNumInt){
                System.out.println("Too bad, way too high. ");
            }

            if (random_integer ==  userNumInt){
                System.out.println("Wow, nice guess! That was it!");
            }

        } while (userNumInt != random_integer);

    }

}
