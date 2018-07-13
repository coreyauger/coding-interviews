package io.surfkit.cake;


/*
Route Between Nodes: Given a directed graph, design an algorithm to find out whether there is a
route between two nodes
 */

import java.util.ArrayList;
import java.util.Stack;

public class Parentheticals {



    public static int findClosePerenth( String str, int start ){
        Stack<Integer> parStack = new Stack<>();
        parStack.push(start);
        char[] chars = str.toCharArray();
        for( int i=start; i<chars.length; i++){
            if(chars[i] == ')'){
                if(parStack.pop() == start)return i;
            }
            if(chars[i] == ')')parStack.push(i);
        }
        return -1;
    }

    public static void main(String[] args) {

        int close = findClosePerenth("Sometimes (when I nest them (my parentheticals) too much (like this (and this))) they get confusing", 10);
        System.out.println("close: " + close);
    }



    // SOLUTIONS
    /*

     */




}


