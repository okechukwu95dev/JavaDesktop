
import java.io.*;
import java.math.*;
import java.security.*;
import java.sql.Array;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


public class Solution {
    public static void main(String[] args)  {


        Integer[] arr = {0,0};
        Integer[] arr2 = { 2, 6, 4, 2, 3, 3, 1, 7 };
        int[][] arr3 = { {2, 6}, {2,6},{3,6}};
        List<int[]> myList = new ArrayList<int[]>();
        myList =  { [2, 6], [2,6],[3,6]};

        List<List<Integer>> multiDimensional = new ArrayList<List<Integer>>();
        List<Integer> row = Arrays.asList(new int[]{{0);
        multiDimensional.add(row);

        List<Integer[]> arrlist = new ArrayList<Integer[]>();
//        arrlist.add(x);


        // Convert the Arraylist to array
//        arr2 = arrlist.toArray(arr);


        int[] arr2 = {9,2,10,1,5,3,3};
        int k = 12;
        Set<Integer> set = new HashSet();
        int count = 0;
        for (int i : arr){
            set.add(i);
        }

        for (int j : set){
            System.out.println("j is : "+j);
            System.out.println("k is : "+k);
            if (set.contains(k-j)){
                arr[0]= j;
                arr[1]=k-j;
                arrlist.add(arr);
                System.out.println();
                System.out.println("j is : "+j);
                System.out.println("k is : "+k);
//                new1.

                count++;
            }
        }
        System.out.println("fina count is: "+  count);

    }
        }


