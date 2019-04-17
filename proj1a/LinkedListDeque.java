public class LinkedListDeque<T> {
	private Node head;

	public class Node {
		public T item;
		public Node next;
		public Node prev;
	}

	public LinkedListDeque() {
		head = new Node();
		head.next = null;
		head.prev = null;
	}

	public void addFirst(T item) {

	}

	public void addLast(T item) {

	}

	public boolean isEmpty() {}

	public int size() {}

	public void printDeque() {}

	public T removeFirst() {}

	public T removeLast() {}

	public T get(int index) {}
}
