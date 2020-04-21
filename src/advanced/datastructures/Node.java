/*
Copyright [2020] karthic.sdet.com
*/


package advanced.datastructures;

public class Node<T extends Comparable<T>> {

	private T value;
	public Node<T> leftChild;
	public Node<T> rightChild;
	
	public Node(T value) {
		this.value=value;
	}

	public T getValue() {
		return value;
	}

}
