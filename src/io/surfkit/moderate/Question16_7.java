package io.surfkit.moderate;


import java.util.*;

public class Question16_7 {



    public static int numberMax( int a, int b){
        int sig = a - b;
        int bIsGreater = (sig >> 31) & 1;
        return (b*bIsGreater) + (a* (bIsGreater ^ 1) );
    }




    public static void main(String[] args) {


        System.out.println("max of 4,5: " + numberMax(4,5));
        System.out.println("max of 5,4: " + numberMax(5,4));
        System.out.println("max of -1,2: " + numberMax(-1,2));

    }




    // SOLUTIONS
    /*

     */



}


