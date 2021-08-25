package com.sg.foundations.flowcontrol.methods;

import java.util.Random;

public class BarelyControlledChaos {

    public static void main(String[] args) {

        String[] animals  = {"Pig", "Dog", "Bat", "Cat", "Rat","woah"}; //Array of colors
        String[] colors = {"Red", "Green", "Blue", "Black", "Grey"}; //Array of animals
//
//
        String  color = returnRandom(colors); // call color methodd again here
        String colorAgain = returnRandom(colors); // call color method again here
//        ??? weight = ???; // call number method,
//        // with a range between 5 - 200
//        ??? distance = ???; // call number method,
//        // with a range between 10 - 20
//        ??? number = ???; // call number method,
//        // with a range between 10000 - 20000
//        ??? time = ???; // call number method,
        // with a range between 2 - 6

//        String color = returnRandom(colors);

        System.out.print(color);
        System.out.print("\n");
        System.out.print(colorAgain);
//
//        System.out.println("Once, when I was very small...");
//
//        System.out.println("I was chased by a " + color + ", "
//                + weight + "lb " + " miniature " + animal
//                + " for over " + distance + " miles!!");
//
//        System.out.println("I had to hide in a field of over "
//                + number + " " + colorAgain + " poppies for nearly "
//                + time + " hours until it left me alone!");
//
//        System.out.println("\nIt was QUITE the experience, "
//                + "let me tell you!");
    }

    // ??? Method 1 ???
    public static String returnRandom(String[] strArray){
         Random randomPicker = new Random();
         int index = randomPicker.nextInt(strArray.length);
         return strArray[index];
    }
    // ??? Method 2 ???
    // ??? Method 3 ???

}
