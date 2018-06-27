package io.surfkit.sort;


/*

 */

import java.util.ArrayList;
import java.util.Arrays;

public class Question10_2 {

    public static class AnagramGroup implements Comparable<AnagramGroup>{
        public String original;
        public String sorted;
        AnagramGroup( String str){
            original = str;
            char[] xs = str.replaceAll("\\s+","").toCharArray();
            Arrays.sort(xs);
            sorted = new String(xs);
        }
        public int compareTo(AnagramGroup other){

            int ret = 0;
            if(sorted.length() < other.sorted.length())ret =  -1;
            else if(sorted.length() > other.sorted.length())ret = 1;
            else ret = this.sorted.compareTo(other.sorted);
            return ret;
        }
        public String toString(){
            return "Str: " + original + " sorted: " + sorted;
        }
    }

    public static ArrayList<String> group( String[] arr){
        AnagramGroup[] aa = new AnagramGroup[arr.length];
        for( int i =0; i<arr.length; i++)aa[i] = new AnagramGroup(arr[i]);
        Arrays.sort(aa);
        ArrayList<String> ret = new ArrayList<>();
        for( int i =0; i< aa.length; i++)ret.add( aa[i].original );
        return ret;
    }


    public static void main(String[] args) {
        ArrayList<String> ss = group(new String[]{
                "restful",
                "test",
                "fluster",
                "fart",
                "adultery",
                "ass",
                "true lady",
                "customers",
                "dog shit",
                "store scum"
        });
        System.out.println("Sorted...");
        for( String s : ss)System.out.print(s + ",");
    }



    // SOLUTIONS
    /*
    restful" = "fluster"
"funeral" = "real fun"
"adultery" = "true lady"
"customers" = "store scum"
"forty five" = "over fifty"

     */




}


