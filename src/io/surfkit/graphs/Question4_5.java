package io.surfkit.graphs;


/*
Route Between Nodes: Given a directed graph, design an algorithm to find out whether there is a
route between two nodes
 */

import java.util.ArrayList;

public class Question4_5 {

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

    public static void inorderAdd(BinTreeNode node, ArrayList<Integer> acc ){
        if(node.left != null)inorderAdd(node.left, acc);
        acc.add(node.data);
        if(node.right != null)inorderAdd(node.right, acc);
    }


    public static boolean validBst(BinTreeNode root ){
        ArrayList<Integer> acc = new ArrayList<>();
        inorderAdd(root, acc);
        print(acc);
        return isSorted(acc);
    }

    public static boolean isSorted(ArrayList<Integer> list)
    {
        boolean sorted = true;
        for (int i = 1; i < list.size(); i++) {
            if ( list.get(i-1) > list.get(i) ) sorted = false;
        }
        return sorted;
    }

    public static void print(ArrayList<Integer> acc){
        for(int x : acc){
            System.out.println(x + ", ");
        }
        System.out.println("");
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

        System.out.println("validBst: " + validBst(root));

        int[] elements2 = new int[]{1, 2, 3, 9, 5, 6, 7, 8};

        BinTreeNode root2 = createTree(elements2);

        System.out.println("validBst2: " + validBst(root2));
    }



    // SOLUTIONS
    /*

     */




}


