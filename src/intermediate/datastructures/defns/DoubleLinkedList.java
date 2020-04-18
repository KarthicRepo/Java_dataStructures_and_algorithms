/*
Copyright [2020] karthic.sdet.com
*/


package intermediate.datastructures.defns;

public interface DoubleLinkedList<T> {
	
	boolean addFirst(T element);
	boolean addLast(T element);
	boolean add(int index, T element);
	T removeFirst();
	T removeLast();
	T getFirst();
	T getLast();
	T get(int index);
	boolean remove(T element);
	T peek();
	int size();
}
