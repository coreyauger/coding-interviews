//package io.surfkit.hackercup.interception;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class FHC_Interception {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numTests = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int n = 1; n <= numTests; n++) {
            int degree = in.nextInt();
            for(int i=0; i<degree+1; i++) {
                in.nextInt();
            }
            if( (degree + 1) % 2 == 0 )
                System.out.println("Case #" + n + ": 1\n0.0" );
            else
                System.out.println("Case #" + n + ": 0" );
        }
    }

}
