// "static void main" must be defined in a public class.
// https://www.interviewcake.com/question/python/mesh-message?course=fc1&section=trees-graphs

public class MeshMessage_GraphSP {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Map<String, String[]> network = new HashMap<String, String[]>() {{
            put("Min",     new String[] { "William", "Jayden", "Omar" });
            put("William", new String[] { "Min", "Noam" });
            put("Jayden",  new String[] { "Min", "Amelia", "Ren", "Noam" });
            put("Ren",     new String[] { "Jayden", "Omar" });
            put("Amelia",  new String[] { "Jayden", "Adam", "Miguel" });
            put("Adam",    new String[] { "Amelia", "Miguel", "Sofia", "Lucas" });
            put("Miguel",  new String[] { "Amelia", "Adam", "Liam", "Nathan" });
            put("Noam",    new String[] { "Nathan", "Jayden", "William" });
            put("Omar",    new String[] { "Ren", "Min", "Scott" });
        }};

        Graph graph = new Graph(network);
        List<String> path = graph.getShortestPath("Jayden", "Adam");
        System.out.println("Path: " + path);
    }
}

// ----- Graph -----

class Graph {
    Map<String, String[]> graph;

    Graph(Map<String, String[]> g) {
        this.graph = g;
    }

    public String[] getAdj(String node) {
        return graph.get(node);
    }

    // BFS
    public List<String> getShortestPath(String start, String end) {
        Map<String, String> path = new HashMap<>();
        List<String> visited = new ArrayList<>();
        Deque<String> queue = new ArrayDeque<>();
        queue.add(start);
        path.put(start, start);

        while(!queue.isEmpty()) {
            String n = queue.remove();
            visited.add(n);

            if (n.equals(end)) {
                break;
            }


            for (String node : getAdj(n)) {
                if (!visited.contains(node)) {
                    queue.add(node);
                    path.put(node, n);
                }
            }
        }

        System.out.println(path);
        List<String> list = new ArrayList<>();
        String key = end;
        list.add(key);
        while(!path.get(key).equals(start)) {
            key = path.get(key);
            list.add(key);
        }
        list.add(start);
        Collections.reverse(list);
        return list;
    }
}