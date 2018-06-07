package io.surfkit.graphs;


/*
Route Between Nodes: Given a directed graph, design an algorithm to find out whether there is a
route between two nodes
 */

import java.util.ArrayList;
import java.util.LinkedList;

public class Question4_4 {

    public static class BinTreeNode{
        public int data;
        public BinTreeNode left;
        public BinTreeNode right;

        public BinTreeNode(int data){
            this.data = data;
        }
        public BinTreeNode(int data, BinTreeNode l, BinTreeNode r){
            this.data = data;
            this.left = l;
            this.right = r;
        }


    }

    public static boolean checkStop(BinTreeNode node){
        if(node.right != null || node.left != null)return false;
        return true;
    }

    public static boolean isBalanced( BinTreeNode root){
        if(root.left != null && root.right != null){
            return isBalanced(root.left) && isBalanced(root.right);
        }
        else if(root.left != null){
            return checkStop(root.left);
        }else if(root.right != null) return checkStop(root.right);
        return true;
    }


    public static BinTreeNode createTree( int[] elements ){
        if(elements.length == 0)return null;
        if(elements.length == 1)return new BinTreeNode(elements[0]);
        int half=elements.length/2;
        if( elements.length % half == 1){
            int[] left = new int[half];
            int[] right = new int[half];
            System.arraycopy(elements, 0, left, 0, left.length);
            System.arraycopy(elements, half+1, right, 0, right.length);
            return new BinTreeNode(elements[half], createTree(left), createTree(right));
        }else{
            int[] left = new int[half-1];
            int[] right = new int[half];
            System.arraycopy(elements, 0, left, 0, left.length);
            System.arraycopy(elements, half, right, 0, right.length);
            return new BinTreeNode(elements[half-1], createTree(left), createTree(right));
        }

    }



    public static void main(String[] args) {
        int[] elements = new int[]{1, 2, 3, 4, 5, 6, 7, 8};

        BinTreeNode root = createTree(elements);

        boolean balanced = isBalanced(root);
        System.out.println("balanced: " + balanced);

        root.right.right.right = new BinTreeNode(55);
        root.right.right.right.right = new BinTreeNode(75);

        boolean balanced2 = isBalanced(root);
        System.out.println("balanced2: " + balanced2);
    }



    // SOLUTIONS
    /*

     */




}


