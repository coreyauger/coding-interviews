package io.surfkit.graphs;


/*
Route Between Nodes: Given a directed graph, design an algorithm to find out whether there is a
route between two nodes
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class Question4_8 {


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

    public static BinTreeNode findNode(BinTreeNode node, BinTreeNode find){
        System.out.println("node: " + node.data + "   find: " + find.data);
        if(node == find)return node;
        if(node.left != null){
            BinTreeNode n = findNode(node.left, find);
            if(n != null)return n;
        }
        if(node.right != null){
            BinTreeNode n = findNode(node.right, find);
            if(n != null)return n;
        }
        return null;
    }

    public static BinTreeNode firstCommonAncestor(BinTreeNode node, BinTreeNode a, BinTreeNode b){
        BinTreeNode foundA = null;
        BinTreeNode foundB = null;
        if(node.right != null){
            foundA = findNode(node.right, a);
            foundB = findNode(node.right, b);
            if(foundA != null && foundB != null)return firstCommonAncestor(node.right, a, b);
            else if(foundA != null && node.left != null){
                foundB = findNode(node.left, b);
                if(foundB != null)return node;
            }else if(foundB != null && node.left != null){
                foundA = findNode(node.left, a);
                if(foundA != null)return node;
            }
        }
        if(node.left != null){
            foundA = findNode(node.left, a);
            System.out.println("node: " + node.data);
            foundB = findNode(node.left, b);
           if(foundA != null && foundB != null)return firstCommonAncestor(node.left, a, b);
            else if(foundA != null && node.right != null){
                foundB = findNode(node.right, b);
                if(foundB != null)return node;
            }else if(foundB != null && node.right != null){
                foundA = findNode(node.right, a);
                if(foundA != null)return node;
            }
        }
        return null;
    }

    public static void printTree(BinTreeNode node, int depth){
        System.out.println("Node at depth ["+depth+"] " + node.data);
        if(node.left != null)printTree(node.left, depth+1);
        if(node.right != null)printTree(node.right, depth+1);
    }


    public static BinTreeNode find(BinTreeNode node, int val){
        if(node.data == val)return node;
        else if(val < node.data)return find(node.left, val);
        else return find(node.right, val);
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
        int[] elements = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};

        BinTreeNode root = createTree(elements);

        printTree(root, 0);

        BinTreeNode one = find(root, 1);
        BinTreeNode six = find(root, 6);

        System.out.println("one: " + one.data);
        System.out.println("six: " + six.data);
        BinTreeNode common = firstCommonAncestor(root, one, six);

        System.out.println("FCA: " + common.data);


    }



    // SOLUTIONS
    /*

     */




}


