package io.surfkit.recursion;


/*

 */

import java.util.ArrayList;

public class QuestionGs_4 {


    public static int logestCommonSubsequence( String a, String b){
        int maxLen = 0;
        for( int i =0; i<a.length(); i++){
            char ch = a.charAt(i);
            for(int j=0; j<b.length(); j++){
                if( b.charAt(j) == ch ){
                    int len = logestCommonSubsequence(a.substring(i+1), b.substring(j+1)) + 1;
                    maxLen = Math.max(maxLen, len);
                }
            }
        }
        return maxLen;
    }



    public static void main(String[] args) {
        int len1 = logestCommonSubsequence("ABCDGH", "AEDFHR");
        System.out.println("lcs: " + len1);

        int len2 = logestCommonSubsequence("AGGTAB", "GXTXAYB");
        System.out.println("lcs: " + len2);
    }




    // SOLUTIONS
    /*

     */




}


