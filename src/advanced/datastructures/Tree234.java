/*
Copyright [2020] karthic.sdet.com
*/

package advanced.datastructures;

import java.lang.reflect.Array;
import java.util.Objects;

public class Tree234 {

	public static void main(String[] args) {
		
		Tree234Impl<Integer> tree234= new Tree234Impl<>();	
		tree234.insert(50);
		tree234.insert(10);
		tree234.insert(60);
		tree234.insert(20);
		tree234.insert(70);
		tree234.insert(30);
		tree234.insert(90);
		tree234.insert(80);
		
		tree234.displayTree();

	}

}

class Tree234Impl<E extends Comparable<E>> {
	
	private Tree_Node<E> root;
	
	Tree234Impl() {
		
		System.out.println("initilized the constructor");
		root=new Tree_Node<E>();
		
	}

	public int find(E key) {
		Tree_Node<E> curNode = root;
		int childNumber;
		while (true) {
			if ((childNumber = curNode.findItem(key)) != -1)
				return childNumber; // found it
			else if (curNode.isLeaf())
				return -1; // can’t find it
			else // search deeper
				curNode = getNextChild(curNode, key);
		}
	}

	public Tree_Node<E> getNextChild(Tree_Node<E> theNode, E theValue) {
		int j;
		// assumes node is not empty, not full, not a leaf
		int numItems = theNode.getNumItems();
		for (j = 0; j < numItems; j++) // for each item in node
		{ // are we less?
			if (theValue.compareTo(theNode.getItem(j).data) < 0)
				return theNode.getChild(j); // return left child
		} // end for // we’re greater, so
		return theNode.getChild(j); // return right child
	}

	public void insert(E dValue) {
		Tree_Node<E> curNode = root;
		DataItem<E> tempItem = new DataItem<E>(dValue);
		while (true) {
			if (curNode.isFull()) // if node full,
			{
				split(curNode); // split it
				curNode = curNode.getParent(); // back up
				// search once
				curNode = getNextChild(curNode, dValue);
			} // end if(node is full)
			else if (curNode.isLeaf()) // if node is leaf,
				break; // go insert
			// node is not full, not a leaf; so go to lower level
			else
				curNode = getNextChild(curNode, dValue);
		} // end while
		curNode.insertItem(tempItem); // insert new DataItem
	} // end insert()

	public void split(Tree_Node<E> thisNode) // split the node
	{
		// assumes node is full
		DataItem<E> itemB, itemC;
		Tree_Node<E> parent, child2, child3;
		int itemIndex;
		itemC = thisNode.removeLargestItem();
		itemB = thisNode.removeLargestItem();
		child2 = thisNode.disConnectChild(2);
		child3 = thisNode.disConnectChild(3);
		Tree_Node<E> newRight = new Tree_Node<>(); // make new node for right side
		if (thisNode == root) // if this is the root,
		{
			root = new Tree_Node<>(); // make new root node
			parent = root; // root is our parent
			root.connectChild(0, thisNode); // connect to parent
		} else // this node not the root
			parent = thisNode.getParent(); // get parent
		// deal with parent
		itemIndex = parent.insertItem(itemB); // item B to parent
		int n = parent.getNumItems(); // total items?
		for (int j = n - 1; j > itemIndex; j--) // move parent’s
		{ // connections
			Tree_Node<E> temp = parent.disConnectChild(j); // one child
			parent.connectChild(j + 1, temp); // to the right
		}
		// connect newRight to parent
		parent.connectChild(itemIndex + 1, newRight);
		// deal with newRight
		newRight.insertItem(itemC); // item C to newRight
		newRight.connectChild(0, child2); // connect to 0 and 1
		newRight.connectChild(1, child3); // on newRight
	} // end split()

	public void displayTree() {
		displayTree(root, 0, 0);
	}

	private void displayTree(Tree_Node<E> thisNode, int level, int childNumber) {
		System.out.print("level=" + level + " child=" + childNumber + "");
		thisNode.displayNode(); // display this node
		// call ourselves for each child of this node
		int numItems = thisNode.getNumItems();
		for (int j = 0; j < numItems + 1; j++) {
			Tree_Node<E> nextNode = thisNode.getChild(j);
			if (nextNode != null)
				displayTree(nextNode, level + 1, j);
			else
				return;
		}
	} 
}

class DataItem<E> {

	E data;

	DataItem(E data) {
		this.data = data;
	}

	public void displayItem() {
		System.out.print("/" + data);
	}
}

class Tree_Node<E extends Comparable<E>> {

	public static final int ORDER = 4;

	private DataItem<E>[] items;
	private Tree_Node<E>[] childArray;
	private Tree_Node<E> parent;
	private int itemCount;

	Tree_Node() {
		items = (DataItem<E>[]) Array.newInstance(DataItem.class, ORDER - 1);
		childArray = (Tree_Node<E>[]) Array.newInstance(Tree_Node.class, ORDER);
	}

	public void connectChild(int childNum, Tree_Node<E> childNode) {

		if (Objects.nonNull(childNode)) {
			childArray[childNum] = childNode;
			childNode.parent = this;
		}
	}

	public Tree_Node<E> disConnectChild(int childNum) {
		Tree_Node<E> temp = childArray[childNum];
		childArray[childNum] = null;
		return temp;
	}

	public Tree_Node<E> getChild(int childNum) {
		return childArray[childNum];
	}

	public Tree_Node<E> getParent() {
		return parent;
	}

	public boolean isLeaf() {
		return (childArray[0] == null) ? true : false;
	}

	public int getNumItems() {
		return itemCount;
	}

	public DataItem<E> getItem(int index) // get DataItem at index
	{
		return items[index];
	}

	public boolean isFull() {
		return (itemCount == ORDER - 1) ? true : false;
	}

	public int findItem(E key) // return index of
	{ // item (within node)
		for (int j = 0; j < ORDER - 1; j++) // if found,
		{ // otherwise,
			if (items[j] == null) // return -1
				break;
			else if (items[j].data.compareTo(key) == 0)
				return j; // found at this index
		}
		return -1;
	}

	public int insertItem(DataItem<E> newItem) {
		// assumes node is not full
		itemCount++;
		E newKey = newItem.data; // key of new item
		for (int j = ORDER - 2; j >= 0; j--) // start on right,
		{
			if (items[j] == null) // if the item null,
				continue; // go left one cell
			else // not null,
			{
				E itsKey = items[j].data;
				if (newKey.compareTo(itsKey) < 0) // if it’s bigger
					items[j + 1] = items[j]; // shift it right
				else {
					items[j + 1] = newItem; // insert new item
					return j + 1; // return the index
				}
			}
		} // end for // shifted all items,
		items[0] = newItem; // insert new item

		return 0;
	}

	public DataItem<E> removeLargestItem() {
		DataItem<E> temp = items[itemCount - 1];
		items[itemCount - 1] = null;
		itemCount--;
		return temp;
	}

	public void displayNode() {
		for (int j = 0; j < itemCount; j++)
			items[j].displayItem();
		System.out.println();
	}
	

}
