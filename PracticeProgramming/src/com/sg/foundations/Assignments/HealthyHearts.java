package com.sg.foundations.Assignments;

import java.util.Scanner;

public class HealthyHearts {

    //improve readability //instantiate variables

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("What is your age ?");
        int userAge = Integer.parseInt(sc.nextLine());

        System.out.println("Your maximum heart rate should " +
                            "be "+ (220 - userAge) + " beats per minute. " +
                            "\nYour target HR Zone is "+ Math.ceil(0.5*(220 -userAge)) +
                            " - " + Math.ceil(0.85*(220 -userAge)) + " beats per minute");
    }

}
