package io.surfkit.moderate;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.IntStream;

public class Question16_21 {


    public static boolean find( int val, int[] array, int start, int end){
        if( start == end)return false;
        int mid = start+(end-start)/2;
        System.out.println("s: " + start +  " e: " + end + " mid: " +mid);
        if( array[mid] == val ) return true;
        else if( array[mid] < val)return find(val, array, mid, end);
        else return find(val, array, start, mid);
    }

    public static int[] sumSwap( int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int sumA = IntStream.of(a).sum();
        int sumB = IntStream.of(b).sum();
        for (int x : a) {
            int diff = sumA - x;
            int toFind = (sumB + x - diff) / 2;
            if (find(toFind, b, 0, b.length)) return new int[]{x, toFind};
        }
        return new int[]{};
    }





    public static void main(String[] args) {


        int[] swap = sumSwap(new int[] {4, 1, 2, 1, 1, 2}, new int[]{3, 6, 3, 3} );

        if(swap.length > 0)
            System.out.println("swap: " + swap[0] + ", " +swap[1]);


        int[] swap2 = sumSwap(new int[] {1, 2, 3, 4, 5, 15}, new int[]{1, 2, 3, 4, 10} );

        if(swap2.length > 0)
            System.out.println("swap: " + swap2[0] + ", " +swap2[1]);
    }




    // SOLUTIONS
    /*

     */



}


