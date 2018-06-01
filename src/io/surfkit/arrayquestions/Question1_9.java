package io.surfkit.arrayquestions;

/*
String Rotation:Assumeyou have a method isSubstringwhich checks if one word is a substring
of another. Given two strings, sl and s2, write code to check if s2 is a rotation of sl using only one
call to isSubstring (e.g., "waterbottle" is a rotation of"erbottlewat")
 */

public class Question1_9 {


    public static boolean isStringRotation( String s1, String s2 ){
        if(s1 == null || s2 == null) throw new IllegalArgumentException("string can not be null");
        if(s1.length() != s2.length())return false;
        if(s1.equals(s2))return true;
        for(int i=0; i<s2.length(); i++ ){
            char ch = s2.charAt(i);
            if(s1.charAt(i) != ch){
                for(int j=i; j<s1.length(); j++){
                    if(s1.charAt(j) == ch){
                        String pre = s1.substring(0, i);
                        String post = s1.substring(i);
                        if( (post+pre).equals(s2) ) return true;
                    }
                }

            }
        }
        return false;
    }


    public static void main(String[] args) {
        String s1 = "waterbottle";
        String s2 = "erbottlewat";

        System.out.println("*: " + isStringRotation(s1, s2));

        String s3 = "waterbottle";
        String s4 = "erbottlewar";

        System.out.println("*: " + isStringRotation(s3, s4));

        String s5 = "meatballz";
        String s6 = "ballzmeat";

        System.out.println("*: " + isStringRotation(s5, s6));

        String[][] pairs = {{"apple", "pleap"}, {"waterbottle", "erbottlewat"}, {"camera", "macera"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean is_rotation = isStringRotation(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + is_rotation);

        }
    }


    // BOOK SOLUTION...
    //



}
