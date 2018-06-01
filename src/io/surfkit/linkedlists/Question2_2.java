package io.surfkit.linkedlists;

/*
Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list.
 */

public class Question2_2 {


    public static List.Node findKthLast( List list, int k){
        // produce a runner after k hops..
        List.Node runner = list.head;
        int spot = 0;
        for( List.Node i = list.head; i != null; i = i.next ){
            if( spot >= k ){
                runner = runner.next;
            }
            spot++;
        }
        return runner;
    }



    public static void main(String[] args) {
        // write your code here
        List test = new List( new int[]{1,2,2,3,4,5,6,5,4,3,9} );
        System.out.println("test");
        System.out.println(test.toString());
        System.out.println(findKthLast(test, 4).data);

    }



    // SOLUTIONS 1.B

    /* Assumes only letters a through z. */


}


