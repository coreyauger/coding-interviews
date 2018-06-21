package io.surfkit.hard;


import java.util.*;

public class Question17_9 {


    public static ArrayList<ArrayList<Integer>> powerSet(ArrayList<Integer> set, int index){
        ArrayList<ArrayList<Integer>> all = new ArrayList<>();
        if(set.size() == index){
            all.add(new ArrayList<Integer>() );	// empty set..
            return all;
        }

        ArrayList<ArrayList<Integer>> more = new ArrayList<>();
        all = powerSet(set, index+1);
        Integer item = set.get(index);
        for( ArrayList<Integer> s : all ){
            ArrayList<Integer> copy = new ArrayList<>();
            copy.addAll(s);
            copy.add(item);
            more.add(copy);
        }
        all.addAll(more);
        return all;
    }

    public static List<Integer> kthMultiple( int k ){
        ArrayList<Integer> search = new ArrayList<>();
        ArrayList<Integer> set = new ArrayList<>();
        for( int i=0; i<k; i++){
            if( i % 2 == 0)set.add(3);
            if( i % 4 == 0)set.add(5);
            if( i % 5 == 0)set.add(7);
        }
        ArrayList<ArrayList<Integer>> pow = powerSet(set, 0);
        ArrayList<Integer> one = new ArrayList<>();
        one.add(1);
        pow.add( one );
        for( ArrayList<Integer> s : pow ){
            int mul = 1;
            for(int i=0; i<s.size(); i++)mul *= s.get(i);
            search.add(mul);
        }
        Set<Integer> hashSet = new HashSet<>(search);
        search = new ArrayList<>();
        for( Integer i : hashSet)search.add(i);
        Collections.sort(search);

        for(Integer i : search)System.out.print(i +", ");
        return search.subList(0, k);
    }




    public static void main(String[] args) {
        List<Integer> multiples = kthMultiple(15);

        System.out.println("MULTIPLES");
        for(Integer i : multiples)System.out.print(i +", ");

    }




    // SOLUTIONS
    /*

     */



}


