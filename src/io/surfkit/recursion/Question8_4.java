package io.surfkit.recursion;


/*

 */

import java.util.ArrayList;

public class Question8_4 {

    public static ArrayList<String> getPerms(String str){
        ArrayList<String> perms = new ArrayList<>();
        if( str.length() == 0 ){
            ArrayList<String> empty = new ArrayList<>();
            empty.add("");
            return empty;  // empty string
        }else{
            char first = str.charAt(0);
            String rest = str.substring(1);
            ArrayList<String> words = getPerms(rest);
            for( String p : words ){
                for( int i=0; i<=p.length(); i++){
                    perms.add(p.substring(0, i) + first + p.substring(i));
                }
            }
            return perms;
        }
    }


    public static void printSubSets(ArrayList<String> allsubsets){
        for(String s : allsubsets){
            System.out.print("\n{");
            System.out.print(s);
            System.out.print("}");
        }
    }

    public static void printPerms(ArrayList<ArrayList<Integer>> allsubsets){
        for(ArrayList<Integer> subset : allsubsets){
            System.out.print("\n{");
            for( Integer i : subset)System.out.print(i + ",");
            System.out.print("}");
        }
    }

    public static void main(String[] args) {
        ArrayList<String> perms = getPerms("abc");
        printSubSets(perms);

       /* ArrayList<Integer> set = new ArrayList<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        ArrayList<ArrayList<Integer>> allsubsets = getIntPerms(set, 0);
        System.out.println("allsubsets: " + allsubsets.size());
        printPerms(allsubsets);*/
    }


    public static ArrayList<ArrayList<Integer>> getIntPerms(ArrayList<Integer> set, int index){
        ArrayList<ArrayList<Integer>> perms = new ArrayList<>();
        if(index == set.size() - 1){
            ArrayList<Integer> last = new ArrayList<>();
            last.add(set.get(index));
            perms.add(last);
            return perms;
        }else{
            Integer first = set.get(index);
            ArrayList<ArrayList<Integer>> sub = getIntPerms(set, index + 1);
            System.out.println("sub: " + sub.size());
            for( ArrayList<Integer> x : sub){
                for( int i=0; i<x.size(); i++){
                    ArrayList<Integer> next = new ArrayList<>();
                    for(int j=0; j<i; j++)next.add(x.get(j));
                    next.add(first);
                    for(int j=i; j<x.size(); j++)next.add(x.get(j));
                    perms.add(next);
                }
            }
        }
        return perms;
    }



    // SOLUTIONS
    /*

     */




}


