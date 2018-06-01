package io.surfkit.linkedlists;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/*
Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you
cannot use additional data structures?
 */

public class Question2_1 {


    public static List removeDups(List list ){
        for(List.Node n = list.head; n != null; n = n.next ){
            for(List.Node k = n; k.next != null; k = k.next ){
                if( k.next.data == n.data ){
                    k.next = k.next.next;
                }
            }
        }
        return list;
    }


    public static void main(String[] args) {
        // write your code here
        List test = new List( new int[]{1,2,2,3,4,5,6,5,4,3,9} );

        System.out.println("test");
        System.out.println(test.toString());
        System.out.println(removeDups(test).toString());

    }



    // SOLUTIONS 1.B

    /* Assumes only letters a through z. */


}


