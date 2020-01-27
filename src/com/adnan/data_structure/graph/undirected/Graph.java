package com.adnan.graph.undirected;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private final int V; // number of vertices
    private List<Integer>[] bag;

    public Graph(int v) {
        this.V = v;
        bag = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            bag[i] = new ArrayList<>();
        }
    }

    public void addEdge(int v, int w) {
        bag[v].add(w);
        bag[w].add(v);
    }

    public Iterable<Integer> adj(int v) {
        return bag[v];
    }

    public int getSize() {
        return V;
    }
}
