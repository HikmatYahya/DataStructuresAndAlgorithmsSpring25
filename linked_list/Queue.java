package linked_list;

public interface Queue {

	public void enqueue(int value);

	public Node dequeue();

	public Node peek();

	public int size();

	public boolean isEmpty();

}
