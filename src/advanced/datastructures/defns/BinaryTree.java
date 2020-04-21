/*
Copyright [2020] karthic.sdet.com
*/


package advanced.datastructures.defns;

public interface BinaryTree<T> {
	
	boolean add(T elem);
	boolean find(T elem);
	T delete(T elem);
	void preOrder();
	void inOrder();
	void postOrder();
	int size();
	T findMax();
	T findMin();
	
}
