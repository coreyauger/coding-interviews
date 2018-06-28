package io.surfkit.moderate;


import java.util.Arrays;
import java.util.stream.IntStream;

public class Question16_22 {


    public static void printKMoves( int k ){
        int size = k/2 +1;
        for( int r = 0; r<size; r++){
            for(int c=0; c<size; c++){
                if( c == r )System.out.print("X");
                else if( r-1 == c)System.out.print("O");
                else if( r % 2 == 1 ){
                    if( c % 2 == 0)System.out.print("X");
                    else System.out.print("O");
                }else{
                    if( c % 2 == 0)System.out.print("O");
                    else System.out.print("X");
                }

            }
            System.out.println("");
        }
    }






    public static void main(String[] args) {
        printKMoves( 10 );
    }




    // SOLUTIONS
    /*

     */



}


