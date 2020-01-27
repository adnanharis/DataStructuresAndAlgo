// "static void main" must be defined in a public class.
/*
https://www.interviewcake.com/question/java/kth-to-last-node-in-singly-linked-list?course=fc1&section=linked-lists
https://www.geeksforgeeks.org/nth-node-from-the-end-of-a-linked-list/

Simple: 2 approaches: Both have O(n) time and O(1) space
1. We walk one pointer from head to tail to get the list's length, then walk another pointer from the head node to the target node (the kth to last node).

2. Maintain two pointers. rightNode also walks all the way from head to tail, and leftNode also walks from the head to the target node. leftNode starts after n nodes walks of right.
*/

public class KthLastNodeLL {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}