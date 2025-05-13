package queue;

public class Main {

	public static void main(String[] args) {

		Queue queue = new Queue();

		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);

		for (int i = 0; i < 5; i++) {
			System.out.println(queue.dequeue() + " dequeued from queue\n");

		}

	}

}
