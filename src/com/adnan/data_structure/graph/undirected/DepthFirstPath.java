package com.adnan.graph.undirected;

import java.util.List;
import java.util.Stack;

public class DepthFirstPath {
    Integer s;
    boolean[] visited;
    Integer[] edgeTo;

    public DepthFirstPath(Graph graph, Integer s) {
        visited = new boolean[graph.getSize()];
        edgeTo = new Integer[graph.getSize()];

        dfs(graph, s);
    }

    private void dfs(Graph graph, Integer v) {
        visited[v] = true;

        for (Integer w : graph.adj(v)) {
            if (!visited[w]) {
                dfs(graph, w);
                edgeTo[w] = v;
            }
        }
    }

    public boolean hasPath(int v) {
        return visited[v];
    }

    public Iterable<Integer> path(int v) {
        if (!hasPath(v)) {
            return null;
        }

        Stack<Integer> stack = new Stack<>();
        for (Integer x = v; x != s; x = edgeTo[x]) {
            stack.push(x);
        }
        stack.push(s);
        return stack;
    }

}
