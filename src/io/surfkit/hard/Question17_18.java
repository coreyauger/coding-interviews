package io.surfkit.hard;


import java.util.ArrayList;
import java.util.HashSet;

public class Question17_18 {


    public static int[] minPair( int[] a, int[] b ){
        return a[1] - a[0] < b[1] - b[0]  ? a : b;
    }

    public static int[] shortestSuper(int[] array, HashSet<Integer> left, int i, int n){
        int[] min = new int[]{ 0, Integer.MAX_VALUE };
        if( left.size() == 0 )return new int[]{i, n - 1};
        if( n == array.length ) return min;
        if( left.contains(array[n]) ){
            HashSet<Integer> set = new HashSet<>(left);
            set.remove(array[n]);
            min = minPair(shortestSuper(array, set, i,n+1), min);
        }else{
            min = minPair(shortestSuper(array, left, i, n+1), min);
        }
        return min;
    }


    public static int[] shortest( int[] array, int[] sub ){
        HashSet<Integer> subSet = new HashSet<>( );
        for( int i: sub)subSet.add(i);
        int[] min = new int[]{ 0, Integer.MAX_VALUE };
        for( int i=0; i<array.length; i++){
            if( subSet.contains(array[i]) ){
                min = minPair(shortestSuper(array, subSet, i, i), min);
            }
        }
        return min;
    }




    public static void main(String[] args) {
        int[] longer = new int[] { 7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7};
        int[] sub  = new int[] {1, 5, 9};

        int[] max = shortest(longer, sub);
        System.out.println("max time: " + max[0] + ", " + max[1]);
    }




    // SOLUTIONS
    /*

     */



}


