package io.surfkit.arrayquestions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/*
Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you
cannot use additional data structures?
 */

public class Question1_1 {

    public static boolean allUniqueCharsHash(String str){
        Character[] charObjectArray =
                str.chars().mapToObj(c -> (char)c).toArray(Character[]::new);
        Set charsSet = new HashSet<Character>();
        Arrays.stream(charObjectArray).map( x -> charsSet.add(x) ).collect(Collectors.toSet());
        System.out.println(charsSet.size());
        System.out.println(str.length());
        if(charsSet.size() == str.length() )return true;
        return false;
    }

    public static boolean allUnique(String str){
        char[] chars = str.toCharArray();
        for(int i=0; i<chars.length; i++){
            for(int j=i+1; j<chars.length; j++){
                if(chars[i] == chars[j])return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // write your code here
        System.out.println("Rarg marg..");

        String good = "abcdef";
        String bad = "abcdd";

        System.out.println("1: " + allUniqueCharsHash(good) );
        System.out.println("1: " + allUnique(good) );

        System.out.println("1: " + allUniqueCharsHash(bad) );
        System.out.println("1: " + allUnique(bad) );
    }



    // SOLUTIONS 1.B

    /* Assumes only letters a through z. */
    public static boolean isUniqueChars(String str) {
        if (str.length() > 26) { // Only 26 characters
            return false;
        }
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) return false;
            checker |= (1 << val);
        }
        return true;
    }

}


