/*
Copyright [2020] karthic.sdet.com
*/

package advanced.datastructures;

import java.util.Objects;

import advanced.datastructures.defns.BinaryTree;

public class BinaryTreeImpl {

	public static void main(String[] args) {
		BinaryTree<Integer> bTree = new MyBinaryTree<Integer>();
		bTree.add(8);
		bTree.add(9);
		bTree.add(1);
		bTree.add(4);
		bTree.add(2);
		bTree.add(6);
		bTree.add(5);
		bTree.add(7);
		bTree.add(3);

		System.out.println("Size:" + bTree.size());

		System.out.print("InOrder: ");
		bTree.inOrder();

		System.out.print("\nPreOrder: ");
		bTree.preOrder();

		System.out.print("\nPostOrder: ");
		bTree.postOrder();

		System.out.println();
		System.out.println("find(1):" + bTree.find(1));
		System.out.println("find(2):" + bTree.find(2));
		System.out.println("find(3):" + bTree.find(3));
		System.out.println("find(4):" + bTree.find(4));
		System.out.println("find(5):" + bTree.find(5));
		System.out.println("find(6):" + bTree.find(6));
		System.out.println("find(7):" + bTree.find(7));
		System.out.println("find(8):" + bTree.find(8));
		System.out.println("find(9):" + bTree.find(9));

		System.out.println("Max entry:" + bTree.findMax());
		System.out.println("Min entry:" + bTree.findMin());
		
		
		System.out.println("\n Delete 7:"+bTree.delete(7));
		bTree.inOrder();
		
		System.out.println("\n Delete 2:"+bTree.delete(2));
		bTree.inOrder();
		
		
		System.out.println("\n Delete 4:"+bTree.delete(4));
		bTree.inOrder();
		

	}

}

class MyBinaryTree<T extends Comparable<T>> implements BinaryTree<T> {

	Node<T> root;
	int size;

	@Override
	public boolean add(T elem) {
		Node<T> newNode = new Node<T>(elem);
		if (Objects.isNull(root)) {
			root = newNode;
			++size;
			return true;
		}

		else {
			Node<T> currentNode = root;
			Node<T> parentNode = root;

			while (true) {
				if (currentNode.getValue().compareTo(elem) > 0) {// elem is less than node
					parentNode = currentNode;
					currentNode = currentNode.leftChild;
					if (Objects.isNull(currentNode)) {
						parentNode.leftChild = newNode;
						++size;
						return true;
					}
				} else {
					parentNode = currentNode;
					currentNode = currentNode.rightChild;
					if (Objects.isNull(currentNode)) {
						parentNode.rightChild = newNode;
						++size;
						return true;
					}
				}
			}
		}

	}

	@Override
	public boolean find(T elem) {

		Node<T> currentNode = root;
		boolean flag = false;

		while (Objects.nonNull(currentNode)) {
			if (currentNode.getValue().compareTo(elem) == 0) {// elem found!!
				flag = true;
				break;

			} else if (currentNode.getValue().compareTo(elem) > 0) {
				currentNode = currentNode.leftChild;
			} else {
				currentNode = currentNode.rightChild;
			}
		}

		return flag;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public T findMax() {

		Node<T> currentNode = root;

		if (Objects.isNull(root.rightChild)) {
			return root.getValue();
		}

		while (Objects.nonNull(currentNode.rightChild)) {
			currentNode = currentNode.rightChild;
		}
		return currentNode.getValue();
	}

	@Override
	public T findMin() {

		Node<T> currentNode = root;

		if (Objects.isNull(root.leftChild)) {
			return root.getValue();
		}

		while (Objects.nonNull(currentNode.leftChild)) {
			currentNode = currentNode.leftChild;
		}
		return currentNode.getValue();
	}

	@Override
	public void preOrder() {
		preOrderTraversal(root);

	}

	@Override
	public void inOrder() {
		inOrderTraversal(root);

	}

	@Override
	public void postOrder() {
		postOrderTraversal(root);

	}

	private void inOrderTraversal(Node<T> rootNode) {

		if (Objects.nonNull(rootNode)) {
			inOrderTraversal(rootNode.leftChild);
			System.out.print(rootNode.getValue() + "\t");
			inOrderTraversal(rootNode.rightChild);
		}
	}

	private void preOrderTraversal(Node<T> rootNode) {
		if (Objects.nonNull(rootNode)) {
			System.out.print(rootNode.getValue() + "\t");
			preOrderTraversal(rootNode.leftChild);
			preOrderTraversal(rootNode.rightChild);
		}
	}

	private void postOrderTraversal(Node<T> rootNode) {
		if (Objects.nonNull(rootNode)) {
			postOrderTraversal(rootNode.leftChild);
			postOrderTraversal(rootNode.rightChild);
			System.out.print(rootNode.getValue() + "\t");
		}
	}

	@Override
	public T delete(T elem) {

		if (Objects.isNull(root.leftChild) && Objects.isNull(root.rightChild)) {
			root = null;
		} else {
			Node<T> parentNode = root;
			Node<T> currentNode = root;
			boolean found = false;
			boolean isRight=false;
			
			
			while (Objects.nonNull(currentNode)) {
				if (currentNode.getValue().compareTo(elem) == 0) {// elem found!!
					found = true;
					break;

				} else if (currentNode.getValue().compareTo(elem) > 0) {
					parentNode=currentNode;
					currentNode = currentNode.leftChild;
					isRight=false;
				} else {
					parentNode=currentNode;
					currentNode = currentNode.rightChild;
					isRight=true;
				}
			}
			if(!found) {
				System.out.println("Element not available for deletion");
				return null;
			}
			
			//if the node is the leaf node
			if(Objects.isNull(currentNode.leftChild) && Objects.isNull(currentNode.rightChild)) {
				if(isRight)
					parentNode.rightChild=null;
				else
					parentNode.leftChild=null;
			}
			//if the node has right child only
			else if(Objects.isNull(currentNode.leftChild) && Objects.nonNull(currentNode.rightChild)) {
				if(isRight) 
					parentNode.rightChild=currentNode.rightChild;
				else
					parentNode.leftChild=currentNode.rightChild;
			}
			//if the node has left child only
			else if(Objects.isNull(currentNode.rightChild) && Objects.nonNull(currentNode.leftChild)) {
				if(isRight) 
					parentNode.rightChild=currentNode.leftChild;
				else
					parentNode.leftChild=currentNode.leftChild;
			}
			else if(Objects.nonNull(currentNode.rightChild) && Objects.nonNull(currentNode.leftChild)) {
				Node<T> successor=findSuccessor(currentNode);
				if(isRight) 
					parentNode.rightChild=successor;
				else
					parentNode.leftChild=successor;
				
				
				successor.leftChild=currentNode.leftChild;				
			}
			
			return currentNode.getValue();
		}

		return null;
	}

	private Node<T> findSuccessor(Node<T> delNode) {
		
		Node<T> current=delNode;
		Node<T> previous=delNode;
		
		Node<T> successor=current.rightChild;
		while(Objects.nonNull(successor)) {
			previous=successor;
			successor=successor.leftChild;
			if(Objects.isNull(successor.leftChild)) {
				
				//if successor is not the right node of the delNode, 
				//then attach the right node of successor to its parent leftNode
				if(successor.getValue().compareTo(delNode.rightChild.getValue())!=0) {
					previous.leftChild=successor.rightChild;
					successor.rightChild=delNode.rightChild;
				}
				
				break;
			}
			
			
			
		}
		return successor;
	}

}
