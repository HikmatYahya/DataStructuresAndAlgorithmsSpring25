package linked_list;

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
	private Node tail;
	private int size;

	public LinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	public void addFirst(int val) {
		Node newNode = new Node(val);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		size++;
		System.out.println("Added at the beginning: " + val);
	}

	public void addLast(int val) {
		Node newNode = new Node(val);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		size++;
		System.out.println("Added at the end: " + val);
	}

	public Node removeFirst() {
		if (head == null) {
			System.out.println("List is empty.");
			return null;
		}
		Node removedNode = head;

		if (head == tail) { // Only one element
			head = null;
			tail = null;
		} else {
			head = head.next;
		}
		size--;
		System.out.println("First element removed: " + removedNode.data);
		return removedNode;
	}

	public Node removeLast() {
		if (head == null) {
			System.out.println("List is empty.");
			return null;
		}

		Node removedNode;
		if (head == tail) { // Only one element
			removedNode = head;
			head = null;
			tail = null;
		} else {
			Node current = head;
			while (current.next != tail) {
				current = current.next;
			}
			removedNode = tail;
			current.next = null;
			tail = current;
		}
		size--;
		System.out.println("Last element removed: " + removedNode.data);
		return removedNode;
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
		tail = null;
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

	public Node getHead() {
		return head != null ? head : null;
	}

	public Node getTail() {
		return tail != null ? tail : null;
	}
	
	public boolean isEmpty() {
		
		return size == 0;
	}
}
