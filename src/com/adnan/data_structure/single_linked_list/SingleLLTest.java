
public class SingleLLTest {
	
	public static void main(String args[]) {
		SingleList<Integer> sl = new SingleList<>();
		System.out.println("IsEmpty: " + sl.isEmpty());
		sl.append(1); sl.append(2); sl.append(3); 
		sl.append(4); sl.append(5);
		System.out.println("IsEmpty: " + sl.isEmpty() + " = " + sl.toString());

		sl.prepend(-1);
		sl.prepend(-2);
		System.out.println("IsEmpty: " + sl.isEmpty() + " = " + sl.toString());

		System.out.println("Get First: " + sl.getFirst() + " | Get last: " + sl.getLast() + " | Get Last NULL: " + new SingleList<Integer>().getLast());

		sl.insert(6, 6);
		sl.insert(0, -3);
		sl.insert(3, 0);
		System.out.println("Insert = " + sl.toString());

		sl.removeLast();
		sl.removeLast();
		sl.append(11);
		System.out.println("Remove 2 Last then add 11 = " + sl.toString());
		// sl.insert(10, 12);

		sl.removeFirst();
		System.out.println("Remove First = " + sl.toString());

		SingleList<Integer>.Node<Integer> n101 = sl.new Node<>(101);
		SingleList<Integer>.Node<Integer> n102 = sl.new Node<>(102);
		sl.append(n101);
		sl.append(n102);

		System.out.println("Added with node pointer = " + sl.toString());
		
		sl.remove(n101);
		System.out.println("Removed 101 with node pointer = " + sl.toString());
		// sl.remove(n102);
		
		System.out.println("Find kth last 2: " + sl.findKthLast(2) + " | 10 : " + sl.findKthLast(10));
	}
}


class SingleList<T> {
	private Node<T> head;
	private int size = 0;

	class Node<T> {
		T data;
		Node<T> next;

		Node(T data) {
			this.data = data;
		}
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void append(T data) {
		Node<T> newNode = new Node<>(data);
		if (head == null) {
			head = newNode;
			size++;
			return;
		}
		Node<T> node = head;
		while(node.next != null) {
			node = node.next;
		}

		node.next = newNode;
		size++;
	}

	public void append(Node<T> newNode) {
		if (head == null) {
			head = newNode;
			size++;
			return;
		}

		Node<T> node = head;
		while (node.next != null) {
			node = node.next;
		}

		node.next = newNode;
		size++;
	}

	public void prepend(T data) {
		Node<T> newNode = new Node<>(data);
		if (head == null) {
			head = newNode;
			size++;
			return;
		}

		newNode.next = head;
		head = newNode;
		size++;
	}

	public void insert(int index, T data) {
		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException();
		}

		if (index == 0) {
			prepend(data);
			return;
		}

		Node<T> node = head;
		for (int i = 0; i < index - 1; i++) {
			node = node.next;
		}

		Node<T> newNode = new Node<>(data);
		newNode.next = node.next;
		node.next = newNode;
		size++;
	}

	public T getFirst() {
		return head == null ? null : head.data;
	}

	public T getLast() {
		if (head == null) {
			return null;
		}

		Node<T> node = head;
		while(node.next != null) {
			node = node.next;
		}

		return node.data;
	}

	public T removeLast() {
		if (head == null) {
			return null;
		}

		if (head.next == null) {
			T data = head.data;
			head = null;
			size--;
			return data;
		}

		Node<T> prev = head;
		Node<T> node = head.next;
		while(node.next != null) {
			node = node.next;
			prev = prev.next;
		}

		T data = node.data;
		prev.next = null;
		size--;
		return data;
	}

	public T removeFirst() {
		if (head == null) {
			return null;
		}

		Node<T> node = head;
		head = head.next;
		T data  = node.data;
		node = null;
		return data;
	}

	/* IMP */
	public void remove(Node<T> node) {
		if (node == null) {
			return;
		}

		if (node.next == null) {
			throw new IllegalStateException("Cannot delete last node with direct reference");
		}

        Node<T> nextNode = node.next;
        node.data = nextNode.data;
        node.next = nextNode.next;
        nextNode = null;
	}

	public T findKthLast(int index) {
		if (head == null) {
			return null;
		}

		Node<T> node = head;
		Node<T> kthNode = head;

		int i = 1;
		while(node.next != null) {
			node = node.next;
			if (i++ >= index) {
				kthNode = kthNode.next;
			}
		}

		if (i < index) {
			return null;
		}

		return kthNode.data;
	}

	// findCycle (with 2 pointers slow and fast)
	// kth last node (2 ways: 1. iterate first to get the size then iterate upto size - k 
	// 2. Two pointers: second will start after first has moved kth position)

	@Override
	public String toString() {
		if (head == null) {
			return "";
		}

		Node<T> node = head;
		StringBuilder sb = new StringBuilder();

		while (node != null) {
			sb.append(node.data + " ");
			node = node.next;
		}

		return sb.toString();
	}
}

/*

append()
prepend()
insert(index)
get() // last
get(index)
remove() // last
remove(index)

*/