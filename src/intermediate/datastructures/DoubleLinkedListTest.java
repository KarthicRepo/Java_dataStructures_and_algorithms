/*
Copyright [2020] karthic.sdet.com
*/


package intermediate.datastructures;

public class DoubleLinkedListTest {

	public static void main(String[] args) {
		DoubleLinkedListImpl<Integer> doubleLinkedList= new DoubleLinkedListImpl<>();
		doubleLinkedList.addFirst(10);
		doubleLinkedList.addFirst(20);
		printLinkedList(doubleLinkedList);
		
		doubleLinkedList.addLast(30);
		doubleLinkedList.addLast(40);
		doubleLinkedList.addFirst(50);
		printLinkedList(doubleLinkedList);
		
		doubleLinkedList.addFirst(60);
		doubleLinkedList.addLast(70);
		doubleLinkedList.addLast(80);
		printLinkedList(doubleLinkedList);
		
		doubleLinkedList.addFirst(90);
		doubleLinkedList.addLast(100);
		doubleLinkedList.addLast(200);
		printLinkedList(doubleLinkedList);
		
		for(int i=0;i<doubleLinkedList.size();i++)
		System.out.print(doubleLinkedList.get(i)+"\t");
		
		doubleLinkedList.removeFirst();
		doubleLinkedList.removeLast();
		printLinkedList(doubleLinkedList);
		
		doubleLinkedList.removeFirst();
		doubleLinkedList.removeLast();
		printLinkedList(doubleLinkedList);
		
		doubleLinkedList.removeFirst();
		doubleLinkedList.removeLast();
		printLinkedList(doubleLinkedList);
		
		doubleLinkedList.removeFirst();
		doubleLinkedList.removeLast();
		printLinkedList(doubleLinkedList);
		
		doubleLinkedList.removeFirst();
		doubleLinkedList.removeLast();
		printLinkedList(doubleLinkedList);
		
		doubleLinkedList.removeFirst();
		doubleLinkedList.removeLast();
		printLinkedList(doubleLinkedList);
		
		doubleLinkedList.removeFirst();
		doubleLinkedList.removeLast();
		printLinkedList(doubleLinkedList);

	}
	
	static void printLinkedList(DoubleLinkedListImpl<Integer> list) {
		
		System.out.print("Iterator:[");
		for(Integer in:list) {
		System.out.print(in+"\t");
	}
		System.out.print("] \n");

	}

}
