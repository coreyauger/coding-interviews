package io.surfkit.hard;


import java.util.*;

public class Question17_12 {


    public static class BiNode {
        public BiNode node1, node2;
        public int data;
        public BiNode(int data){ this.data = data;};
        public BiNode(int data, BiNode l, BiNode r){
            this.data = data;
            this.node1 = l;
            this.node2 = r;
        };
        public String toString(){ return "" + data;}
    }


    public static BiNode inOrderTraversal( BiNode node,  BiNode last){
        //System.out.println("node:" +node +  " last: " + last);
        if( node.node1 != null )last = inOrderTraversal( node.node1, last);
        if( last != null ){
            last.node2 = node;
           // System.out.println("last:" +last +  " -2-> node: " + node);
        }
        node.node1 = last;
        //System.out.println("node:" +node +  " -1-> last: " + last);
        last = node;
        if( node.node2 != null )last = inOrderTraversal( node.node2, last);
        return last;
    }

    public static BiNode treeToList( BiNode root ){
        BiNode last = inOrderTraversal( root, null);
        while( last.node1 != null ) last = last.node1;
        return last;
    }



    public static void main(String[] args) {
        int[] tree = new int[] { 1, 2, 3, 4, 5, 6, 7};

        BiNode root = new BiNode(4,
                new BiNode(2,
                        new BiNode(1), new BiNode(3)),
                new BiNode(6,
                        new BiNode(5), new BiNode(7)));

        BiNode head= treeToList(root);
        System.out.println("LIST:");
        while(head != null){
            System.out.print(head.data + ",");
            head = head.node2;
        }

    }




    // SOLUTIONS
    /*

     */



}


