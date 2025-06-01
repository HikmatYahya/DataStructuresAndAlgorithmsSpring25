package tree;

import java.util.LinkedList;
import java.util.Queue;

class BSTNode {

	int value;
	BSTNode left, right;

	public BSTNode(int value) {
		this.value = value;
		this.left = this.right = null;

	}
}

public class BST {

	BSTNode root;

	public void insertIterative(int value) {

		BSTNode newNode = new BSTNode(value);

		if (root == null) {
			root = newNode;
			return;
		}
		BSTNode current = root, parent = null;

		while (current != null) {
			parent = current;

			if (value < current.value) {
				current = current.left;
			} else {
				current = current.right;
			}
		}

		if (value < parent.value) {
			parent.left = newNode;
		} else {
			parent.right = newNode;
		}
	}

	public boolean searchIterative(int value) {
		BSTNode current = root;

		while (current != null) {
			if (value == current.value) {
				return true;
			} else if (value < current.value) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		return false;
	}

	// Recursive insert
	public BSTNode insertRecursive(BSTNode node, int value) {
		if (node == null) {
			return new BSTNode(value);
		}
		if (value < node.value) {
			node.left = insertRecursive(node.left, value);
		} else {
			node.right = insertRecursive(node.right, value);
		}
		return node;
	}

	// Recursive search
	public boolean searchRecursive(BSTNode node, int value) {
		if (node == null)
			return false;
		if (value == node.value)
			return true;
		if (value < node.value) {
			return searchRecursive(node.left, value);
		} else {
			return searchRecursive(node.right, value);
		}
	}

	// In-order traversal
	public void inOrderTraversal(BSTNode node) {
		if (node == null)
			return;

		inOrderTraversal(node.left);
		System.out.print(node.value + " ");
		inOrderTraversal(node.right);
	}

	// Pre-order traversal
	public void preOrderTraversal(BSTNode node) {
		if (node == null)
			return;
		System.out.print(node.value + " ");
		preOrderTraversal(node.left);
		preOrderTraversal(node.right);
	}

	// Post-order traversal
	public void postOrderTraversal(BSTNode node) {
		if (node == null)
			return;
		postOrderTraversal(node.left);
		postOrderTraversal(node.right);
		System.out.print(node.value + " ");
	}

	// Breadth-first traversal
	public void breadthFirstTraversal() {
		if (root == null)
			return;

		Queue<BSTNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			BSTNode current = queue.poll();
			System.out.print(current.value + " ");

			if (current.left != null) {
				queue.add(current.left);
			}
			if (current.right != null) {
				queue.add(current.right);
			}
		}
	}
}
