/*
Copyright [2020] karthic.sdet.com
*/


package basic.datastructures.defns;

public interface Stack<T> {
	
	boolean push(T element);
	T pop();
	T peek();
	boolean isEmpty();
	boolean isFull();
	void printStack();
}
