public class LinkedListDeque<T> {
	public Node head;
	public int size;

	public class Node {
		public T item;
		public Node next;
		public Node prev;
		public Node(T item) {
		    this.item = item;
        }
	}

	public LinkedListDeque() {
		head = new Node(null);
		head.prev = head;
		head.next = head;
		size = 0;
	}

	public LinkedListDeque(LinkedListDeque other) {
		head = new Node(null);
		head.prev = head;
		head.next = head;
		size = 0;
        Node pointer = other.head.next;
        while (pointer != other.head) {
            addLast(pointer.item);
            pointer = pointer.next;
            size += 1;
        }
    }

	public void addFirst(T item) {
        Node newNode = new Node(item);
        newNode.next = head.next;
        newNode.prev = head;
        head.next.prev = newNode;
        head.next = newNode;
        size++;
	}

	public void addLast(T item) {
        Node newNode = new Node(item);
        head.prev.next = newNode;
        newNode.prev = head.prev;
        newNode.next = head;
        head.prev = newNode;
        size++;
	}

	public boolean isEmpty() {
	    return size == 0;
    }

	public int size() {
	    return size;
    }

	public void printDeque() {
	    Node pointer = head.next;
	    while(pointer != head) {
	        System.out.println(String.valueOf(pointer.item));
	        pointer = pointer.next;
        }
    }

	public T removeFirst() {
		if (isEmpty()) return null;
	    T item = head.next.item;
	    Node newFirst = head.next.next;
	    if (newFirst != null) {
            newFirst.prev = head;
            head.next = newFirst;
            size--;
        }
	    return item;
    }

	public T removeLast() {
		if (isEmpty()) return null;
	    T item = head.prev.item;
	    Node newLast = head.prev.prev;
	    if (newLast != null) {
	        head.prev.prev.next = newLast;
	        newLast.next = head;
	        size--;
        }
        return item;
    }

	public T get(int index) {
	    if (index <= size) {
	        return null;
        }
	    // iterative way
        Node pointer = head.next;
        int i = 0;
        while (pointer != null && pointer.item != null && i < index) {
            i++;
            pointer = pointer.next;
        }
        return pointer.item;
    }

	public T getRecursive(int index) {
	    if (index <= size) {
	        return null;
        }
        return getRecursiveNode(index, head.next);
    }

    public T getRecursiveNode(int index, Node headNode) {
	    if (index == 0) return headNode.item;
	    return getRecursiveNode(index - 1, headNode.next);
    }
}
