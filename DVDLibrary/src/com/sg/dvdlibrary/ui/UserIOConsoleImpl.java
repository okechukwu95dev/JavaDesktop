package com.sg.dvdlibrary.ui;


/**
 *
 * Console implementation of UserIO interface
 * Methods for collecting various input types from user and returns value when checked
 * Also methods for collecting various input types within a range provided in the argument
 * Implement try catch blocks etc.
 *
 * Specific implementations of methods in use interface
 *
 **/

import java.util.Scanner;

public class UserIOConsoleImpl implements UserIO {

    final private Scanner console = new Scanner(System.in);//why do we use final ?


    //Prints out param: msg
    @Override
    public void print(String msg) {
        System.out.println(msg);
    }

    //takes in param: prompts for user to give input
    //it returns the scanned user input after the prompt
    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        return console.nextLine();
    }

    @Override
    public int readInt(String prompt) {
        boolean inputIsValid = false;
        int num = 0; //0 is valid input
        //use while loop for unknown number of iterations
        while (!inputIsValid){
            try{
                //print prompt and set valid input with this classes read string function
                String userInput = this.readString(prompt);
                num = Integer.parseInt(userInput);
//                System.out.println("input is valid");
                inputIsValid = true;
            }
            catch(NumberFormatException e) {
                this.print("Input error. Please try again.");
            }
        }
        return num;//return input
    }

    //ask user for number within range: min & max
    @Override
    public int readInt(String prompt, int min, int max) {
        int result;
        do {
            //read int already takes care of validating the type of the user input
            result = readInt(prompt);
        }while(result < min || result > max);
        return result;
    }

    @Override
    public double readDouble(String prompt) {
        while (true) {
            try {
                return Double.parseDouble(this.readString(prompt));
            } catch (NumberFormatException e) {
                this.print("Input error. Please try again.");
            }
        }
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        double result;
        do {
            result = readDouble(prompt);
        } while (result < min || result > max);
        return result;
    }

    @Override
    public float readFloat(String prompt) {
        while (true) {
            try {
                return Float.parseFloat(this.readString(prompt));
            } catch (NumberFormatException e) {
                this.print("Input error. Please try again.");
            }
        }
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        float result;
        do {
            result = readFloat(prompt);
        } while (result < min || result > max);

        return result;
    }

    @Override
    public long readLong(String prompt) {
        while (true) {
            try {
                return Long.parseLong(this.readString(prompt));
            } catch (NumberFormatException e) {
                this.print("Input error. Please try again.");
            }
        }
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        long result;
        do {
            result = readLong(prompt);
        } while (result < min || result > max);

        return result;
    }

}
