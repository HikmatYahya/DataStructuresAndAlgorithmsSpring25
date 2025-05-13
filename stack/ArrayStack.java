package stack;

public class ArrayStack {

	private final int MAXSIZE;
	private int[] stackArray;
	private int top;

	public ArrayStack(int size) {
		MAXSIZE = size;
		stackArray = new int[MAXSIZE];
		top = -1;
	}

	public void push(int value) {
		if (top < MAXSIZE - 1) {
			stackArray[++top] = value;
			System.out.println("Pushed: " + value);
		} else {
			System.out.println("Stack overflow! Cannot push: " + value);
		}
	}

	public int pop() {
		if (!isEmpty()) {
			int value = stackArray[top--];
			System.out.println("Popped: " + value);
			return value;
		} else {
			System.out.println("Stack is empty! Cannot pop.");
			return -1;
		}
	}

	public int peek() {
		if (!isEmpty()) {
			return stackArray[top];
		} else {
			System.out.println("Stack is empty! No top element.");
			return -1;
		}
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public int size() {
		return top + 1;
	}

	public void clear() {
		top = -1;
		System.out.println("Stack cleared.");
	}

	public void printStack() {
		if (isEmpty()) {
			System.out.println("Stack is empty.");
			return;
		}
		System.out.print("Stack: ");
		for (int i = 0; i <= top; i++) {
			System.out.print(stackArray[i] + (i < top ? ", " : "\n"));
		}
	}

	public boolean contains(int value) {
		for (int i = 0; i <= top; i++) {
			if (stackArray[i] == value) {
				return true;
			}
		}
		return false;
	}

	public int capacity() {
		return MAXSIZE;
	}
}
