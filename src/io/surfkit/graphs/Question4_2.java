package io.surfkit.graphs;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
Route Between Nodes: Given a directed graph, design an algorithm to find out whether there is a
route between two nodes
 */

public class Question4_2 {

    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public  Node(int v){
            value = v;
        }
        public  Node(int v, Node l, Node r){
            value = v;
            left = l;
            right = r;
        }
    }


    public static Node createTree( int[] elements ){
        if(elements.length == 0)return null;
        if(elements.length == 1)return new Node(elements[0]);
        int half=elements.length/2;
        if( elements.length % half == 1){
            int[] left = new int[half];
            int[] right = new int[half];
            System.arraycopy(elements, 0, left, 0, left.length);
            System.arraycopy(elements, half+1, right, 0, right.length);
            return new Node(elements[half], createTree(left), createTree(right));
        }else{
            int[] left = new int[half-1];
            int[] right = new int[half];
            System.arraycopy(elements, 0, left, 0, left.length);
            System.arraycopy(elements, half, right, 0, right.length);
            return new Node(elements[half-1], createTree(left), createTree(right));
        }

    }


    public static void inOrderPrint(Node node){
        if(node.left != null)inOrderPrint(node.left);
        System.out.print(node.value+",");
        if(node.right != null)inOrderPrint(node.right);
    }


    public static void main(String[] args) {
        int[] elements = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        Node root = createTree(elements);


        inOrderPrint(root);
    }



    // SOLUTIONS
    /*

     */




}


