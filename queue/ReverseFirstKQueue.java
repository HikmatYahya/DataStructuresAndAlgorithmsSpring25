package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseFirstKQueue {
    public static void main(String[] args) {
        // Input
        int size = 5; // Queue size
        int k = 3;    // Number of elements to reverse
        int[] elements = {1, 2, 3, 4, 5};

        // Initialize the queue
        
        
        Queue<Integer> queue = new LinkedList<>();
        for (int element : elements) {
            queue.add(element);
        }
        // Reverse the first K elements
        queue = reverseFirstKElements(queue, k);

        // Output the result
        System.out.print("Output: ");
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
    }

    public static Queue<Integer> reverseFirstKElements(Queue<Integer> queue, int k) {
        Stack<Integer> stack = new Stack<>();

        // Step 1: Push the first K elements into the stack
        for (int i = 0; i < k; i++) {
            stack.push(queue.poll());
        }

        // Step 2: Enqueue elements from the stack back to the queue
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        // Step 3: Move the remaining elements to the back of the queue
        int size = queue.size();
        for (int i = 0; i < size - k; i++) {
            queue.add(queue.poll());
        }

        return queue; // 3 2 1 4 5
    }
}
