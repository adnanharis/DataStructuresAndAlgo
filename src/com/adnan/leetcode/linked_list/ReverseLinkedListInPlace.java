// "static void main" must be defined in a public class.
// https://www.interviewcake.com/question/java/reverse-linked-list?course=fc1&section=linked-lists
// O(n) time and O(1) space. We pass over the list only once, and maintain a constant number of variables in memory.

public class ReverseLinkedListInPlace {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Node head = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);

        head.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        print(head);
        Node newHead = reverse(head);
        print(newHead);
    }

    private static Node reverse(Node node) {
        Node prev = null, nexxt;
        while (node != null) {
            nexxt = node.next;
            node.next = prev;
            prev = node;
            node = nexxt;
        }

        return prev;
    }

    private static void print(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
}

class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }
}