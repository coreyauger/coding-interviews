package io.surfkit.recursion;


/*

 */

import java.util.ArrayList;

public class QuestionGs_Inc {

    //  {50, 3, 10, 7, 40, 80} = 4

    public static ArrayList<Integer> lis(int[] set, int ind, int elm){
        if( set.length == ind )return new ArrayList<>();
        ArrayList<Integer> a = lis(set, ind+1, elm);
        if( set[ind] >= elm ){
            ArrayList<Integer> b = lis(set, ind+1, set[ind]);
            b.add(set[ind]);
            if( b.size() > a.size() )return b;
        }
        return a;
    }





    public static void main(String[] args) {
        ArrayList<Integer> len1 = lis(new int[]{10, 22, 9, 33, 21, 50, 41, 60, 80}, 0, Integer.MIN_VALUE);
        System.out.println("LIS");
        for( Integer i : len1)System.out.print(i + ",");

        ArrayList<Integer> len2 = lis(new int[]{10, 9, 8, 7, 6, 5}, 0, Integer.MIN_VALUE);
        System.out.println("LIS");
        for( Integer i : len2)System.out.print(i + ",");

        ArrayList<Integer> len3 = lis(new int[]{10, 9, 8, 1, 2, 3, 7, 6, 5}, 0, Integer.MIN_VALUE);
        System.out.println("LIS");
        for( Integer i : len3)System.out.print(i + ",");

    }




    // SOLUTIONS
    /*

     */




}


