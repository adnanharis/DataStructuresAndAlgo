package com.adnan;

import java.util.Random;

public class BinarySearchTree {

    public static void main (String[] args) {
        // int[] arr = new int[1000];
        int[] arr = new int[]{50, 100, 25, 75, 125, 11, 15, 5, 7, 3, 80, 71, 55, 110, 22, 45, 88, 44, 73};
        BST<Integer> integerBST = new BST<>();
        Random randomGenerator = new Random();
        for (int a : arr) {
            integerBST.insert(a); // randomGenerator.nextInt(1000)
        }

        int x = 2;
        int y = 11;
        System.out.println("Element: " + x + " found: " + integerBST.find(x));
        System.out.println("Element: " + y + " found: " + integerBST.find(y));
        System.out.println("Height: " + integerBST.getHeight());

        integerBST.inOrderTraversal();
        System.out.println();
        integerBST.preOrderTraversal();
        System.out.println();
        integerBST.postOrderTraversal();
        System.out.println();

        System.out.println("Minimum: " + integerBST.getMin() + " : " + new BST<>().getMin());
        System.out.println("Kth Smallest: "); // + integerBST.kthSmallest(2) + " : " + integerBST.kthSmallest(7));
        integerBST.kthSmallest(2);
        System.out.println();

        System.out.println("\nIsBinary: " + integerBST.isBinary());
//        integerBST.root.right = new Node<>(1);
//        System.out.println("\nIsBinary: " + integerBST.isBinary());
        integerBST.root.left.right = new Node<>(52);
        System.out.println("\nIsBinary: " + integerBST.isBinary());

    }

}

class Node<T extends Comparable<T>> {
    T data;
    Node<T> left;
    Node<T> right;

    public Node(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return "" + data;
    }
}

class BST<T extends Comparable<T>> {
    Node<T> root;

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(T data) {
        this.root = insert(this.root, data);
    }

    private Node<T> insert(Node<T> node, T data) {

        if (node == null) {
            node = new Node<>(data);
        } else if (node.data.compareTo(data) > 0) {
            node.left = insert(node.left, data);
        } else if (node.data.compareTo(data) < 0) {
            node.right = insert(node.right, data);
        }

        return node;
    }

    public boolean find(T data) {
        return find(this.root, data);
    }

    private boolean find(Node<T> root, T data) {
        if (root == null) {
            return false;
        }

        if (root.data.compareTo(data) > 0) {
            return find(root.left, data);
        } else if (root.data.compareTo(data) < 0) {
            return find(root.right, data);
        } else {
            return true;
        }
    }

    public void inOrderTraversal() {
        inOrderTraversal(this.root);
    }

    private void inOrderTraversal(Node<T> node) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.left);
        System.out.print(node.data + " ");
        inOrderTraversal(node.right);
    }

    public void preOrderTraversal() {
        preOrderTraversal(this.root);
    }

    private void preOrderTraversal(Node<T> node) {
        if (node == null) {
            return;
        }

        System.out.print(node.data + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    public void postOrderTraversal() {
        postOrderTraversal(this.root);
    }

    private void postOrderTraversal(Node<T> node) {
        if (node == null) {
            return;
        }

        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.data + " ");
    }

    public int getHeight() {
        return getHeight(this.root);
    }

    private int getHeight(Node<T> node) {
        if (node == null || (node.left == null && node.right == null)) {
            return 0;
        }

        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    public boolean isBinary() {
//        return isBinary((Node<Integer>) root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return isB(root, null, null);
    }

    private boolean isBinary(Node<Integer> node, Integer min, Integer max) {
        System.out.print(node == null ? "NULL " : node.data + " ");

        if (node == null) {
            return true;
        }

        if (node.data < min || node.data > max) {
            return false;
        }

        return (isBinary(node.left, min, node.data - 1) && isBinary(node.right, node.data + 1, max));
    }

    private boolean isB(Node<T> node, Node<T> left, Node<T> right) {
        if (node == null) {
            return true;
        }

        if (left != null && node.data.compareTo(left.data) < 0) {
            return false;
        }

        if (right != null && node.data.compareTo(right.data) > 0) {
            return false;
        }

        return isB(node.left, left, node) && isB(node.right, node, right);
    }

    public T getMin() {
        return getMin(root);
    }

    private T getMin(Node<T> node) {
        if (node == null) {
            return null;
        }

        if (node.left == null) {
            return node.data;
        } else {
            return getMin(node.left);
        }
    }

    // TODO: Incomplete
    public void kthSmallest(int k) {
        kthSmallest(root, k, 0);
    }

    private void kthSmallest(Node<T> node, int k, int i) {
        if (node == null) {
            return;
        }

        kthSmallest(node.left, k, i);
        i++;
        if (k == i) {
            System.out.print(node.data + " ");
        }
        kthSmallest(node.right, k, i);
    }
}

