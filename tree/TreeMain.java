package tree;

import java.util.Scanner;

public class TreeMain {

	// TODO Auto-generated method stub\

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		/* Creating object of BST */
		Tree bst = new Tree();
		System.out.println("Linked List Binary Search Tree Test\n");
		char ch;
		/* Accept input */
		do {
			System.out.println("Enter integer element to insert");
			bst.insert(scan.nextInt());

			/* Display tree */
			System.out.print("\nPost order : ");
			bst.postorder();
			System.out.print("\nPre order : ");
			bst.preorder();
			System.out.print("\nIn order : ");
			bst.inorder();

			System.out.println("\nDo you want to continue (Type y or n) \n");
			ch = scan.next().charAt(0);
		} while (ch == 'Y' || ch == 'y');

	}

}
