package com.sg.foundations.flowcontrol.whiles;

public class WaitAWhile {

    public static void main(String[] args) {

        int timeNow = 5;
        int bedTime = 10;

        while(timeNow < bedTime){
            System.out .println("Its only " + timeNow + " o'clock!");
            System.out.println("I think Ill stay up just a liiiittle longer..");
            timeNow++; //time passes along
        }

        System.out.println("Oh it's " + timeNow + " o'clock");
        System.out.println("Guess  I should go to bed");

    }
}
