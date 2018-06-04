package io.surfkit.linkedlists;

/*
Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list.
 */

public class Question2_5 {

    public static String num(List.Node n, boolean pre){
        if(n.next == null)return ""+n.data;
        else if(pre) return ""+n.data + num(n.next, pre);
        else return num(n.next, pre) + ""+n.data;
    }

    public static List sumForward(List.Node a, List.Node b){
        String aNum = num(a, true);
        String bNum = num(b, true);
        String sum = "" + (Integer.parseInt(aNum) + Integer.parseInt(bNum));
        int [] ret = new int[sum.length()];
        for(int i=0; i<sum.length(); i++)ret[i] = sum.charAt(i) - '0';
        return new List(ret);
    }


    public static List sumBackward(List.Node a, List.Node b){
        String aNum = num(a, false);
        String bNum = num(b, false);
        String sum = "" + (Integer.parseInt(aNum) + Integer.parseInt(bNum));
        int [] ret = new int[sum.length()];
        for(int i=0; i<sum.length(); i++)ret[i] = sum.charAt(i) - '0';
        return new List(ret);
    }


    public static void main(String[] args) {
        // write your code here
        List a = new List( new int[]{7, 1, 6} );
        List b = new List( new int[]{5, 9, 2} );
        System.out.println("sum: " + sumBackward(a.head, b.head));

        List a2 = new List( new int[]{6, 1, 7} );
        List b2 = new List( new int[]{2, 9, 5} );
        System.out.println("sum: " + sumForward(a2.head, b2.head));

    }



}


