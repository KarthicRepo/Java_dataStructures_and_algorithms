/*
Copyright [2020] karthic.sdet.com
*/


package basic.datastructures.defns;

public interface Queue<T> {

	boolean enqueue(T element);
	T dequeue();
	boolean isFull();
	boolean isEmpty();
	void printQueue();
	T peek();
	
	}
