package com.adnan;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GraphTest {

    public static void main(String[] args) {

    }
}

class Graph {
    int V;

    List<ArrayList<Integer>> graph;
    public Graph(int V) {
        this.V = V;
        graph = new ArrayList<ArrayList<Integer>>(V);
        for (int i = 0; i < V; i++) {
            graph.set(i, new ArrayList<Integer>());
        }
    }

    public void connect(int v, int w) {
        graph.get(v).add(w);
        graph.get(w).add(v);
    }

    public int degree(int v) {
        return graph.get(v).size();
    }

    public int maxDegree() {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < graph.size(); i++) {
            if (degree(i) > max) {
                max = degree(i);
            }
        }

        return max;
    }

    public List<Integer> adj(int v) {
        return graph.get(v);
    }

    List<DFSPath> dfsPaths = new ArrayList<>(V);
    public void buildPaths() {
        for (int i = 0; i < graph.size(); i++) {
            dfsPaths.add(new DFSPath(this, i));
        }
    }

}

class DFSPath {
    boolean[] marked;
    int edgeTo[];
    int s;

    public DFSPath(Graph G, int s) {
        this.s = s;
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
                edgeTo[w] = v;
            }
        }
    }

    public boolean hasPath(int v) {
        return marked[v];
    }

    public List<Integer> path(int v) {
        if (!hasPath(v)) {
            return null;
        }

        Stack<Integer> stack = new Stack<>();
        for (int w = v; w != s; w = edgeTo[w]) {
            stack.push(w);
        }

        stack.push(s);
        return stack;
    }
}
