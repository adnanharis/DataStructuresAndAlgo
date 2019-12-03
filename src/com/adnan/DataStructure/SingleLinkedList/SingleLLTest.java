
public class SingleLLTest {
	
	public static void main(String args[]) {
		SingleList<Integer> sl = new SingleList<>();
		System.out.println("IsEmpty: " + sl.isEmpty());
		sl.append(1);
		sl.append(2);
		sl.append(3);
		sl.append(4);
		sl.append(5);
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
		System.out.println("Remove Last then add = " + sl.toString());

		// sl.insert(10, 12);
	}
}


class SingleList<T> {
	private Node<T> head;
	private int size = 0;

	private class Node<T> {
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