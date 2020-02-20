package com.adnan.graph.undirected;

public class GraphTest {

    public static void main(String[] args) {
        Graph graph = new Graph(13);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 5);
        graph.addEdge(0, 6);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(7, 8);
        graph.addEdge(9, 10);
        graph.addEdge(9, 11);
        graph.addEdge(9, 12);
        graph.addEdge(11, 12);

        /*
        graph.addEdge(0, 5);
        graph.addEdge(2, 4);
        graph.addEdge(2, 3);
        graph.addEdge(1, 2);
        graph.addEdge(0, 1);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(0, 2);
         */

        DepthFirstPath dfsPath = new DepthFirstPath(graph, 0);
        Iterable<Integer> path = dfsPath.path(5);
        for (Integer v : path) {
            System.out.print(v + " -> ");
        }
        System.out.println();
    }
}
