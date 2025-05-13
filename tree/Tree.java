package tree;


/* Class Node */
class Node {
	Node left, right;
	int data;

	/* Constructor */
	public Node(int n) {
		left = null;
		right = null;
		data = n;
	}

}

class Tree {

	private Node root;

	/* Constructor */
	public Tree() {
		root = null;
	}

	/* Functions to insert data */
	public void insert(int data) {

		root = insert(root, data);
	}

	/* Function to insert data recursively */
	private Node insert(Node node, int data) {
		if (node == null)
			node = new Node(data);
		else {

			if (data <= node.data)

				node.left = insert(node.left, data);
			else
				node.right = insert(node.right, data);
		}

		return node;
	}

	/* Function for inorder traversal */
	public void inorder() {
		inorder(root);
	}

	private void inorder(Node r) {
		if (r != null) {
			inorder(r.left);
			System.out.print(r.data + " ");
			inorder(r.right);
		}
	}

	/* Function for preorder traversal */
	public void preorder() {
		preorder(root);
	}

	private void preorder(Node r) {
		if (r != null) {	
			System.out.print(r.data + " ");
			preorder(r.left);
			preorder(r.right);
		}
	}

	/* Function for postorder traversal */
	public void postorder() {
		postorder(root);
	}

	private void postorder(Node r) {
		if (r != null) {
			postorder(r.left);
			postorder(r.right);
			System.out.print(r.data + " ");
		}
	}

	public void delete(int key) {
		Node current = root;
		Node parent = null;
		boolean isLeftChild = false;

		// Find the node to be deleted
		while (current != null && current.data != key) {
			parent = current;

			if (key < current.data) {
				current = current.left;
				isLeftChild = true;
			} else {
				current = current.right;
				isLeftChild = false;
			}
		}

		// Node not found
		if (current == null) {
			return;
		}

		// Case 1: Node to be deleted has no children
		if (current.left == null && current.right == null) {
			if (current == root) {
				root = null;
			} else if (isLeftChild) {
				parent.left = null;
			} else {
				parent.right = null;
			}
		}

		// Case 2: Node to be deleted has only one child
		else if (current.right == null) {
			if (current == root) {
				root = current.left;
			} else if (isLeftChild) {
				parent.left = current.left;
			} else {
				parent.right = current.left;
			}
		} else if (current.left == null) {
			if (current == root) {
				root = current.right;
			} else if (isLeftChild) {
				parent.left = current.right;
			} else {
				parent.right = current.right;
			}
		}

		// Case 3: Node to be deleted has two children
		else {
			Node successor = getSuccessor(current);

			// Connect parent of current to successor instead
			if (current == root) {
				root = successor;
			} else if (isLeftChild) {
				parent.left = successor;
			} else {
				parent.right = successor;
			}

			// Connect successor to current's left child
			successor.left = current.left;
		}
	}

	Node getSuccessor(Node node) {
		Node parent = node;
		Node successor = node;
		Node current = node.right;

		while (current != null) {
			parent = successor;
			successor = current;
			current = current.left;
		}

		// If successor is not the right child, move the subtree
		if (successor != node.right) {
			parent.left = successor.right;
			successor.right = node.right;
		}

		return successor;
	}
}