package io.surfkit.recursion;


/*

 */

import java.util.ArrayList;

public class QuestionGs_Par {

    public static Partition[] memo;


    public static class Partition{
        public ArrayList<Integer> a = new ArrayList();
        public ArrayList<Integer> b = new ArrayList();

        Partition( int ...nums ){
            for( int i=0; i<nums.length; i++)insert(nums[i]);
        }
        private int sum(ArrayList<Integer> x){
            int sum = 0;
            for( Integer i: x)sum+=i;
            return sum;
        }
        public int diff(){
            return Math.abs( sum(a)-sum(b) );
        }
        public void insert(int item){
            if( sum(a) < sum(b) )a.add(item);
            else b.add(item);
        }
        public static Partition min( Partition part1, Partition part2){
            int diff1 = part1.diff();
            int diff2 = part2.diff();
            return diff1 > diff2 ? part2 : part1;
        }
        public String toString(){
            StringBuilder sb = new StringBuilder();
            sb.append("\nPart A: ");
            for( Integer i : a)sb.append(i + ", ");
            sb.append("\nPart B: ");
            for( Integer i : b)sb.append(i + ", ");
            sb.append("\n");
            return sb.toString();
        }
        public static Partition MAX(){ return new Partition(0, Integer.MAX_VALUE); }
    }
    public static Partition minSumSubsets( int[] set, int index ){
        if( set.length-1 == index ){
            return new Partition( set[index] );
        }
        Partition min = Partition.MAX();

        int item = set[index];
        for( int i=index; i<set.length; i++){
            Partition p = minSumSubsets(set, index+1);
            p.insert(item);
            min = Partition.min(min, p);
        }
        return min;
    }

    public static Partition minSumSubsets( int[] set ){
        memo = new Partition[set.length];
        return minSumSubsets(set, 0);
    }




    public static void main(String[] args) {
        Partition p = minSumSubsets(new int[]{1, 6, 11, 5});
        System.out.println("PARTS: " + p);

    }




    // SOLUTIONS
    /*

     */




}


