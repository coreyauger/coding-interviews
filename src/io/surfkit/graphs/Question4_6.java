package io.surfkit.graphs;


/*
Route Between Nodes: Given a directed graph, design an algorithm to find out whether there is a
route between two nodes
 */

import java.util.ArrayList;

public class Question4_6 {

    /*
    public static class BinTreeNode{
        public int data;
        public BinTreeNode left;
        public BinTreeNode right;
        public BinTreeNode parent;

        public BinTreeNode(int data){
            this.data = data;
        }
        public BinTreeNode(int data, BinTreeNode l, BinTreeNode r){
            this.data = data;
            this.left = l;
            this.right = r;
            if(this.left != null)this.left.parent = this;
            if(this.right != null)this.right.parent = this;
        }


    }

    public static void inorderAdd(BinTreeNode node, ArrayList<BinTreeNode> acc ){
        if(node.left != null)inorderAdd(node.left, acc);
        acc.add(node);
        if(node.right != null)inorderAdd(node.right, acc);
    }


    public static BinTreeNode find(BinTreeNode node, int val){
        if(node.data == val)return node;
        if(val > node.data)return find(node.right, val);
        else return find(node.left, val);
    }

    public static BinTreeNode successor(BinTreeNode root, int val){
        BinTreeNode found = find(root, val);
        ArrayList<BinTreeNode> acc = new ArrayList<>();
        inorderAdd(found, acc);
        for(int i=0; i<acc.size(); i++){
            if(acc.get(i) == found)return acc.get(i+1);
        }
        return null;
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
        int[] elements = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

        BinTreeNode root = createTree(elements);

        System.out.println("find: " + find(root, 5).data);
        System.out.println("find: " + successor(root, 5).data);

    }
    */


    public static class TreeNode{
        public int value;
        public TreeNode right;
        public TreeNode left;
        public TreeNode parent;
        public TreeNode(int data){
            this.value = data;
        }
        public TreeNode(int data, TreeNode l, TreeNode r){
            this.value = data;
            this.left = l;
            this.right = r;
            if(this.left != null)this.left.parent = this;
            if(this.right != null)this.right.parent = this;
        }

    }
    public static TreeNode createTree( int[] elements ){
        if(elements.length == 0)return null;
        if(elements.length == 1)return new TreeNode(elements[0]);
        int half=elements.length/2;
        if( elements.length % half == 1){
            int[] left = new int[half];
            int[] right = new int[half];
            System.arraycopy(elements, 0, left, 0, left.length);
            System.arraycopy(elements, half+1, right, 0, right.length);
            return new TreeNode(elements[half], createTree(left), createTree(right));
        }else{
            int[] left = new int[half-1];
            int[] right = new int[half];
            System.arraycopy(elements, 0, left, 0, left.length);
            System.arraycopy(elements, half, right, 0, right.length);
            return new TreeNode(elements[half-1], createTree(left), createTree(right));
        }

    }



    public static TreeNode find(TreeNode node, int value ){
        if( node.value == value ) return node;
        if( value < node.value && node.left != null )return find(node.left, value);
        else if( node.right != null )return find(node.right, value);
        return null;
    }

    public static TreeNode successor(TreeNode root, int value){
        TreeNode node = find(root, value);
        if( node.right != null ){

            TreeNode n = node.right;
            System.out.println("r: " + n.value);
            while(n.left != null)n= n.left;
            return n;
        }
        TreeNode n = node.parent;
        while( n != null && n.value < value)n = n.parent;
        return n;
    }

    public static void main(String[] args) {
        int[] elements = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

        TreeNode root = createTree(elements);

        System.out.println("find: " + find(root, 5).value);
        System.out.println("find: " + successor(root, 5).value);

    }



    // SOLUTIONS
    /*

     */




}


