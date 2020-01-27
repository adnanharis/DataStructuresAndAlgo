// "static void main" must be defined in a public class.
public class SecondLagest_BST {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        int[] nodes = new int[]{50, 20, 30, 75, 80, 76, 78};
        BST bst = new BST();
        for (int node : nodes) {
            bst.insert(node);
        }

        // Simplest way is to reverse inorder traverse for 2 positions
        // I tried some different way to get it.
        Node node = bst.secondLargest();
        System.out.println("2nd Largest: " + (node != null ? node.data : "null"));

        System.out.print("InOrderTraversal: ");
        bst.printInorder();
        bst.print2D();
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

    public Node secondLargest() {
        if (root == null || (root.left == null && root.right == null)) {
            return null;
        } else {
            Node largest = largest(root);
            Node second = secondLargest;
            // Either this second or largest from left child of this largest will be second
            if (largest.left != null) {
                second = largest(largest.left);
            }
            return second;
        }
    }

    Node secondLargest;
    private Node largest(Node node) {
        if (node.right == null) {
            return node;
        }

        secondLargest = node;
        return largest(node.right);
    }

    // ---- Helper functions -----
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
    Node(int data) {
        this.data= data;
    }
}