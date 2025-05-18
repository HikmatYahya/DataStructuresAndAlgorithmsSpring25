package linked_list;

public class StackUsingLinkedList implements Stack {

	LinkedList top;

	StackUsingLinkedList() {

		top = new LinkedList();
	}

	@Override
	public void push(int value) {
		// TODO Auto-generated method stub

		top.addFirst(value);

	}

	@Override
	public Node pop() {
		// TODO Auto-generated method stub
		return top.removeFirst();
	}

	@Override
	public Node top() {
		// TODO Auto-generated method stub
		return top.getHead();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return top.getSize();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return top.isEmpty();
	}

}
