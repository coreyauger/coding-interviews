package io.surfkit.linkedlists;

/*
Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list.
 */

import java.util.HashSet;

public class Question2_8 {



    public static void print(CharList.Node a){
        for(CharList.Node i=a; i!=null; i=i.next)System.out.print(i.data);
    }

    public static CharList.Node loopDetection(CharList.Node node){
        HashSet<CharList.Node> visited = new HashSet<>();
        for(CharList.Node i = node; i != null; i = i.next){
            if(visited.contains(i))return i;
            visited.add(i);
        }
        return null;
    }



    public static void main(String[] args) {
        // write your code here
        CharList a = new CharList( new char[]{'a', 'b', 'c', 'd', 'e'} );

        CharList.Node c = a.head.next.next;
        CharList.Node e = a.head.next.next.next.next;
        e.next = c;

        CharList.Node node = loopDetection(a.head);


        System.out.println("loopDetection?");
        System.out.println(node.data);

    }



    /*  BOOK Solution A





     */

}


