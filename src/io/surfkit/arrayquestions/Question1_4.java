package io.surfkit.arrayquestions;

/*
URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string
has sufficient space at the end to hold the additional characters, and that you are given the "true"
length of the string. (Note: If implementing in Java, please use a character array so that you can
perform this operation in place.)
 */

public class Question1_4 {


    public static boolean isPalPerm(String str){
        int[] buckets = new int[256];
        char[] chars = str.toLowerCase().toCharArray();
        for( int i=0; i<chars.length; i++){
            if(chars[i] != ' '){
                buckets[(int)chars[i]]++;
            }
        }
        Boolean hasAnOdd = false;
        for(int i=0; i<buckets.length; i++){
            if( buckets[i] % 2 != 0 ){
                if(hasAnOdd)return false;
                hasAnOdd = true;
            }
        }
        return true;
    }



    public static void main(String[] args) {
        // write your code here
        String test = "Tact coa";
        String test2 = "Tact coaT";
        String test3 = "Tact coaTT";

        System.out.println("* " + isPalPerm(test) );
        System.out.println("* " + isPalPerm(test2) );
        System.out.println("* " + isPalPerm(test3) );
    }



    // BOOK SOLUTION...
    // Assume string has sufficient free space at the end



}
