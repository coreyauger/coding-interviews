package io.surfkit.hard;


import java.util.*;

public class Question17_1 {


    static int add( int a, int b){
        if( b == 0)return a;
        int sum = a ^ b;
        int carry = (a & b) << 1;
        return add( sum, carry);
    }





/*
 John (15), Jon (12), Chris (13), Kris (4), Christopher (19) Synonyms: (Jon, John), (John, Johnny), (Chris, Kris), (Chris, Christopher)
 */

    public static void main(String[] args) {
        int a = add(3, 3);
        System.out.println("3+3="+a);

        //int b = add(1, 3);
        //System.out.println("1+3="+b);
    }




    // SOLUTIONS
    /*

     */



}


