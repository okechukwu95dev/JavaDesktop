
import java.util.*;
import java.io.*;
import java.math.*;




public class CodingGameFastest {
    public static void main(String args[]) {

        String minHours = "99";
        String minMins = "99";
        String minSecs = "99";


        Scanner in = new Scanner(System.in);
        System.out.println("please select somthing?");
        int N = in.nextInt();
        System.out.println((N));

        //converts our integer input to string
        for (int i = 0; i < N; i++) {
            String t = in.next();
            int index =  t.indexOf(":");
            System.out.println(index);
        }




        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println("answer");
    }





}
