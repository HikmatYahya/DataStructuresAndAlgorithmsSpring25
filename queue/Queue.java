package queue;

public class Queue {
    private static final int INITIAL_SIZE = 10;
    private int[] queueArray;
    private int front;
    private int rear;
    private int size;

    public Queue() {
        queueArray = new int[INITIAL_SIZE];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(int item) {
        if (size == queueArray.length) {
            resize();
        }
        rear = (rear + 1) % queueArray.length;
        queueArray[rear] = item;
        size++;
        System.out.println("Enqueued: " + item);
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1;
        }
        int removedItem = queueArray[front];
        front = (front + 1) % queueArray.length;
        size--;
        System.out.println("Dequeued: " + removedItem);
        return removedItem;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. No front element.");
            return -1;
        }
        return queueArray[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return queueArray.length;
    }

    private void resize() {
        int newSize = queueArray.length * 2;
        int[] newQueueArray = new int[newSize];
        for (int i = 0; i < size; i++) {
            newQueueArray[i] = queueArray[(front + i) % queueArray.length];
        }
        front = 0;
        rear = size - 1;
        queueArray = newQueueArray;
        System.out.println("Queue resized to: " + newSize);
    }

    public void clear() {
        front = 0;
        rear = -1;
        size = 0;
        System.out.println("Queue cleared.");
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue: ");
        for (int i = 0; i < size; i++) {
            System.out.print(queueArray[(front + i) % queueArray.length] + (i < size - 1 ? ", " : "\n"));
        }
    }

    public boolean contains(int item) {
        for (int i = 0; i < size; i++) {
            if (queueArray[(front + i) % queueArray.length] == item) {
                return true;
            }
        }
        return false;
    }
}
