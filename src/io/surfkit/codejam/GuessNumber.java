package io.surfkit.codejam;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class GuessNumber {


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numTests = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= numTests; ++i) {
            int min = in.nextInt();
            int max = in.nextInt();
            int numTrys = in.nextInt();
            int tryNum = 0;
            String input = "";
            while(!input.equals("CORRECT") || tryNum >= numTrys){
                tryNum++;
                int guess = ((max - min)/2) + min;
                System.out.println(guess);
                input = in.next();
                if(input.equals("TOO_BIG"))max = guess;
                else if(input.equals("TOO_SMALL"))min = guess;
            }

        }

    }

}


