package io.surfkit.graphs;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
Route Between Nodes: Given a directed graph, design an algorithm to find out whether there is a
route between two nodes
 */

public class Question4_1 {

    public static class Node<E>{
        public E data;
        public boolean visited=false;
        public ArrayList<Node<E>> nodes = new ArrayList<>();

        public Node(E data){
            this.data = data;
        }
    }

    public static class Graph{
        public ArrayList<Node> nodes = new ArrayList<>();
        public Graph(Node<?> ...nodes){
            for( Node n : nodes){
                this.nodes.add(n);
            }
        }
    }

    public static boolean hasRoute(Graph g, Node<Integer> a, Node<Integer> b){
        // use BFS
        Queue<Node> queue = new LinkedList<>();
        queue.add(a);
        queue.add(b);
        while(!queue.isEmpty()){
            Node current = queue.poll();
            if(!current.visited){
                current.visited = true;
                for(Node<Integer> n : (ArrayList<Node>)current.nodes){
                    if(n == a || n == b)return true;
                    queue.add(n);
                }
            }
        }
        return false;
    }



    public static void main(String[] args) {
        Node<Integer> a1 = new Node(1);
        Node<Integer> a2 = new Node(2);
        Node<Integer> a3 = new Node(3);
        Node<Integer> a4 = new Node(4);
        Node<Integer> a5 = new Node(5);
        Node<Integer> a6 = new Node(6);
        Node<Integer> a7 = new Node(7);

        a3.nodes.add(a4);
        a3.nodes.add(a5);
        a3.nodes.add(a6);
        a2.nodes.add(a3);
        a1.nodes.add(a2);

        Graph graph = new Graph(a1,a2,a3,a4,a5,a6,a7);

        System.out.println("Checking for route ");

        System.out.println("route: " + hasRoute(graph, a1, a6));
        System.out.println("route: " + hasRoute(graph, a1, a7));
    }



    // SOLUTIONS
    /*

     */




}


