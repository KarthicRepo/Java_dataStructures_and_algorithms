/*
Copyright [2020] karthic.sdet.com
*/


package intermediate.datastructures;

public class Node<E> {

	private E data;
	Node<E> next;
	Node<E> previous;
	
	
	public Node(E data) {
		this.data=data;
		next=null;
	}
	
	public Node(E data, Node<E> oldHead) {
		this.data=data;
		next=oldHead;
	}
	
	public E getData() {
		return data;
	}
}
