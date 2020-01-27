// "static void main" must be defined in a public class.
// https://www.interviewcake.com/question/java/graph-coloring?course=fc1&section=trees-graphs

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class GraphColouring {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        GraphNode a = new GraphNode("a");
        GraphNode b = new GraphNode("b");
        GraphNode c = new GraphNode("c");

        a.addNeighbor(b);
        b.addNeighbor(a);
        b.addNeighbor(c);
        c.addNeighbor(b);

        GraphNode[] graph = new GraphNode[] { a, b, c };
        int maxInDeg = 2;

        for (GraphNode node: graph) {
            System.out.println(node.getLabel() + " " + (node.hasColor() ? node.getColor() : "-1"));
        }

        colourGraph(graph, 4);

        for (GraphNode node: graph) {
            System.out.println(node.getLabel() + " " + (node.hasColor() ? node.getColor() : "-1"));
        }
    }

    private static void colourGraph(GraphNode[] graph, int colors) {
        boolean[] tc;
        for (GraphNode node: graph) {
            tc = new boolean[colors];
            for (GraphNode n : node.getNeighbors()) {
                if (n.hasColor()) {
                    int i = Integer.parseInt(n.getColor());
                    tc[i] = true;
                }
            }

            for (int i = 0; i < tc.length; i++) {
                if (!tc[i]) {
                    node.setColor("" + i);
                    break;
                }
            }
        }
    }
}


// -------
class GraphNode {

    private String label;
    private Set<GraphNode> neighbors;
    private Optional<String> color;

    public GraphNode(String label) {
        this.label = label;
        neighbors = new HashSet<GraphNode>();
        color = Optional.empty();
    }

    public String getLabel() {
        return label;
    }

    public Set<GraphNode> getNeighbors() {
        return Collections.unmodifiableSet(neighbors);
    }

    public void addNeighbor(GraphNode neighbor) {
        neighbors.add(neighbor);
    }

    public boolean hasColor() {
        return color.isPresent();
    }

    public String getColor() {
        return color.get();
    }

    public void setColor(String color) {
        this.color = Optional.ofNullable(color);
    }
}
