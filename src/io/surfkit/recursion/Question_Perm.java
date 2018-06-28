package io.surfkit.recursion;


/*

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Question_Perm {

    public static ArrayList<String> perms( char[] array, int n ){
        ArrayList<String> perms;
        if( array.length == n ){
            perms = new ArrayList<>();
            perms.add("");
            return perms;
        }
        perms = perms(array, n+1);
        char ch = array[n];
        ArrayList<String> more = new ArrayList<>();
        for( int i=0; i<perms.size(); i++){
            String p = perms.get(i);
            System.out.println("p: " + p);
            // insert ch into every position of p
            for( int j=0; j<=p.length(); j++){
                String p1 = p.substring(0, j) + ch + p.substring(j);
                System.out.println("p1: " + p1);
                more.add(p1);
            }
        }
        return more;
    }



    public static void main(String[] args) {
        ArrayList<String> perms = perms("abc".toCharArray(), 0);
        System.out.println("perms: " + perms);
    }


    // SOLUTIONS
    /*

     */


}


