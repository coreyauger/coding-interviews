package io.surfkit.arrayquestions;

/*
URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string
has sufficient space at the end to hold the additional characters, and that you are given the "true"
length of the string. (Note: If implementing in Java, please use a character array so that you can
perform this operation in place.)
 */

public class Question1_5 {


    public static boolean isOneAway(String a, String b){
        if(a.equals(b))return true;
        if( a.length() < b.length() ){
            String temp = a;
            a = b;
            b = temp;
        }
        if( a.length() - b.length() > 1 )return false;
        for(int i=0; i<b.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                if(a.substring(i+2).equals(b.substring(i+1)))
                    return true;
                else if(a.substring(i+1).equals(b.substring(i+1)))
                    return true;
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {
        // write your code here
        String[] test1 = {"pale", "ple"};
        String[] test2 = {"pales", "pale"};
        String[] test3 = {"pale", "bale"};
        String[] test4 = {"pale", "bake"};

        System.out.println("* " + isOneAway(test1[0], test1[1]) );
        System.out.println("* " + isOneAway(test2[0], test2[1]) );
        System.out.println("* " + isOneAway(test3[0], test3[1]) );
        System.out.println("* " + isOneAway(test4[0], test4[1]) );
    }



    // BOOK SOLUTION...
    //



    public static boolean oneEditAway(String first, String second) {
        /* Length checks. */
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }

        /* Get shorter and longer string.*/
        String s1 = first.length() < second.length() ? first : second;
        String s2 = first.length() < second.length() ? second : first;

        int index1 = 0;
        int index2 = 0;
        boolean foundDifference = false;
        while (index2 < s2.length() && index1 < s1.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                /* Ensure that this is the first difference found.*/
                if (foundDifference) return false;
                foundDifference = true;
                if (s1.length() == s2.length()) { // On replace, move shorter pointer
                    index1++;
                }
            } else {
                index1++; // If matching, move shorter pointer
            }
            index2++; // Always move pointer for longer string
        }
        return true;
    }

}
