package io.surfkit.recursion;


/*

 */

import java.util.ArrayList;

public class QuestionGs_SubSum {

    //  {50, 3, 10, 7, 40, 80} = 4

    public static boolean subsetSum( int[] set, int sum, int ind ){
        if( ind == set.length ) return false;
        if( sum - set[ind] == 0 ) return true;
        else if( sum - set[ind] < 0)return false;
        return subsetSum( set, sum-set[ind], ind++ ) || subsetSum( set, sum, ind++ );
    }


   /* public static boolean subsetSum2(int[] set, int sum){
        int[][] table = new int[set.length][set.length];
        for(int i=0; i<set.length; i++){
            for(int j=0; j<set.length; j++){
                if(
            }
        }
    }*/

    /*
    Examples: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
Output:  True  //There is a subset (4, 5) with sum 9.

     */




    public static void main(String[] args) {
        System.out.println("subsetSum: " + subsetSum(new int[] {3, 34, 4, 12, 5, 2}, 9, 0 ));

    }




    // SOLUTIONS
    /*

     */




}


