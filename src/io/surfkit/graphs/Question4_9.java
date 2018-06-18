package io.surfkit.graphs;


/*
Route Between Nodes: Given a directed graph, design an algorithm to find out whether there is a
route between two nodes
 */

import java.util.ArrayList;
import java.util.LinkedList;

public class Question4_9 {

    public static class BinTreeNode{
        public Integer data;
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

    public static ArrayList<LinkedList<Integer>> joinLeftRight(Integer pre, ArrayList<LinkedList<Integer>> left, ArrayList<LinkedList<Integer>> right){
        ArrayList<LinkedList<Integer>> join = new ArrayList<>();
        for(LinkedList<Integer> r : right) {
            if(right.isEmpty()){
                LinkedList<Integer> rcopy = (LinkedList<Integer>) r.clone();
                rcopy.addFirst(pre);
                join.add(rcopy);
            }
            for(LinkedList<Integer> l : left) {
                LinkedList<Integer> rcopy = (LinkedList<Integer>) r.clone();
                rcopy.addFirst(pre);
                rcopy.addAll((LinkedList<Integer>) l.clone());
                join.add(rcopy);
            }
        }
        for(LinkedList<Integer> l : left) {
            if(right.isEmpty()){
                LinkedList<Integer> lcopy = (LinkedList<Integer>) l.clone();
                lcopy.addFirst(pre);
                join.add(lcopy);
            }
            for(LinkedList<Integer> r : right) {
                LinkedList<Integer> lcopy = (LinkedList<Integer>) l.clone();
                lcopy.addFirst(pre);
                lcopy.addAll((LinkedList<Integer>) r.clone());
                join.add(lcopy);
            }
        }
        return join;
    }


    public static ArrayList<LinkedList<Integer>> bstSequence(BinTreeNode node){
        if(node.left == null && node.right == null){
            LinkedList<Integer> leaf = new LinkedList<Integer>();
            leaf.add(node.data);
            ArrayList<LinkedList<Integer>> ret = new ArrayList<LinkedList<Integer>>();
            ret.add(leaf);
            System.out.println("leaf: " + node.data);
            return ret;
        }
        ArrayList<LinkedList<Integer>> right = new ArrayList<>();
        ArrayList<LinkedList<Integer>> left = new ArrayList<>();
        if(node.right != null)right = bstSequence(node.right);
        if(node.left != null)left = bstSequence(node.left);

        printSeq("right",right);
        printSeq("left", left);

        return joinLeftRight(node.data, left, right);
    }


    public static void printList(LinkedList<BinTreeNode> list){
        for( BinTreeNode n : list){
            System.out.print(n.data+",");
        }
        System.out.println("");
    }

    public static void printSeq(String name, ArrayList<LinkedList<Integer>> seq){
        System.out.print("\n"+name+": ");
        for(LinkedList<Integer> s : seq) {
            for(Integer i : s){
                System.out.print(i+",");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        int[] elements = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};

        BinTreeNode root = createTree(elements);

        ArrayList<LinkedList<Integer>> seq = bstSequence(root);

        System.out.println("Sequencer: " + seq.size());

        printSeq("rarg", seq);
    }



    // SOLUTIONS
    /*

     */




}


