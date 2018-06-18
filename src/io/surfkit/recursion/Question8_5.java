package io.surfkit.recursion;


/*

 */

import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

public class Question8_5 {


    public static ArrayList<String> getPerms( String str ){
        ArrayList<String> perms = new ArrayList<>();
        if( str.isEmpty() ){
            ArrayList<String> empty = new ArrayList<>();
            empty.add("");
            return empty;  // empty string
        }else{
            char first = str.charAt(0);
            String rest = str.substring(1);
            ArrayList<String> words  = getPerms(rest);
            for( String s : words ){
                for( int i=0; i<=s.length(); i++){
                    String x = s.substring(0,i) + first + s.substring(i);
                    perms.add(x);
                }
            }
        }
        return perms;
    }

    public static boolean isBalanced( String test ){
        int score = 0;
        for( int i=0; i<test.length(); i++){
            char c = test.charAt(i);
            if( c == '(' )score++;
            else score--;
            if( score < 0 ) return false;
        }
        return score == 0;
    }


    public static Set<String> allParentheses(int num ){
        StringBuilder b = new StringBuilder();
        for(int i =0; i<num; i++){
            b.append("()");
        }
        ArrayList<String> all = getPerms(b.toString() );
        Set<String> result = all.stream().filter(s -> isBalanced(s) ).collect(Collectors.toSet());
        System.out.println("result: "+result.size());
        result.forEach(System.out::println);
        return result;
    }



    public static void main(String[] args) {
        allParentheses(3);
    }




    // SOLUTIONS
    /*

     */




}


