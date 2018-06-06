package io.surfkit.linkedlists;

/*
Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list.
 */

import java.util.ArrayList;

public class Question2_7 {



    public static void print(CharList.Node a){
        for(CharList.Node i=a; i!=null; i=i.next)System.out.print(i.data);
    }

    // O(n^2)
    public static CharList.Node intersection(CharList a, CharList b){
        for(CharList.Node i=a.head; i != null; i = i.next){
            for(CharList.Node j=b.head; j != null; j=j.next){
                if( i == j )return i;
            }
        }
        return null;
    }

    // copy to array an just compare the arrays to get faster..


    public static void main(String[] args) {
        // write your code here
        CharList a = new CharList( new char[]{'a', 'b', 'c', 'd'} );
        CharList b = new CharList( new char[]{'x', 'y', 'z'} );
        b.head.next.next.next = a.head.next.next.next;


        CharList.Node x = intersection(a, b);
        System.out.println("intersect?");
        if(x != null) print(x);
        else System.out.println("Non intersect..");

    }



    /*  BOOK Solution A





     */

}


