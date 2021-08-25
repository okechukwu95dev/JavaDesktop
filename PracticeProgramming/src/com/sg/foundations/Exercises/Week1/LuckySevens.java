package com.sg.foundations.Exercises.Week1;

import java.util.Random;
import java.util.Scanner;

public class LuckySevens {

    public static void main(String[] args) {
        int playerBet; //Amount player has
        int diceArray; //
        int rolledNumber;//

//        collect players bet
        System.out.println("how much do you want to bet? ");
        Scanner collectBet = new Scanner(System.in);
        int bet = Integer.parseInt(collectBet.nextLine());
        System.out.println(bet);

        //roll dice
        Random diceRoll = new Random();
//        int firstRoll = diceRoll.nextInt(7);
//        System.out.println(firstRoll);

        for (int i=0; i< 100; i++){
            int firstRoll = diceRoll.nextInt(6) +1;
            System.out.println(firstRoll);


        }


}}
