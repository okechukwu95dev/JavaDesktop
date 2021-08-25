package com.sg.foundations.flowcontrol.ifs;
import java.util.Scanner;

public class MiniZork {

    public static void main(String[] args) {

        //initialising scanner to ask for user input
        Scanner userInput = new Scanner(System.in);

        //story build up
        System.out.println("You are standing in an open field west of a white house,");
        System.out.println("With a boarded front door.");
        System.out.println("There is a small mailbox here.");
        System.out.print("Go to the house, or open the mailbox? ");


        //declare and iniitlaise variable to ask user for input in scanner
        String action = userInput.nextLine();

        //Begin conditionals
        if (action.equals("open the mailbox")){
            System.out.println("You open the mailbox.");
            System.out.println("It's really dark in there.");
            System.out.print("Look inside or stick your hand in? ");

            //ask user for choice and assign to action variable
            action = userInput.nextLine();

            //if user sticks his hand inside, do the following
            if (action.equals("look inside")){
                System.out.println("You peer inside the mailbox.");
                System.out.println("It's really very dark. So ... so very dark.");
                System.out.print("Run away or keep looking? ");

                //ask user for choice and assign to action variable
                action = userInput.nextLine();

                //if user keeps looking do the following
                if (action.equals("keep looking")){
                    System.out.println("Turns out, hanging out around dark places isn't a good idea.");
                    System.out.println("You've been eaten by a grue.");
                }

                else if (action.equals("run away")){
                    System.out.println("You run away screaming across the fields - looking very foolish.");
                    System.out.println("But you alive. Possibly a wise choice.");
                }

            }

            else if (action.equals("stick your hand in")){
                System.out.print("You stuck your hand in");

            }
        }

        else if(action.equals("go ot the house")){
            System.out.print("You went to the house ");

        }

    }
}
