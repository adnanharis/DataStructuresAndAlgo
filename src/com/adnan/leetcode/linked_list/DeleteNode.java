// "static void main" must be defined in a public class.
// https://www.interviewcake.com/question/java/delete-node?course=fc1&section=linked-lists
// Simple O(1) time and space

public class DeleteNode {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        LinkedListNode a = new LinkedListNode(1);
        LinkedListNode b = new LinkedListNode(2);
        LinkedListNode c = new LinkedListNode(3);

        a.next = b;
        b.next = c;

        print(a);
        deleteNode(b);
        print(a);
    }

    private static void deleteNode(LinkedListNode node) {
        if (node == null) {
            return;
        }

        if (node.next == null) {
            throw new IllegalStateException("Cannot delete last node with direct reference");
        }

        // Replace deleting node with node to next. Actually deleting next node after copying the fields
        LinkedListNode nextNode = node.next;
        node.data = nextNode.data;
        node.next = nextNode.next;
        nextNode = null;
    }

    private static void print(LinkedListNode node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
}

class LinkedListNode {
    public int data;
    public LinkedListNode next;

    public LinkedListNode(int data) {
        this.data = data;
    }
}
