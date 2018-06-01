package io.surfkit.linkedlists;

/*
Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list.
 */

public class Question2_3 {


    public static boolean deleteMiddle( List.Node node){
        if(node == null || node.next == null)return false;
        List.Node next = node.next;
        node.data = next.data;
        node.next = next.next;
        return true;
    }



    public static void main(String[] args) {
        // write your code here
        List test = new List( new int[]{1,2,2,3,4,5,6,5,4,3,9} );
        System.out.println("test");
        System.out.println(test.toString());
        List.Node toDel = test.head.next.next.next;
        deleteMiddle(toDel);
        System.out.println(test.toString());

    }



    // SOLUTIONS 1.B

    /* Assumes only letters a through z. */


}


