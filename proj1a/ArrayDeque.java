public class ArrayDeque<T> {
	public int size;
	public int capacity;
	public int nextFirst;
	public int nextLast;
	public T[] array;

	public ArrayDeque() {
		size = 0;
		capacity = 8;
		nextFirst = 0;
		nextLast = 1;
		array = (T []) new Object[capacity];
	}

	public ArrayDeque(ArrayDeque other) {
		size = other.size;
		capacity = other.capacity;
		nextFirst = capacity - 1;
		nextLast = size;
		array = (T []) new Object[capacity];
		int start = (other.nextFirst + 1) % capacity;
		copyArray(array, (T [])other.array, size, start);
	}

	public void addFirst(T item) {
		if (size == capacity) {
			resizeArray();
		}
		array[nextFirst] = item;
		nextFirst = (nextFirst - 1 < 0) ? capacity - 1 : nextFirst - 1;
		size++;
	}

	public void addLast(T item) {
		if (size == capacity) {
			resizeArray();
		}
		array[nextLast] = item;
		nextLast = (nextLast + 1 >= capacity) ? 0 : nextLast + 1;
		size++;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void printDeque() {
		if (size == 0) return;
		int pointer = nextFirst + 1;
		for (int i = 0; i < size; i++) {
			if (pointer >= capacity) {
				pointer = 0;
			}
			System.out.println(array[pointer]);
			pointer++;
		}
	}

	public T removeFirst() {
		if (isEmpty()) return null;
		nextFirst = nextFirst + 1 >= capacity ? 0 : nextFirst + 1;
		T item = array[nextFirst];
		size--;
		resizeArray();
		return item;
	}

	public T removeLast() {
		if (isEmpty()) return null;
		nextLast = nextLast - 1 < 0 ? capacity - 1 : nextLast - 1;
		T item = array[nextLast];
		size--;
		resizeArray();
		return item;
	}

	public T get(int index) {
		int realIndex = (nextFirst + 1 + index) % capacity;
		return array[realIndex];
	}

	public void resizeArray() {
		int start = (nextFirst + 1) % capacity;
		T[] newArray = null;
		if (size >= capacity) {
			newArray = (T []) new Object[capacity * 2];
			capacity = capacity * 2;
		} else if ((double)size / capacity < 0.25){
			newArray = (T []) new Object[capacity / 2];
			capacity = capacity / 2;
		}
		copyArray(newArray, array, size, start);
		nextFirst = capacity - 1;
		nextLast = size;
	}

	public void copyArray(T[] newArray, T[] oldArray, int size, int start) {
		int pointer = start;
		for (int i = 0; i < size; i++) {
			newArray[i] = oldArray[pointer];
			pointer = pointer + 1 >= capacity ? 0 : pointer + 1;
		}
	}
}
