package linkedList;

class Node {

	int data;
	Node next;

	Node(int data) {
		this.data = data;
		this.next = null;
	}
}

public class LinkedList {

	private Node head;
	private int size;

	public LinkedList() {
		head = null;
		size = 0;
	}

	public void addFirst(int val) {
		Node newNode = new Node(val);
		newNode.next = head;
		head = newNode;
		size++;
		System.out.println("Added at the beginning: " + val);
	}

	public void addLast(int val) {
		Node newNode = new Node(val);
		if (head == null) {
			head = newNode;
		} else {
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
		size++;
		System.out.println("Added at the end: " + val);
	}

	public void removeFirst() {
		if (head == null) {
			System.out.println("List is empty.");
			return;
		}
		head = head.next;
		size--;
		System.out.println("First element removed.");
	}

	public void removeLast() {
		if (head == null) {
			System.out.println("List is empty.");
			return;
		}
		if (head.next == null) {
			head = null;
		} else {
			Node current = head;
			while (current.next.next != null) {
				current = current.next;
			}
			current.next = null;
		}
		size--;
		System.out.println("Last element removed.");
	}

	public boolean search(int val) {
		Node current = head;
		while (current != null) {
			if (current.data == val) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	public void clear() {
		head = null;
		size = 0;
		System.out.println("List cleared.");
	}

	public void printList() {
		Node current = head;
		while (current != null) {
			System.out.print(current.data + (current.next != null ? ", " : "\n"));
			current = current.next;
		}
	}

	public int getSize() {
		return size;
	}

	public int getHead() {
		return head != null ? head.data : -1;
	}
}
