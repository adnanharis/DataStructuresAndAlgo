public class BfsPath {
    private Graph graph;
    private Integer sourceVertex;
    private boolean[] visited;
    private Integer[] edgeTo;

    BfsPath(Graph g, Integer s) {
        graph = g;
        sourceVertex = s;
        visited = new boolean[graph.size()];
        edgeTo = new Integer[graph.size()];
        bfs(s);
    }

    private void bfs(Integer s) {
        Queue<Integer> queue = new ArrayDeque<>(graph.size());
        queue.add(s);
        visited[s] = true;

        while(!queue.isEmpty()) {
            Integer v = queue.poll();

            for (Integer w : graph.adj(v)) {
                if (!visited[w]) {
                    visited[w] = true;
                    edgeTo[w] = v;
                    queue.add(w);
                }
            }
        }
    }

    public Iterator<Integer> path(Integer v) {
        if (!visited[v]) {
            return null;
        }

        Stack<Integer> stack = new Stack<>();
        for (Integer w = v; w != sourceVertex; w = edgeTo[w]) {
            stack.push(w);
        }
        stack.push(sourceVertex);
        return stack.iterator();
    }
}