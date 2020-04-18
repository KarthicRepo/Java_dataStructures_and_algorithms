/*
Copyright [2020] karthic.sdet.com
*/

package intermediate.datastructures;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;

import intermediate.datastructures.defns.DoubleLinkedList;

public class DoubleLinkedListImpl<T extends Comparable<T>> implements DoubleLinkedList<T>, Iterable<T> {

	Node<T> head;
	Node<T> tail;
	int count;

	@Override
	public boolean addFirst(T element) {
		Node<T> newNode = new Node<T>(element);
		if (Objects.isNull(head)) {
			head = newNode;
			tail = newNode;

		} else {
			head.previous = newNode;
			newNode.next = head;
			head = newNode;
		}
		count++;
		return true;
	}

	@Override
	public boolean addLast(T element) {
		Node<T> newNode = new Node<T>(element);
		if (Objects.isNull(tail)) {
			tail = newNode;
			head = newNode;

		} else {
			tail.next = newNode;
			newNode.previous = tail;
			tail = newNode;
		}
		count++;
		return true;
	}

	@Override
	public T removeFirst() {

		if (Objects.isNull(head))
			return null;

		T headData = head.getData();
		head = head.next;

		count--;
		return headData;
	}

	@Override
	public T removeLast() {
		if (Objects.isNull(tail))
			return null;

		T tailData = tail.getData();
		tail = tail.previous;
		tail.next = null;

		count--;
		return tailData;
	}

	@Override
	public T getFirst() {
		if (Objects.isNull(head))
			return null;
		return head.getData();
	}

	@Override
	public T getLast() {
		if (Objects.isNull(tail))
			return null;
		return tail.getData();
	}

	@Override
	public T peek() {
		return getFirst();
	}

	@Override
	public boolean add(int index, T element) {
		Node<T> newNode = new Node<T>(element);

		if (index < 0)
			throw new IndexOutOfBoundsException("index cannot be negative");

		if (index == 0) {
			return addFirst(element);
		}

		Node<T> nodeAtIndex = getNodeAtIndex(index);
		Node<T> previousNode = nodeAtIndex.previous;
		Node<T> nextNode = nodeAtIndex.next;

		newNode.next = nextNode;
		newNode.previous = previousNode;
		previousNode.next = newNode;
		nextNode.previous = newNode;
		count++;
		return true;
	}

	@Override
	public T get(int index) {
		return getNodeAtIndex(index).getData();
	}

	@Override
	public boolean remove(T element) {

		int elementIndex = findIndexOfElement(element);

		if (elementIndex == -1)
			throw new NoSuchElementException("the given element does not exist in the linked list");
		if (elementIndex == 0) {
			removeFirst();
		}

		Node<T> currentNode = getNodeAtIndex(elementIndex);
		Node<T> previousNode = currentNode.previous;
		Node<T> nextNode = currentNode.next;

		previousNode.next = nextNode;
		nextNode.previous = previousNode;

		count--;
		return true;
	}

	@Override
	public int size() {
		return count;
	}

	private Node<T> getNodeAtIndex(int index) {
		Node<T> temp = head;
		for (int i = 1; Objects.nonNull(temp.next) && i <= index; i++) {
			temp = temp.next;
		}
		return temp;
	}

	private int findIndexOfElement(T element) {
		Node<T> temp = head;
		int i = 0;
		for (; Objects.nonNull(temp.next); i++) {
			temp = temp.next;
			if (temp.getData().compareTo(element) == 0)
				return i;
		}
		return -1;
	}

	@Override
	public Iterator<T> iterator() {

		return new LinkedListIterator<T>();
	}

	class LinkedListIterator<T> implements ListIterator<T> {

		Node<T> current = (Node<T>) head;
		int index = 0;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return Objects.nonNull(current);
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			
			if (Objects.isNull(current))
				throw new NoSuchElementException("Linked list is empty");
			
			T data= current.getData();
			current=current.next;
			index++;
			return data;
		}

		@Override
		public boolean hasPrevious() {
			// TODO Auto-generated method stub
			return Objects.nonNull(current.previous);
		}

		@Override
		public T previous() {
			// TODO Auto-generated method stub
			index--;
			return current.previous.getData();
		}

		@Override
		public int nextIndex() {
			// TODO Auto-generated method stub
			return (index + 1);
		}

		@Override
		public int previousIndex() {
			// TODO Auto-generated method stub
			return (index - 1);
		}

		@Override
		public void remove() {
			removeFirst();

		}

		@Override
		public void set(T e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void add(T e) {
			// TODO Auto-generated method stub
		}

	}

}
