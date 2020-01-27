// "static void main" must be defined in a public class.

public class BST_1 {
    public static void main(String []args){
        System.out.println("Hello World");
        int[] nodeArray = new int[]{50, 25, 75, 20, 30, 60, 80};

        // Build
        BST bst = new BST();
        for (int d : nodeArray) {
            bst.insert(d);
        }

        System.out.print("InOrderTraversal: ");
        bst.printInorder();

        System.out.println("Height: " + bst.getHeight());

        System.out.println("Min Height: " + bst.getMinHeight());

        System.out.println("Is Full: " + bst.isFullBT());

        System.out.println("Is Balanced: " + bst.isBalanced());

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

    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }

        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    public int getMinHeight() {
        return getMinHeight(root);
    }

    private int getMinHeight(Node node) {
        if (node == null) {
            return 0;
        }

        return 1 + Math.min(getMinHeight(node.left), getMinHeight(node.right));
    }

    // ----- Is balanced -------
    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        if (leftHeight != rightHeight) {
            return false;
        } else {
            return isBalanced(node.left) == isBalanced(node.right);
        }
    }

    // -------------------

    // ------ is Full -----
    public boolean isFullBT() {
        return isFullBT(root);
    }

    private boolean isFullBT(Node node) {
        if (node == null || (node.left == null && node.right == null)) {
            return true;
        } else if (node.left == null || node.right == null) {
            return false;
        }

        return isFullBT(node.left) == isFullBT(node.right);
    }
    // ---------------------

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