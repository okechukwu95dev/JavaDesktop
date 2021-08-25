package com.sg.foundations.Exercises.Week1;
import java.awt.*;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class CoinFlip {
    public static void main(String[] args) {
        int min = -5;//upper bound random alteration
        int max = 5;//lower bound random alteration
        int arrayIndex= 0;//to store index of values as they enter the array
        int heads = 0;// to store number of heads
        int tails = 0;// to store number of tails

        Scanner scan = new Scanner(System.in); //ask user for input
        System.out.println("How many times do you want to flip:   ");
        int currentInput =Integer.parseInt(scan.nextLine());

        while(true){//validate
            //select random number from -5 to 5
           int randomAlteration = (int)Math.floor(Math.random() * (max-min +1 ) + min);
           System.out.println("Our random adjustment gives us: UserInput: " + currentInput + " + " + randomAlteration);
//           System.out.println(currentInput);

            //check if user input with alteration gives us invalid values
           if (currentInput +  randomAlteration > 0 ){
               currentInput += randomAlteration;
               System.out.println("Our current adjusted input is: " + currentInput);
               break;
           }
           else {
               System.out.println("Invalid input");
           }
       }
       String[] coinContainer = new String[currentInput];

        for (int i=1; i<= currentInput;i++){
            coinContainer[arrayIndex] = flipCoin();
            if (coinContainer[arrayIndex].equals("heads")){
                heads++;
            }
            else{
                tails++;
            }
            arrayIndex++;
        }
        System.out.println("Your resulting flips are" + Arrays.toString(coinContainer));
        System.out.println("individual heads: " + heads );
        System.out.println("individual tails: " + tails);
    }

    public static String flipCoin(){
        Random coinFlip = new Random();
        boolean flipped = coinFlip.nextBoolean();
        if (flipped == true){
            return "heads";
        }
        else{
             return "tails";
        }
    }
}
