package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BalancedParentheses {
	public static void main(String[] args) {
		String input = "{[()]}";

		if (isValid(input)) {
			System.out.println("Valid");
		} else {
			System.out.println("Invalid");
		}

	}

	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();

		for (char c : s.toCharArray()) { // or you can use for with charAt(index or i)
			// Push open brackets onto the stack
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			}

			else {
				// If stack is empty, it is invalid
				if (stack.isEmpty()) {
					return false;
				}

				// Check if the top of the stack matches the closing bracket
				char top = stack.pop();

				if ((c == ')' && top != '(') || 
					(c == '}' && top != '{') || 
					(c == ']' && top != '[')) {
					return false;
				}
			}
			
			
			
		}

		// If the stack is empty, the string is valid
		return stack.isEmpty();
	}
}
