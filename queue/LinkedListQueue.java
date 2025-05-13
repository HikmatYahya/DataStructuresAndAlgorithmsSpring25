package queue;

class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
		this.next = null;
	}
}

public class LinkedListQueue {
	private Node front;
	private Node rear;
	private int size;

	public LinkedListQueue() {
		front = null;
		rear = null;
		size = 0;
	}

	public void enqueue(int item) {
		Node newNode = new Node(item);
		if (isEmpty()) {
			front = rear = newNode;
		} else {
			rear.next = newNode;
			rear = newNode;
		}
		size++;
		System.out.println("Enqueued: " + item);
	}

	public int dequeue() {
		if (isEmpty()) {
			System.out.println("Queue is empty. Cannot dequeue.");
			return -1;
		}
		int removedItem = front.data;
		front = front.next;
		if (front == null) {
			rear = null;
		}
		size--;
		System.out.println("Dequeued: " + removedItem);
		return removedItem;
	}

	public int peek() {
		if (isEmpty()) {
			System.out.println("Queue is empty. No front element.");
			return -1;
		}
		return front.data;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void clear() {
		front = rear = null;
		size = 0;
		System.out.println("Queue cleared.");
	}

	public void printQueue() {
		if (isEmpty()) {
			System.out.println("Queue is empty.");
			return;
		}
		System.out.print("Queue: ");
		Node current = front;
		while (current != null) {
			System.out.print(current.data + (current.next != null ? " -> " : "\n"));
			current = current.next;
		}
	}

	public boolean contains(int item) {
		Node current = front;
		while (current != null) {
			if (current.data == item) {
				return true;
			}
			current = current.next;
		}
		return false;
	}
}
