/*
Copyright [2020] karthic.sdet.com
*/


package intermediate.datastructures.defns;

import intermediate.datastructures.Node;

public interface SingleLinkedList<T> {
	
	int add(T element);
	T get(int index);
	T remove(T element);
	T replace(int index, T element);
	void display();
}
