package io.surfkit.recursion;


/*

 */

import java.util.ArrayList;
import java.util.Stack;

public class Question8_11 {


    public static enum Denomination{
        Start(0), Quarter(25), Dime(10), Nickel(5), Penny(1);
        public int value;
        Denomination(int value){ this.value = value; }
    }

    public static int makeChange( Denomination d, int cents ){
        // get the next denom
        if(d == Denomination.Start)d = Denomination.Quarter;
        else if(d == Denomination.Quarter)d = Denomination.Dime;
        else if(d == Denomination.Dime)d = Denomination.Nickel;
        //else if(d == Denomination.Nickel)d = Denomination.Penny;
        else if(d == Denomination.Nickel){
            return 1;
        }
        int numWays = 0;
        for(int i=0; i*d.value <= cents; i++){
            numWays += makeChange( d, cents - (i*d.value) );
        }
        return numWays;
    }



    public static void print(ArrayList<String> ps){
        for( String s : ps){
            System.out.println("{"+s+"}");
        }
    }


    public static void main(String[] args) {
        int ways = makeChange(Denomination.Start, 500);
        System.out.println("There are: " + ways);

        int ways2 = makeChange2(500, new int[]{25, 10, 5, 1});
        System.out.println("There are: " + ways);
    }




    // SOLUTIONS
    /*

     */


    public static int makeChange2(int amount, int[] denoms, int index) {
        if (index >= denoms.length - 1) return 1; // one denom remaining -> one way to do it
        int denomAmount = denoms[index];
        int ways = 0;
        for (int i = 0; i * denomAmount <= amount; i++) {
            int amountRemaining = amount - i * denomAmount;
            ways += makeChange2(amountRemaining, denoms, index + 1); // go to next denom
        }
        return ways;
    }

    public static int makeChange2(int amount, int[] denoms) {
        return makeChange2(amount, denoms, 0);
    }

}


