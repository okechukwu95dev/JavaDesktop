package com.sg.foundations.Assignments;

public class SummativeSums {

    public static void main(String[] args) {
        int [] a = { 1, 90, -33, -55, 67, -16, 28, -55, 15 };
        int [] b = { 999, -60, -77, 14, 160, 301 };
        int [] c  = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200, -99 };
        System.out.println(addElements(a));
        System.out.println(addElements(b));
        System.out.println(addElements(c));
    }


    public static int addElements (int[] intArray){
        int count = 0;
        for (int i = 0; i < intArray.length; i++){
            count+=intArray[i];
        }
        return count;
    }
}
