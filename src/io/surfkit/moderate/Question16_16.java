package io.surfkit.moderate;


import java.util.HashSet;

public class Question16_16 {



    public static int[] subSort( int[] array, int m, int n ){
        if( m == n)return new int[]{ 0, array.length };
        if( array[m+1] > array[m] ){
            if( array[ n-1 ] < array[n] ){
                if( array[m+1] < array[n-1]) return subSort(array, m+1, n-1);
            }else if( array[m+1] < array[n] )return subSort(array, m+1, n);
        }else if( array[ n-1 ] < array[n] ){
            if( array[m] < array[n-1] )return subSort(array, m, n-1);
        }
        return new int[]{ m+1, n-1 };
    }






    public static void main(String[] args) {

        int[] array = new int[] {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};

        int[] pair = subSort(array, 0, array.length -1);
        System.out.println("points: " + pair[0] + ", " + pair[1]);
    }




    // SOLUTIONS
    /*

     */



}


