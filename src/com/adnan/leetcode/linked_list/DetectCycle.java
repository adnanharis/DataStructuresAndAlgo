// "static void main" must be defined in a public class.
// https://www.interviewcake.com/question/java/linked-list-cycles?course=fc1&section=linked-lists
// Floyd’s Cycle-Finding Algorithm - O(n) time and O(1) space

public class DetectCycle {
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
        System.out.println(hasCycle(head));
        e.next = c;
        // print(head);
        System.out.println(hasCycle(head));
    }

    private static boolean hasCycle(Node head) {
        Node slowRunner = head; // step 1
        Node fastRunner = head; // step 2
        while (slowRunner != null && fastRunner != null && fastRunner.next != null) {
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;
            if (slowRunner == fastRunner) {
                return true;
            }
        }

        return false;
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