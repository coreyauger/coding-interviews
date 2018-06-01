package io.surfkit.arrayquestions;

import java.util.Arrays;

/*
Check Permutation: Given two strings, write a method to decide if one is a permutation of the other
 */

public class Question1_2 {

    public static boolean isPermutation(String a, String b){
        if( a == null || b == null )return false;
        if( a.length() != b.length() ) return false;
        // sort them
        Arrays.sort(a.toCharArray());
        Arrays.sort(b.toCharArray());
        String sortedA = new String(a);
        String sortedB = new String(b);
        return sortedA.equals(sortedB );
    }


    public static void main(String[] args) {
        // write your code here
        System.out.println("Rarg marg..");

        String good = "abcdef";
        String bad = "abcdd";

        System.out.println("1: " + isPermutation(good, good ) );
        System.out.println("1: " + isPermutation(good, bad) );
    }


    // SOLUTION FROM BOOK..
    public static String sort(String s) {
        char[] content = s.toCharArray();
        java.util.Arrays.sort(content);
        return new String(content);
    }

    public static boolean permutation(String s, String t) {
        return sort(s).equals(sort(t));
    }


}
