// "static void main" must be defined in a public class.
// https://www.interviewcake.com/question/java/bst-checker?course=fc1&section=trees-graphs

// Imp: Checking if an in-order traversal of the tree is sorted is a great answer too, especially if you're able to implement it without storing a full list of nodes.
public class BinarySearchTreeChecker {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        int[] nodes = new int[]{50, 20, 30, 75, 80};
        BST bst = new BST();
        for (int node : nodes) {
            bst.insert(node);
        }

        System.out.println("Is BST: " + bst.isBST());

        BST bst2 = new BST();
        bst2.root = new Node(50);
        bst2.root.left = new Node(20);
        bst2.root.right = new Node(75);
        bst2.root.left.left = new Node(10);
        bst2.root.right.left = new Node(100); // false: should be right child
        System.out.println("Is BST: " + bst2.isBST());
        System.out.println("Is BST Recursive: " + bst2.isBSTRecusive());
    }
}

class BST {
    Node root;

    public void insert(int data) {
        root = insert(root, data);
    }

    private Node insert(Node node, int data) {
        if (node == null) {
            node = new Node(data);
        } else if (data < node.data) {
            node.left = insert(node.left, data);
        } else if (data > node.data) {
            node.right = insert(node.right, data);
        }

        return node;
    }

    public boolean isBST() {
        return isBST(root);
    }

    private boolean isBST(Node root) {
        if (root == null) {
            return true;
        }

        Deque<NodeBounds> stack = new ArrayDeque<>();
        stack.push(new NodeBounds(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

        while(!stack.isEmpty()) {
            NodeBounds nodeBounds = stack.pop();
            Node node = nodeBounds.node;
            int lowerBound = nodeBounds.lowerBound;
            int upperBound = nodeBounds.upperBound;

            if (node.data <= lowerBound || node.data >= upperBound) {
                return false;
            }

            if (node.left != null) {
                stack.push(new NodeBounds(node.left, lowerBound, node.data));
            }

            if (node.right != null) {
                stack.push(new NodeBounds(node.right, node.data, upperBound));
            }
        }

        return true;
    }

    public boolean isBSTRecusive() {
        return isBSTRecusive(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBSTRecusive(Node node, int lowerBound, int upperBound) {
        if (node == null) {
            return true;
        }

        if (node.data <= lowerBound || node.data >= upperBound) {
            return false;
        }

        return isBSTRecusive(node.left, lowerBound, node.data) && isBSTRecusive(node.right, node.data, upperBound);
    }
}

class NodeBounds {
    Node node;
    int lowerBound;
    int upperBound;

    NodeBounds(Node node, int l, int u) {
        this.node = node;
        lowerBound = l;
        upperBound = u;
    }
}

class Node {
    int data;
    Node left, right;

    Node(int d) {
        this.data = d;
    }
}