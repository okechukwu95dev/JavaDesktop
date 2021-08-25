package com.sg.foundations.Assignments;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public static void main(String[] args) {

        //INITIALISE VARIABLES
        //ask user for number of rounds
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int rounds = 0;
        int currentRound = 1;
        int userWins = 0;
        int cpuWins = 0;
        int draws = 0;
        int result;
        int play = 2;
        String[] picks = {"Rock", "Paper", "Scissors"};

        //STARTING THE GAME
        System.out.println("How many rounds do you want to play?");
        rounds = Integer.parseInt(sc.nextLine());
        System.out.println(rounds);

        //Validate input
        if (rounds >= 1 && rounds <= 10) {

            //setting conditions for game to keep running
            while (currentRound <= rounds + 1) {
                System.out.println("\nRound: " + currentRound);//DECLARE ROUND

                //PLAY ROUND
                play = 2;//SET PLAY switch to random variable to be used later
                System.out.println("Select from the following options: \n 1 = Rock \n 2 = Paper \n 3 = Scissors \nYOUR INPUT: ");
                int userPlay = Integer.parseInt(sc.nextLine());//collect users move
                System.out.println("user chose: " + userPlay + "(" + picks[userPlay - 1]+")");
                //remember if statement
                int cpuPlay = rand.nextInt(3) + 1; //generate CPU move
                System.out.println("cpu chose: " + cpuPlay + "(" + picks[cpuPlay - 1]+")");

                //checking for draws
                if (userPlay == cpuPlay){
                    System.out.println("Draw\n");
                    draws +=1;
                }

                /**checking for rock and scissors evaluation.
                 using logic 3 > 2 > 1 to shorten code for evaluations,
                 the only case where it wont work is 3 and 1 as rock beats scissors**/
                else if ( (userPlay == 1 || userPlay ==3) && (cpuPlay == 1 || cpuPlay == 3)){
                    if (userPlay < cpuPlay){
                        System.out.println("User wins\n");
                        userWins++;
                    }
                    else {
                        System.out.println("CPU wins\n");
                        cpuWins++;
                    }
                }

                //checking all other evaluations
                else {
                    if (userPlay > cpuPlay){
                        System.out.println("User wins\n");
                        userWins++;
                    }
                    else {
                        System.out.println("CPU wins\n");
                        cpuWins++;
                    }
                }
                //increase to next round
                if (currentRound == (rounds)) {
                    declareWinner(userWins, draws, cpuWins);

                    System.out.println("Play again?\n1 for YES \n0 for NO");
                    play = Integer.parseInt(sc.nextLine());
                    if (play == 1) {// if user plays again
                        System.out.println("Lets play again");
                        System.out.println("How many rounds do you want to play?");
                        rounds = Integer.parseInt(sc.nextLine());
                        currentRound = 1;
                    }
                    if (play == 0) {
                        System.out.println("Thanks for playing");
                        break;
                    }
                }
                else {
                    currentRound++;
                }
            }
        }
        else {
            System.out.println("Invalid input, we will now quit");
        }
    }


    public static void declareWinner(int userWins, int draws, int cpuWins) {
        System.out.println("The results are as follows:\nUser Wins: " + userWins + "\nDraws: " + draws + "\nCpu Wins: " + cpuWins);//declare winner
        if (userWins == cpuWins) {
            System.out.println("The overall result is a tie\n");
        }
        if (userWins > cpuWins) {
            System.out.println("The USER IS THE WINNER\n");
        }
        if (cpuWins > userWins) {
            System.out.println("THE CPU HAS WON\n");
        }
    }

}
