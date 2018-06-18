package io.surfkit.graphs;


/*
Route Between Nodes: Given a directed graph, design an algorithm to find out whether there is a
route between two nodes
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class Question4_7 {


    public static  class Node{
        public String data;
        public ArrayList<Node> nodes = new ArrayList<>();
        public ArrayList<Node> forward = new ArrayList<>();
        public boolean visited = false;

        public Node(String data){ this.data = data; }

        public void addDepenancy(Node node){
            node.nodes.add(this);
            forward.add(node);
        }

    }

    public static class Graph{
        public ArrayList<Node> nodes = new ArrayList<>();

        Graph(Node ...ns){ for(Node n : ns)nodes.add(n); }
        public void resetVisited(){ for(Node n : nodes)n.visited =false; }

    }


    public static void findRoots(Node node, HashSet<Node> roots, HashSet<Node> recstack){
        System.out.println("finding: " + node.data);
        node.visited = true;
        if(node.nodes.isEmpty()){
            roots.add(node);
        }else{
            for( Node child : node.nodes ){
                if(recstack.contains(child))throw new RuntimeException("Cycle yo");
                recstack.add(child);
                findRoots(child, roots, recstack);
                recstack.remove(child);
            }
        }
    }

    public static ArrayList<String> buildOrder( Graph g ){
        HashSet<Node> roots = new HashSet<>();
        g.resetVisited();
        for(Node n : g.nodes ){
            if(!n.visited)findRoots(n, roots, new HashSet<>());
        }
        // reset visited
        g.resetVisited();
        // print out in a breadth first way..
        LinkedList<Node> queue = new LinkedList<>();
        ArrayList<String> builds = new ArrayList<>();
        for(Node n : roots ){
            queue.add(n);
            while( !queue.isEmpty() ){
                Node cur = queue.poll();
                if(!cur.visited){
                    cur.visited = true;
                    builds.add(cur.data);
                    for( Node c : cur.forward)queue.add(c);
                }
            }
        }
        return builds;
    }




    public static void main(String[] args) {
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");
        Node e = new Node("e");
        Node f = new Node("f");

        //(a, d), (f, b), (b, d), (f, a), (d, c)
        a.addDepenancy(d);
        f.addDepenancy(b);
        b.addDepenancy(d);
        f.addDepenancy(a);
        d.addDepenancy(c);
        d.addDepenancy(c);

        Graph g = new Graph(a,b,c,d,e,f);

        ArrayList<String> order = buildOrder(g);
        System.out.println("Build order is: ");
        for( String s : order)System.out.print(s + ", ");
        //f, e, a, b, d, c
    }



    // SOLUTIONS
    /*

     */




}


