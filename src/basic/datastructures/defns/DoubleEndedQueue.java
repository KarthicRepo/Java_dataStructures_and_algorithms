/*
Copyright [2020] karthic.sdet.com
*/


package basic.datastructures.defns;

public interface DoubleEndedQueue<T> {
	
	boolean addFirst(T element);
	boolean addLast(T element);
	T peekFirst();
	T peekLast();
	T removeFirst();
	T removeLast();
	boolean isFull();
	boolean isEmpty();
	void printQueue();
}
