package io.surfkit.graphs;


/*
Route Between Nodes: Given a directed graph, design an algorithm to find out whether there is a
route between two nodes
 */

import java.util.ArrayList;
import java.util.LinkedList;

public class Question4_3 {

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

    public static class DepthNode{
        public int depth;
        public BinTreeNode node;

        public DepthNode(BinTreeNode node, int depth){
            this.node = node;
            this.depth = depth;
        }
    }

    private static int recordDepth( BinTreeNode node,  int depth, LinkedList<DepthNode> acc ){
        acc.add( new DepthNode(node, depth) );
        int l =depth;
        int r = depth;
        if( node.left != null ){
            l = recordDepth(node.left, depth+1, acc);
        }
        if( node.right != null ){
            r = recordDepth(node.right, depth+1, acc);
        }
        return l > r ? l : r;
    }

    public static ArrayList<LinkedList<BinTreeNode>> treeToDepthLists(BinTreeNode node ){
        LinkedList<DepthNode> all = new LinkedList<>();
        int max = recordDepth(node, 0, all);
        ArrayList<LinkedList<BinTreeNode> > nodes = new ArrayList<>();
        for( int i=0; i<max+1; i++){
            nodes.add(i, new LinkedList<>() );
        }
        for( DepthNode dn : all){
            nodes.get(dn.depth).add(dn.node);
        }
        return nodes;
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


    public static void printList(LinkedList<BinTreeNode> list){
        for( BinTreeNode n : list){
            System.out.print(n.data+",");
        }
        System.out.println("");
    }


    public static void main(String[] args) {
        int[] elements = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24};

        BinTreeNode root = createTree(elements);

        ArrayList<LinkedList<BinTreeNode>> results =  treeToDepthLists(root);
        int depth = 0;
        for(LinkedList<BinTreeNode> list : results){
            System.out.println("depth: " + (depth++));
            printList(list);
        }

        int[] elements2 = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        BinTreeNode root2 = createTree(elements2);
        root2.right.right.right = new BinTreeNode(55);
        root2.right.right.right.right = new BinTreeNode(75);

        ArrayList<LinkedList<BinTreeNode>> results2 =  treeToDepthLists(root2);
        int depth2 = 0;
        for(LinkedList<BinTreeNode> list : results2){
            System.out.println("depth: " + (depth2++));
            printList(list);
        }

    }



    // SOLUTIONS
    /*

     */




}


