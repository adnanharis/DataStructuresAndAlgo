
public class DynamicArrayTest {
	public static void main(String[] args) {
		DynamicArray<Integer> list = new DynamicArray<>();
		System.out.println("isEmpty: " + list.isEmpty() + " size: " + list.size());

		list.add(1); list.add(2); list.add(3); list.add(4); list.add(5); list.add(6);
		list.add(7); list.add(8); list.add(9); list.add(10); list.add(11);
		System.out.println("isEmpty: " + list.isEmpty() + " size: " + list.size());

		list.add(12);
		list.remove();
		list.remove(0);
		System.out.println("First: " + list.get(0) + " Last: " + list.get(list.size()-1) + " size: " + list.size());
		System.out.println("List: " + list.toString());
		System.out.println("Contins 0: " + list.contains(0) + " contains 10: " + list.contains(10));

		java.util.Iterator<Integer> it = list.iterator();
		while(it.hasNext()) {
			System.out.print(" > " + it.next());
		}
		System.out.println();
	}
}

@SuppressWarnings("unchecked")
class DynamicArray<T> implements Iterable<T> {
	private T[] data;
	private int size;
	private int capacity;

	public DynamicArray(int capacity) {
		// validate the capacity
		if (capacity <=0 ) {
			throw new IllegalArgumentException("Capacity needs to positive int");
		}

		data = (T[]) new Object[capacity];
		size = 0;
		this.capacity = capacity;
	}

	public DynamicArray() {
		this(10);
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public T get(int index) {
		return data[index];
	}

	public Boolean contains(T item) {
		for (int i = 0; i < size; i++) {
			if (item == data[i]) {
				return true;
			}
		}

		return false;
	}

	private void ensureCapacity(int futureCapacity) {
		if (futureCapacity > capacity) {
			capacity *= 2;
			T[] copyArray = (T[]) new Object[capacity];
			for (int i = 0; i < size; i++) {
				copyArray[i] = data[i];
			}
			data = copyArray;
		}
	}

	public void add(T item) {
		// ensure capacity
		ensureCapacity(size + 1);
		data[size++] = item;
	}

	public void add(int index, T item) {
		if (index >= size) {
			throw new IndexOutOfBoundsException();
		}

		ensureCapacity(size + 1);
		for (int i = size - 1; i >= index; i--) {
			data[i + 1] = data[i];
		}
		data[index] = item;
	}

	public T remove() {
		// this will remove the last
		return data[size--];
	}

	public T remove(int index) {
		if (index >= size) {
			throw new IndexOutOfBoundsException();
		}

		T removedData = data[index];
		for (int i = index; i < size - 1; i++) {
			data[i] = data[i + 1];
		}
		size--;
		return removedData;
	}


	@Override
	public java.util.Iterator<T> iterator() {
		return new java.util.Iterator<T>() {
			int i = 0;

			@Override
			public boolean hasNext() {
				return i < size;
			}

			@Override
			public T next() {
				if (i >= size) {
					throw new IndexOutOfBoundsException();
				}

				return data[i++];
			}

			public void remove() {
				if (i < 0) {
					throw new IndexOutOfBoundsException();
				}

				i--;
			}
		};
	};

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) {
			sb.append(data[i] + " ");
		}
		return sb.toString();
	}

}


/*

isEmpty()
size()
add() // Add to the end
add(index)
get(index)
contains(T)
remove()
remove(obj)
remove(index)

*/