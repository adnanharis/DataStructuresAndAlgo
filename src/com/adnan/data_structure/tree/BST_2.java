// "static void main" must be defined in a public class.

public class BST_2 {
    public static void main(String []args){
        System.out.println("Hello World");
        // int[] nodeArray = new int[]{50, 25, 75, 20, 30, 60, 80};
        int[] nodeArray = new int[]{50, 25, 75, 20, 30, 60, 80};

        // Build
        BST bst = new BST();
        for (int d : nodeArray) {
            bst.insert(d);
        }

        System.out.print("InOrderTraversal: ");
        bst.printInorder();

        System.out.print("Bfs Traversal: ");
        bst.bfs();
        System.out.println();

        System.out.print("Dfs Traversal: ");
        bst.dfs();
        System.out.println();

        System.out.println("Level Order Max: " + bst.levelOrderMax());

        System.out.println("\n--- --- --- ---");
        bst.print2D();
    }
}

class BST {
    Node root;

    public void insert(int d) {
        root = insert(root, d);
    }

    private Node insert(Node node, int d) {
        if (node == null) {
            node = new Node(d);
        } else if (d < node.data) {
            node.left = insert(node.left, d);
        } else if (d > node.data) {
            node.right = insert(node.right, d);
        }

        return node;
    }

    // ---- Traversal DeQueue | BFS -----
    public void bfs() {
        bfs(root);
    }

    private void bfs(Node root) {
        // Using queue
        if (root == null) {
            return;
        }

        Deque<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            Node node = queue.remove();
            System.out.print(node.data + " ");

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }
    // ---------------

    // ---- max of level elements ----
    class NodeDepthPair {
        Node node;
        int depth;
        public NodeDepthPair(Node node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public int levelOrderMax() {
        int[] list = getAllLevelAddition(root);
        int max = -1;
        for (int m : list) {
            max = max >= m ? max : m;
        }

        return max;
    }

    private int[] getAllLevelAddition(Node root) {
        if (root == null) {
            return new int[0];
        }

        int[] list = new int[getHeight(root)];
        Deque<NodeDepthPair> queue = new ArrayDeque<>();
        queue.add(new NodeDepthPair(root, 0));

        while(!queue.isEmpty()) {
            NodeDepthPair pair = queue.remove();
            Node node = pair.node;
            int depth = pair.depth;
            list[depth] += node.data;

            if (node.left != null) {
                queue.add(new NodeDepthPair(node.left, depth + 1));
            }

            if (node.right != null) {
                queue.add(new NodeDepthPair(node.right, depth + 1));
            }
        }

        return list;
    }
    // -----------

    // ----- height -----
    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }

        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    // ------- DFS --------
    public void dfs() {
        dfs(root);
    }

    private void dfs(Node root) {
        if (root == null) {
            return;
        }

        // Deque is 'double ended queue' so here we will use it as Stack
        // ArrayDeque is unsynchronized resizable list
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.print(node.data + " ");

            if (node.left != null) {
                stack.push(node.left);
            }

            if (node.right != null) {
                stack.push(node.right);
            }
        }
    }

    // ------- InOrder ----------
    public void printInorder() {
        inorder(root);
        System.out.println();
    }

    private void inorder(Node node) {
        if (node == null) {
            return;
        }

        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    // -----------
    final int COUNT = 10;
    void print2DUtil(Node root, int space) {
        // Base case
        if (root == null)
            return;

        // Increase distance between levels
        space += COUNT;

        // Process right child first
        print2DUtil(root.right, space);

        // Print current node after space
        // count
        System.out.print("\n");
        for (int i = COUNT; i < space; i++)
            System.out.print(" ");
        System.out.print(root.data + "\n");

        // Process left child
        print2DUtil(root.left, space);
    }

    // Wrapper over print2DUtil()
    void print2D() {
        // Pass initial space count as 0
        print2DUtil(root, 0);
    }

}

class Node {
    int data;
    Node left, right;

    public Node (int data) {
        this.data = data;
    }
}