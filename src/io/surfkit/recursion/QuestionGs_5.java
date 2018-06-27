package io.surfkit.recursion;


/*

 */

import java.util.Arrays;

public class QuestionGs_5 {


    public static int[][] memo;

    public static int editDistance( char[] str1, char[] str2, int ind1, int ind2 ){
        //System.out.println
        // base case
        int min = Integer.MAX_VALUE;
        if( ind1 == str1.length-1){
            if( ind2 == str2.length-1 ) return 0;
            return editDistance(str1, str2, ind1, ind2+1) + 1;
        }else if(ind2 == str2.length-1){
            return Math.min( min, editDistance(str1, str2, ind1+1, ind2) + 1);
        }
        if( memo[ind1][ ind2 ] != -1)return memo[ind1][ind2];
        char ch = str1[ind1];


        if( ch == str2[ind2] ){
            min = Math.min( min, editDistance(str1, str2, ind1+1, ind2+1) );
        }else{
            // replace char
            min = Math.min( min, editDistance(str1, str2, ind1+1, ind2+1) + 1);
            // remove
            min = Math.min( min, editDistance(str1, str2, ind1, ind2+1) + 1);
            // insert
            min = Math.min( min, editDistance(str1, str2, ind1+1, ind2) + 1);
        }
        memo[ind1][ind2] = min;
        return min;
    }

    public static int editDistance( String s1, String s2 ){
        if( s2.length() > s2.length() ){
            String tmp = s1;
            s1 = s2;
            s2 = tmp;
        }
        memo = new int[s1.length()][s2.length()];
        for(int i =0; i<memo.length;i++)for(int j=0;j<memo[i].length; j++)memo[i][j] = -1;
        return editDistance(s1.toCharArray(), s2.toCharArray(), 0, 0);
    }




    public static void main(String[] args) {
        int len1 = editDistance("geek", "gesek");
        System.out.println("ed: " + len1);

        int len2 = editDistance("sunday", "saturday");
        System.out.println("ed: " + len2);
    }




    // SOLUTIONS
    /*

     */




}


