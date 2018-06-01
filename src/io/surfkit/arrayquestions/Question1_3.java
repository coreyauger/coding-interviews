package io.surfkit.arrayquestions;

/*
URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string
has sufficient space at the end to hold the additional characters, and that you are given the "true"
length of the string. (Note: If implementing in Java, please use a character array so that you can
perform this operation in place.)
 */

public class Question1_3 {


    public static void shiftBy2(char[] str, int ind){
        for(int i=str.length-3; i>ind; i--){
            str[i+2] = str[i];
        }
        System.out.println("1: " + new String(str) );
    }

    public static char[] urlify(char[] str, int len){
        for(int i =0; i<len; i++){
            if(str[i] == ' '){
                shiftBy2(str, i);
                str[i]='%';
                str[i+1]='2';
                str[i+2]='0';
            }
        }
        return str;
    }


    public static void main(String[] args) {
        // write your code here
        String test = "Mr John Smith    ";
        String resutl = "Mr%20John%20Smith";

        System.out.println("1: " + new String(urlify(test.toCharArray(), 13)) );
    }



    // BOOK SOLUTION...
    // Assume string has sufficient free space at the end
    public static void replaceSpaces(char[] str, int trueLength) {
        int spaceCount = 0, index, i = 0;
        for (i = 0; i < trueLength; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }
        index = trueLength + spaceCount * 2;
        if (trueLength < str.length) str[trueLength] = '\0';
        for (i = trueLength - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index - 3;
            } else {
                str[index - 1] = str[i];
                index--;
            }
        }
    }

    public static int findLastCharacter(char[] str) {
        for (int i = str.length - 1; i >= 0; i--) {
            if (str[i] != ' ') {
                return i;
            }
        }
        return -1;
    }


}
