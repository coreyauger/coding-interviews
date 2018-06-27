package io.surfkit.hard;


import java.util.ArrayList;
import java.util.HashSet;

public class Question17_13 {

    public static HashSet<String> dict = new HashSet<>();

    public static class Pair{
        public int unused;
        public ArrayList<String> parts = new ArrayList<>();
        public Pair( int unused){ this.unused = unused; }
    }

    public static Pair unfuck( String document, int n, int end ){
        if( n == 0 ) return new Pair(end);		// if we are at the beginning we will have “end” unused
        String word = document.substring(n-1, end);

        if( dict.contains(word) ){
            Pair p = unfuck(document, n-1, n-1);
            p.parts.add(word);
            return p;
        }else{
            Pair a = unfuck(document, n-1, end-1);
            a.unused++;
            Pair b = unfuck(document, n-1, end);
            if( a.unused < b.unused )return a;
            else return b;
        }

    }

    /*public static Pair unfuct( String doc, int n ){
        Pair[][] W = new Pair[n+1][n+1];
        for( int i=0; i<=n; i++ ){
            for(int j=0; j<i; j++){
                if( i == 0)W[i][j] = new Pair();
            }
        }
    }*/




    public static void main(String[] args) {
        //jess looked just like tim her brother
        dict.add("looked");
        dict.add("just");
        dict.add("like");
        dict.add("her");
        dict.add("brother");

        String document = "jesslookedjustlikebrothertim";
        Pair taco = unfuck(document, document.length(), document.length());

        System.out.println("rarg["+taco.unused+"]: " + taco.parts);
    }




    // SOLUTIONS
    /*

     */



}


