package io.surfkit.kickstart;


/*
Route Between Nodes: Given a directed graph, design an algorithm to find out whether there is a
route between two nodes
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class PlanetDistance {

    public static class CycleDetector{
        private LinkedList<GraphNode> order = new LinkedList<>();
        private HashSet<GraphNode> recStack = new HashSet<>();

        public void add(GraphNode node){
            order.add(node);
            recStack.add(node);
        }
        public boolean contains(GraphNode node){
            return recStack.contains(node);
        }
        public void remove(GraphNode node){
            order.remove(node);
            recStack.remove(node);
        }
        public HashSet<GraphNode> cycle(GraphNode node){
            return new HashSet<>( order.subList(order.indexOf(node), order.size()) );
        }
    }

    public static class GraphNode{
        public int val;
        public ArrayList<GraphNode> adj = new ArrayList<>();

        public GraphNode(int value){
            val = value;
        }

        public void addAdjacent(GraphNode node){
            node.adj.add(this);
            adj.add(node);
        }

        public static HashSet<GraphNode> detectCycle(GraphNode parent, GraphNode node, HashSet<GraphNode> visited, CycleDetector recStack ){
            //System.out.println("node: " + node);
            if(recStack.contains(node))return recStack.cycle(node);
            if(visited.contains(node))return null;

            visited.add(node);
            recStack.add(node);
            for(GraphNode n : node.adj ){
                if( n == parent)continue;     // skip the direction coming back to parent..
                HashSet<GraphNode> cycle = GraphNode.detectCycle(node, n, visited, recStack);
                if(cycle != null)return cycle;
            }

            recStack.remove(node);
            return null;
        }
        public String toString() {
            return "("+val+")";
        }


        public static int bfsSteps(GraphNode node, HashSet<GraphNode> cycle){
            HashSet<GraphNode> visited = new HashSet<>();
            HashMap<GraphNode, Integer> stepMap = new HashMap<>();

            LinkedList<GraphNode> queue = new LinkedList<>();
            stepMap.put(node, 0);
            queue.push(node);
            while(queue.size() > 0){
                GraphNode n = queue.poll();
                visited.add(n);
                if(cycle.contains(n))return stepMap.getOrDefault(n, 0);
                for( GraphNode c : n.adj){
                    if(!visited.contains(c)){
                        stepMap.put(c, stepMap.get(n) + 1);
                        queue.push(c);
                    }
                }
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numTests = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= numTests; ++i) {
            int numNodes = in.nextInt();
            GraphNode[] nodes = new GraphNode[numNodes];
            for(int j=1; j<=numNodes; j++ )nodes[j-1] = new GraphNode(j);
            for(int j=1; j<=numNodes; j++ ){
                int a = in.nextInt();
                int b = in.nextInt();
                //System.out.println("vert: " + a + ", " + b);
                nodes[a-1].addAdjacent(nodes[b-1]);
            }
            GraphNode nn = nodes[0];
            HashSet<GraphNode> cycle = GraphNode.detectCycle(nn, nn, new HashSet<>(), new CycleDetector());
            ArrayList<Integer> steps = new ArrayList<>();
            for(int j=1; j<=numNodes; j++ ){
                steps.add(GraphNode.bfsSteps(nodes[j-1], cycle));
            }
            String listString = steps.stream().map(Object::toString).collect(Collectors.joining(" "));
            System.out.println("Case #" + i + ": " + listString);
        }

        /*
        GraphNode n1 = new GraphNode(1);
        GraphNode n2 = new GraphNode(2);
        GraphNode n3 = new GraphNode(3);
        GraphNode n4 = new GraphNode(4);
        GraphNode n5 = new GraphNode(5);
        n1.addAdjacent(n2);
        n2.addAdjacent(n3);
        n3.addAdjacent(n4);
        n4.addAdjacent(n2);
        n3.addAdjacent(n5);

        HashSet<GraphNode> cycle = GraphNode.detectCycle( n1, n1, new HashSet<GraphNode>(), new CycleDetector());
        System.out.println("Cycle: ");
        for( GraphNode n : cycle)System.out.println(n);

        int steps =  GraphNode.bfsSteps(n1, cycle);
        System.out.println("steps: " + steps);
        */
    }



    // SOLUTIONS
    /*

     */




}


