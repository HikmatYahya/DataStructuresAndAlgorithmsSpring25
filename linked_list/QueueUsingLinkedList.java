package linked_list;

public class QueueUsingLinkedList implements Queue {
	
	
	LinkedList queue ;
	
	
	QueueUsingLinkedList(){
		
		queue = new LinkedList();
	}

	@Override
	public void enqueue(int value) {
		// TODO Auto-generated method stub
		
		queue.addLast(value);
		
	}

	@Override
	public Node dequeue() {
		// TODO Auto-generated method stub
		return queue.removeFirst();
	}

	@Override
	public Node peek() {
		// TODO Auto-generated method stub
		return queue.getHead();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return queue.getSize();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return queue.isEmpty();
	}
	
	

}
