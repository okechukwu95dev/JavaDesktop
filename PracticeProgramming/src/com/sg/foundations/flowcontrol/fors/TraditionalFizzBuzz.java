package com.sg.foundations.flowcontrol.fors;

import java.util.Scanner;

public class TraditionalFizzBuzz {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        int fizzBuzzCounter= 0;
        String userInputString;

        //prompt for user input
        System.out.println("Please give me your number");
        userInputString = userInput.nextLine();
        int userNumber = Integer.parseInt(userInputString);
        System.out.println("ypu chose " + userNumber + " as input");


        for (int i = 0; i <= userNumber; i++ ){
            if(i == 0){
                System.out.println(i);
            }

            else if (i % 5 == 0 && i % 3 == 0 ){
                System.out.println("fizzbuzz ");
                fizzBuzzCounter ++;
            }
            else if (i % 5 == 0){
                System.out.println("Buzz");
                fizzBuzzCounter ++;
            }

            else if (i % 3 == 0){
                System.out.println("Fizz");
                fizzBuzzCounter ++;
            }

            else{
                System.out.println(i);
            }

        }

        System.out.println("You have  " +  fizzBuzzCounter + "fizz, buzz or fizzbuzzes");

    }
}
