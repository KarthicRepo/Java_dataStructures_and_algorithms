/*
Copyright [2020] karthic.sdet.com
*/

/*
 * Used the geeksforgeeks code sample and implemented the Generics on top of that.
 * So any Comparable objects can be used in this AVL tree.
 */

package advanced.datastructures;

import java.util.Objects;

public class AVLtree {

	public static void main(String[] args) {
		AVLTreeImpl<Integer> avltree= new AVLTreeImpl<>();
		avltree.root=avltree.insert(50);
		avltree.root=avltree.insert(10);
		avltree.root=avltree.insert(70);
		avltree.root=avltree.insert(23);
		avltree.root=avltree.insert(45);
		avltree.root=avltree.insert(20);
		avltree.root=avltree.insert(18);
		avltree.root=avltree.insert(55);
		avltree.root=avltree.insert(58);
		avltree.root=avltree.insert(60);
		avltree.root=avltree.insert(65);
		avltree.root=avltree.insert(80);
		avltree.root=avltree.insert(90);
		avltree.root=avltree.insert(85);
		avltree.root=avltree.insert(95);
		avltree.root=avltree.insert(100);
		
		System.out.println("InOrder:");
		avltree.inOrder(avltree.root);
		
		
		avltree.root=avltree.deleteNode(95);
		avltree.root=avltree.deleteNode(55);
		avltree.root=avltree.deleteNode(50);
		avltree.root=avltree.deleteNode(23);
		avltree.root=avltree.deleteNode(85);
		
		System.out.println("\nAfter Deletion of (95,55,50,23,85)");
		avltree.inOrder(avltree.root);
		

	}

}

class AVLTreeImpl<E extends Comparable<E>> {

	private class AVLNode<E> {
		private AVLNode<E> left;
		private AVLNode<E> right;
		private int height = 1;// default initial height
		private E value;

		private AVLNode(E value) {
			this.value = value;
		}
	}
	
	AVLNode<E> root;

	private int height(AVLNode<E> node) {
		if (Objects.isNull(node))
			return 0;
		return node.height;
	}
	
	public AVLNode<E> insert(E value){
		if(Objects.isNull(root)) {
			root=new AVLNode<>(value);
			return root;
		}
		return insert(root, value);
	}

	private AVLNode<E> insert(AVLNode<E> node, E value) {
		/* 1. Perform the normal BST rotation */
		if (Objects.isNull(node)) {
			return (new AVLNode<E>(value));
		}

		if (value.compareTo(node.value) < 0)
			node.left = insert(node.left, value);
		else
			node.right = insert(node.right, value);

		/* 2. Update height of this ancestor node */
		node.height = Math.max(height(node.left), height(node.right)) + 1;

		/*
		 * 3. Get the balance factor of this ancestor node to check whether this node
		 * became unbalanced
		 */
		int balance = getBalance(node);

		// If this node becomes unbalanced, then there are 4 cases

		// Left Left Case
		if (balance > 1 && value.compareTo(node.left.value)<0)
			return rightRotate(node);

		// Right Right Case
		if (balance < -1 && value.compareTo(node.right.value)>0)
			return leftRotate(node);

		// Left Right Case
		if (balance > 1 && value.compareTo(node.left.value)<0) {
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}

		// Right Left Case
		if (balance < -1 && value.compareTo(node.right.value)>0) {
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}

		/* return the (unchanged) node pointer */
		return node;
	}

	private AVLNode<E> rightRotate(AVLNode<E> y) {
		AVLNode<E> x = y.left;
		AVLNode<E> T2 = x.right;

		// Perform rotation
		x.right = y;
		y.left = T2;

		// Update heights
		y.height = Math.max(height(y.left), height(y.right)) + 1;
		x.height = Math.max(height(x.left), height(x.right)) + 1;

		// Return new root
		return x;
	}

	private AVLNode<E> leftRotate(AVLNode<E> x) {
		AVLNode<E> y = x.right;
		AVLNode<E> T2 = y.left;

		// Perform rotation
		y.left = x;
		x.right = T2;

		// Update heights
		x.height = Math.max(height(x.left), height(x.right)) + 1;
		y.height = Math.max(height(y.left), height(y.right)) + 1;

		// Return new root
		return y;
	}

	// Get Balance factor of node N
	private int getBalance(AVLNode<E> N) {
		if (N == null)
			return 0;
		return height(N.left) - height(N.right);
	}

	public void preOrder(AVLNode<E> root) {
		if (root != null) {
			System.out.printf("%d ", root.value);
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	
	public void inOrder(AVLNode<E> root) {
		if (root != null) {
			inOrder(root.left);
			System.out.printf("%d ", root.value);
			inOrder(root.right);
		}
	}
	
	public void postOrder(AVLNode<E> root) {
		if (root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.printf("%d ", root.value);
		}
	}

	private AVLNode<E> minValueNode(AVLNode<E> node) {
		AVLNode<E> current = node;
		/* loop down to find the leftmost leaf */
		while (current.left != null)
			current = current.left;
		return current;
	}
	
	public AVLNode<E> deleteNode(E value){
		return deleteNode(root,value);
	}

	private AVLNode<E> deleteNode(AVLNode<E> root, E value) {
		// STEP 1: PERFORM STANDARD BST DELETE

		if (root == null)
			return root;

		// If the value to be deleted is smaller than the root's value,
		// then it lies in left subtree
		if (value.compareTo(root.value) < 0)
			root.left = deleteNode(root.left, value);

		// If the value to be deleted is greater than the root's value,
		// then it lies in right subtree
		else if (value.compareTo(root.value) > 0)
			root.right = deleteNode(root.right, value);

		// if value is same as root's value, then This is the node
		// to be deleted
		else {
			// node with only one child or no child
			if ((root.left == null) || (root.right == null)) {

				AVLNode<E> temp;
				if (root.left != null)
					temp = root.left;
				else
					temp = root.right;

				// No child case
				if (temp == null) {
					temp = root;
					root = null;
				} else // One child case
					root = temp; // Copy the contents of the non-empty child

				temp = null;
			} else {
				// node with two children: Get the inorder successor (smallest
				// in the right subtree)
				AVLNode<E> temp = minValueNode(root.right);

				// Copy the inorder successor's data to this node
				root.value = temp.value;

				// Delete the inorder successor
				root.right = deleteNode(root.right, temp.value);
			}
		}

		// If the tree had only one node then return
		if (root == null)
			return root;

		// STEP 2: UPDATE HEIGHT OF THE CURRENT NODE
		root.height = Math.max(height(root.left), height(root.right)) + 1;

		// STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether
		// this node became unbalanced)
		int balance = getBalance(root);

		// If this node becomes unbalanced, then there are 4 cases

		// Left Left Case
		if (balance > 1 && getBalance(root.left) >= 0)
			return rightRotate(root);

		// Left Right Case
		if (balance > 1 && getBalance(root.left) < 0) {
			root.left = leftRotate(root.left);
			return rightRotate(root);
		}

		// Right Right Case
		if (balance < -1 && getBalance(root.right) <= 0)
			return leftRotate(root);

		// Right Left Case
		if (balance < -1 && getBalance(root.right) > 0) {
			root.right = rightRotate(root.right);
			return leftRotate(root);
		}

		return root;
	}


}
