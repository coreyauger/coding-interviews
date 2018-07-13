//package io.surfkit.hackercup.ethan;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;


public class FHC_Ethan {



    public static boolean ethansCompare(String a, String b){
        /*
        Set i and j to each be equal to 1.
If i > |A|, return true.
If j > |B|, return false.
If Ai = Bj, increment i and j by 1 each, and return to Step 2.
If i = 1, increment j by 1, and return to Step 2.
Set i to be equal to 1, and return to Step 2.
         */

        // ABACUS
        //  .
        // ASUCABABACUSA
        //          .

        // XYZXZYX
        // .
        // XZYXYZXYZXZYXYZXYZYX
        //  .
        int i=0;
        int j=0;
        while(true){
            if(i >= a.length())return true;
            if(j >= b.length())return false;
            if(a.charAt(i) == b.charAt(j)){
                i++;
                j++;
            }else if(i==0){
                j++;
            }else{
                i=0;
            }
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numTests = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int n = 1; n <= numTests; n++) {
            String A = in.next();
            if(A.length() >= 3) {
                // find the largest "gap" between start letter and some repeat
                char[] Achars = A.toCharArray();
                char first = Achars[0];
                int ind=Achars.length-2;
                for(; ind >= 0; ind--){
                    if( first == Achars[ind]){
                        if( ind > 0 ) {
                            String prefix = A.substring(0, ind );
                            //System.out.println("prefix ["+ind+"]" + prefix);
                            while(prefix.length() < A.length()) prefix = prefix + prefix;
                            if (! prefix.startsWith(A) ) break;
                        }
                    }
                }
                if(ind <= 1){
                    // impossible ...
                    System.out.println("Case #" + n + ": Impossible");
                }else {
                    String prefix = A.substring(0, ind);

                    String dup = prefix + A;
                    //System.out.println(A + " -> " + dup);
                    boolean test = ethansCompare(A, dup);
                    //System.out.println(A + "  " + dup + ":" + test);
                    System.out.println("Case #" + n + ": " + dup);
                }
            }else{
                System.out.println("Case #" + n + ": Impossible");
            }
        }
    }

}
