/*
Copyright [2020] karthic.sdet.com
*/


package intermediate.datastructures;

import java.util.Iterator;

public class SingleLinkedListTest {

	public static void main(String[] args) {
		
		
		SingleLinkedListImpl<Integer> singleLinkedList= new SingleLinkedListImpl<>();
		
		singleLinkedList.add(10);
		singleLinkedList.add(20);
		singleLinkedList.display();
		singleLinkedList.add(30);
		singleLinkedList.add(40);
		singleLinkedList.add(50);
		
		singleLinkedList.display();
		
		printUsingIterator(singleLinkedList);
		
		
		singleLinkedList.add(60);
		singleLinkedList.add(70);
		singleLinkedList.add(80);
		singleLinkedList.add(90);
		singleLinkedList.display();
		printUsingIterator(singleLinkedList);
		
		singleLinkedList.replace(5, 55);
		singleLinkedList.display();
		singleLinkedList.replace(6, 65);
		singleLinkedList.replace(7, 75);
		singleLinkedList.display();
		singleLinkedList.replace(8, 85);
		singleLinkedList.replace(9, 95);
		singleLinkedList.display();
		printUsingIterator(singleLinkedList);
		
		singleLinkedList.remove(60);
		singleLinkedList.display();
		singleLinkedList.remove(70);
		singleLinkedList.remove(80);
		singleLinkedList.display();
		singleLinkedList.remove(90);
		singleLinkedList.display();
		printUsingIterator(singleLinkedList);
	}
	
	private static void printUsingIterator(SingleLinkedListImpl<Integer> singleLinkedList) {
	System.out.print("Iterator:[");
		for(Integer in:singleLinkedList) {
		System.out.print(in+"\t");
	}
		System.out.print("] \n");

	}
}
