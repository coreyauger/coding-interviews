package io.surfkit.recursion;


/*

 */

import java.util.ArrayList;
import java.util.LinkedList;

public class Question8_3 {

    public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index){
        ArrayList<ArrayList<Integer>> allsubsets;
        if(set.size() == index){
            allsubsets = new ArrayList<>();
            allsubsets.add(new ArrayList<>()); // empty set
        }else{
            allsubsets = getSubsets(set, index + 1);
            int item = set.get(index);
            ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
            for( ArrayList<Integer> subset : allsubsets ){
                ArrayList<Integer> copy = new ArrayList<>();
                copy.addAll(subset);
                copy.add(item);
                subsets.add(copy);
            }
            allsubsets.addAll(subsets);
        }
        return allsubsets;
    }

    public static void printSubSets(ArrayList<ArrayList<Integer>> allsubsets){
        for(ArrayList<Integer> subset : allsubsets){
            System.out.print("\n{");
            for( Integer i : subset)System.out.print(i + ",");
            System.out.print("}");
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> set = new ArrayList<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        ArrayList<ArrayList<Integer>> allsubsets = getSubsets(set, 0);
        printSubSets(allsubsets);
    }



    // SOLUTIONS
    /*

     */




}


