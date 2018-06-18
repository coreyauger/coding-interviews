package io.surfkit.recursion;


/*

 */

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Question8_6 {


    static int numWays = 0;

    public static void ways( ArrayList<Integer> used,  ArrayList<Integer> coins, int amountLeft ){
        System.out.println(amountLeft);
        if(amountLeft == 0 && !used.isEmpty()){
            numWays++;
            for(Integer i : used)System.out.print(i + ",");
            System.out.println("");
        }
        else if (amountLeft < 0 )return;
        if(coins.size() == 0) return;
        int coin = coins.get(0);
        ArrayList nextUsed = new ArrayList();
        nextUsed.addAll(used);
        ArrayList<Integer> rest = new ArrayList<>();
        for(int i=1; i<coins.size(); i++)rest.add(coins.get(i));
        for(int i=0; i * coin <= amountLeft; i++) {
            if(i > 0)nextUsed.add(coin);
            System.out.println("am["+coin+"]: " +amountLeft + "  " + (coin * i) );
            ways(nextUsed, rest, amountLeft - (coin * i) );
        }

        //ways(used, rest, amountLeft);
    }




    public static void main(String[] args) {
        ArrayList<Integer> coins = new ArrayList<>();
        coins.add(25);
        coins.add(10);
        coins.add(5);
        coins.add(1);
        ways(new ArrayList<>(), coins, 6);
        System.out.println("ways: " + numWays );
    }




    // SOLUTIONS
    /*

     */




}


