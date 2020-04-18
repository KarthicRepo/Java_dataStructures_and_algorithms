/*
Copyright [2020] karthic.sdet.com
*/

package intermediate.datastructures;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

import intermediate.datastructures.defns.SingleLinkedList;

public class SingleLinkedListImpl<T extends Comparable<T>> implements SingleLinkedList<T>, Iterable<T> {

	Node<T> head;
	int count;

	@Override
	public int add(T element) {
		if (Objects.isNull(head)) {
			head = new Node<T>(element);
		} else {
			head = new Node<T>(element, head);
		}
		count++;
		return 0;
	}

	@Override
	public T get(int index) {
		return getNodeAt(index).getData();
	}

	@Override
	public T remove(T element) {
		int elem_position = getIndex(element);
		if (elem_position == -1)
			return null;

		count--;
		return removeNodeAt(elem_position);
	}

	@Override
	public T replace(int index, T element) {

		if (index >= count)
			return null;

		Node<T> previous = getNodeAt(index - 1);
		T tempData = previous.next.getData();

		Node<T> newNode = new Node<T>(element);
		Node<T> next = previous.next.next;

		previous.next = newNode;
		newNode.next = next;

		return tempData;
	}

	@Override
	public void display() {
		Node<T> temp = head;
		System.out.print("[");
		for (int i = 0; i < count; i++) {

			System.out.print(temp.getData() + "\t");
			temp = temp.next;
		}
		System.out.println("]\n");
	}

	private int getIndex(T element) {
		Node<T> temp = head;
		for (int i = 0; i < count; i++) {
			if (temp.getData().compareTo(element) == 0) {
				return i;
			}
			temp = temp.next;
		}
		return -1;
	}

	private T removeNodeAt(int index) {
		if (index == 0) {
			T tempData = head.getData();
			head = head.next;
			return tempData;
		}

		Node<T> previous = getNodeAt(index - 1);
		Node<T> remove = previous.next;
		previous.next = remove.next;
		return remove.getData();
	}

	private Node<T> getNodeAt(int index) {

		Node<T> current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current;
	}
	
	@Override
	public Iterator<T> iterator() {

		// anonymous class implementation. we can separate this as a private inner class
		// also.
		return new Iterator<T>() {

			Node<T> current = head;

			@Override
			public boolean hasNext() {

				return Objects.nonNull(current);
			}

			@Override
			public T next() {

				if (Objects.isNull(current))
					throw new NoSuchElementException("Linked list is empty");
				T data = current.getData();
				current = current.next;
				return data;
			}

		};
	}

}
