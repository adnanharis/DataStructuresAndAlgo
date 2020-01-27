// "static void main" must be defined in a public class.
// https://www.interviewcake.com/question/python/queue-two-stacks?course=fc1&section=queues-stacks

public class QueueWith2Stacks {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        StackQueue stackQue = new StackQueue();
        System.out.println("isEmpty " + stackQue.isEmpty());
        stackQue.enqueue(1);
        System.out.println("isEmpty " + stackQue.isEmpty());
        stackQue.enqueue(2);
        stackQue.enqueue(3);
        System.out.println(stackQue.dequeue());
        stackQue.enqueue(4);
        stackQue.enqueue(5);
        System.out.println(stackQue.dequeue());
        System.out.println(stackQue.dequeue());
        System.out.println(stackQue.dequeue());
        System.out.println(stackQue.dequeue());
        System.out.println(stackQue.dequeue());
    }
}

class StackQueue {
    Deque<Integer> inStack = new ArrayDeque<>();
    Deque<Integer> outStack = new ArrayDeque<>();

    public boolean isEmpty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    public void enqueue(Integer item) {
        inStack.push(item);
    }

    public Integer dequeue() {
        if (!outStack.isEmpty()) {
            return outStack.pop();
        }

        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }

        if (outStack.isEmpty()) {
            return null;
        }

        return outStack.pop();
    }
}

/*
For m operations of enqueue() and dequeue(),
Let's look at the worst case for a single item, which is the case where it is enqueued and then later dequeued. In this case, the item enters in_stack (costing 1 push), then later moves to out_stack (costing 1 pop and 1 push), then later comes off out_stack to get returned (costing 1 pop).

Each of these 4 pushes and pops is O(1) time. So our total cost per item is O(1). Our m enqueue and dequeue operations put m or fewer items into the system, giving a total runtime of O(m).
*/