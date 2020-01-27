// "static void main" must be defined in a public class.
// https://www.interviewcake.com/question/java/balanced-binary-tree?course=fc1&section=trees-graphs

public class SuperBalancedBinaryTree {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        int[] nodeArray = new int[]{50, 25, 75, 20, 30, 60, 80};

        // Build
        BST bst = new BST();
        for (int d : nodeArray) {
            bst.insert(d);
        }

        System.out.println("Is Super Balanced: " + bst.isBalanced());
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

    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node treeRoot) {

        // a tree with no nodes is superbalanced, since there are no leaves!
        if (treeRoot == null) {
            return true;
        }

        // we short-circuit as soon as we find more than 2
        List<Integer> depths = new ArrayList<>(3);
        int[] levelSum = new int[3];

        Deque<NodeDepthPair> nodes = new ArrayDeque<>();
        nodes.push(new NodeDepthPair(treeRoot, 0));

        while (!nodes.isEmpty()) {

            // pop a node and its depth from the top of our stack
            NodeDepthPair nodeDepthPair = nodes.pop();
            Node node = nodeDepthPair.node;
            int depth = nodeDepthPair.depth;
            levelSum[depth] += node.data;

            System.out.println(">" + node.data + " " + depth + " " + Arrays.toString(levelSum));

            // case: we found a leaf
            if (node.left == null && node.right == null) {

                // we only care if it's a new depth
                if (!depths.contains(depth)) {
                    depths.add(depth);

                    // two ways we might now have an unbalanced tree:
                    //   1) more than 2 different leaf depths
                    //   2) 2 leaf depths that are more than 1 apart
                    if (depths.size() > 2 || (depths.size() == 2
                            && Math.abs(depths.get(0) - depths.get(1)) > 1)) {
                        return false;
                    }
                }

                // case: this isn't a leaf - keep stepping down
            } else {
                if (node.left != null) {
                    nodes.push(new NodeDepthPair(node.left, depth + 1));
                }
                if (node.right != null) {
                    nodes.push(new NodeDepthPair(node.right, depth + 1));
                }
            }
        }

        return true;
    }
}

class NodeDepthPair {

    Node node;
    int depth;

    NodeDepthPair(Node node, int depth) {
        this.node = node;
        this.depth = depth;
    }
}

class Node {
    int data;
    Node left, right;

    public Node (int data) {
        this.data = data;
    }
}