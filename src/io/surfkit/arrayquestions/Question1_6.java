package io.surfkit.arrayquestions;

/*
URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string
has sufficient space at the end to hold the additional characters, and that you are given the "true"
length of the string. (Note: If implementing in Java, please use a character array so that you can
perform this operation in place.)
 */

public class Question1_6 {



    public static String compressString( String str ){
        char[] chars = str.toCharArray();
        char[] compress = new char[chars.length];
        int ind = 0;
        for (int i=0; i<chars.length; i++){
            char compare = chars[i];
            int count = 0;
            while(i+count < chars.length && chars[i+count] == compare)count++;
            if(ind + 2 >= chars.length )return str;
            compress[ind++] = compare;
            compress[ind++] = Character.forDigit(count, 10);
            i += count-1;
        }
        compress[ind] = '\0';
        return new String(compress).trim();
    }



    public static void main(String[] args) {
        // write your code here
        String test = "aabcccccaaa";

        String test2 = "abcdefg";
        String test3 = "aaaaaaaaabcdefaa";

        System.out.println("* " + compressString(test) );
        System.out.println("* " + compressString(test2) );
        System.out.println("* " + compressString(test3) );

    }



    // BOOK SOLUTION...
    //


}
