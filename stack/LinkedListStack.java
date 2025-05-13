package stack;

class Node {
	int val;
	Node next;

	Node(int x) {
		val = x;
	}
}

public class LinkedListStack {
	private Node top;
	private int size;

	public LinkedListStack() {
		top = null;
		size = 0;
	}

	public void push(int value) {
		Node newNode = new Node(value);
		newNode.next = top;
		top = newNode;
		size++;
		System.out.println("Pushed: " + value);
	}

	public int pop() {
		if (isEmpty()) {
			System.out.println("Stack is empty! Cannot pop.");
			return -1;
		}
		int value = top.val;
		top = top.next;
		size--;
		System.out.println("Popped: " + value);
		return value;
	}

	public int peek() {
		if (isEmpty()) {
			System.out.println("Stack is empty! No top element.");
			return -1;
		}
		return top.val;
	}

	public boolean isEmpty() {
		return top == null;
	}

	public int size() {
		return size;
	}

	public void clear() {
		top = null;
		size = 0;
		System.out.println("Stack cleared.");
	}

	public void printStack() {
		if (isEmpty()) {
			System.out.println("Stack is empty.");
			return;
		}
		Node current = top;
		System.out.print("Stack: ");
		while (current != null) {
			System.out.print(current.val + (current.next != null ? " -> " : "\n"));
			current = current.next;
		}
	}

	public boolean contains(int value) {
		Node current = top;
		while (current != null) {
			if (current.val == value) {
				return true;
			}
			current = current.next;
		}
		return false;
	}
}
