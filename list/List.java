package list;

public class List {

	private int arr[];
	private int size;
	private final int DEF_CAP = 10;

	List() {
		arr = new int[DEF_CAP];
		size = 0;
	}

	public void insert(int x) {
		if (isFull()) {
			reSize();
		}
		arr[size++] = x;
		System.out.println("Inserted: " + x);
	}

	private void reSize() {
		int newCapacity = arr.length * 2;
		int[] tempArr = new int[newCapacity];
		System.arraycopy(arr, 0, tempArr, 0, arr.length);
		arr = tempArr;
		System.out.println("Resized to capacity: " + newCapacity);
	}

	private boolean isFull() {
		return size == arr.length;
	}

	private boolean isEmpty() {
		return size == 0;
	}

	public int remove() {
		if (!isEmpty()) {
			int temp = arr[--size];
			System.out.println("Removed: " + temp);
			return temp;
		}
		System.out.println("List is empty. Cannot remove.");
		return -1;
	}

	public int search(int x) {
		for (int i = 0; i < size; i++) {
			if (arr[i] == x) {
				return i;
			}
		}
		return -1;
	}

	public boolean contains(int x) {
		return search(x) != -1;
	}

	public int get(int index) {
		if (index >= 0 && index < size) {
			return arr[index];
		}
		System.out.println("Invalid index: " + index);
		return -1;
	}

	public void clear() {
		size = 0;
		System.out.println("List cleared.");
	}

	public int capacity() {
		return arr.length;
	}

	public void printList() {
		if (isEmpty()) {
			System.out.println("List is empty.");
			return;
		}
		for (int i = 0; i < size; i++) {
			System.out.print(arr[i] + (i < size - 1 ? ", " : "\n"));
		}
	}

	public int size() {
		return size;
	}
}
