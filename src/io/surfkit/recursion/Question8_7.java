package io.surfkit.recursion;


/*

 */

import java.util.ArrayList;

public class Question8_7 {


    static int numWays = 0;

    public static ArrayList<String> perms(String str, int index){
        System.out.println(str);
        if(str.length() == 0){
            ArrayList<String> empty = new ArrayList<>();
            empty.add("");
            return empty;
        }
        Character ch = str.charAt(0);
        String rest = str.substring(1);

        ArrayList<String> ps = perms(rest, index+1);
        ArrayList<String> ret = new ArrayList<>();
        for( String s : ps){
            // insert char into every position
            for( int i=0; i<=s.length(); i++){
                String pre = s.substring(0, i);
                String post = s.substring(i);
                ret.add(pre + ch + post);
            }
        }
        return ret;
    }


    public static void print(ArrayList<String> ps){
        for( String s : ps){
            System.out.println("{"+s+"}");
        }
    }


    public static void main(String[] args) {
        ArrayList<String> ps = perms("abcd", 0);
        print(ps);
    }




    // SOLUTIONS
    /*

     */




}


