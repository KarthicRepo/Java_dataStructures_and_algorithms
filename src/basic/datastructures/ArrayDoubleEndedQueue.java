/*
Copyright [2020] karthic.sdet.com
*/

package basic.datastructures;

import java.lang.reflect.Array;
import basic.datastructures.defns.DoubleEndedQueue;

public class ArrayDoubleEndedQueue {

	public static void main(String[] args) {

		DoubleEndedQueue<Integer> myQueue= new DoubleEndQueue(Integer.class, 10);
		myQueue.addFirst(5);
		myQueue.addLast(10);
		myQueue.addFirst(15);
		
		myQueue.printQueue();
		
		myQueue.addLast(20);
		myQueue.addFirst(25);
		myQueue.addLast(30);
		
		myQueue.printQueue();
		
		System.out.println("peekFirst():"+myQueue.peekFirst());
		System.out.println("peekLast():"+myQueue.peekLast());
		
		myQueue.addFirst(40);
		myQueue.addLast(50);
		myQueue.addFirst(55);
		
		myQueue.printQueue();
		
		System.out.println("peekFirst():"+myQueue.peekFirst());
		System.out.println("peekLast():"+myQueue.peekLast());
		myQueue.addLast(60);
		myQueue.addFirst(65);
		myQueue.addLast(70);
		
		myQueue.printQueue();
		
		System.out.println("peekFirst():"+myQueue.peekFirst());
		System.out.println("peekLast():"+myQueue.peekLast());
		myQueue.addLast(75);
		myQueue.addFirst(80);
		myQueue.addLast(85);
		
		myQueue.printQueue();
		System.out.println("peekFirst():"+myQueue.peekFirst());
		System.out.println("peekLast():"+myQueue.peekLast());
		
		
		myQueue.removeFirst();
		myQueue.removeLast();
		myQueue.printQueue();
		System.out.println("peekFirst():"+myQueue.peekFirst());
		System.out.println("peekLast():"+myQueue.peekLast());
		myQueue.printQueue();
		
		myQueue.removeFirst();
		myQueue.removeLast();
		myQueue.printQueue();
		System.out.println("peekFirst():"+myQueue.peekFirst());
		System.out.println("peekLast():"+myQueue.peekLast());
		myQueue.printQueue();
		
		myQueue.removeFirst();
		myQueue.removeLast();
		myQueue.printQueue();
		System.out.println("peekFirst():"+myQueue.peekFirst());
		System.out.println("peekLast():"+myQueue.peekLast());
		myQueue.printQueue();
		
		myQueue.removeFirst();
		myQueue.removeLast();
		myQueue.printQueue();
		System.out.println("peekFirst():"+myQueue.peekFirst());
		System.out.println("peekLast():"+myQueue.peekLast());
		myQueue.printQueue();
		
		myQueue.removeFirst();
		myQueue.removeLast();
		myQueue.printQueue();
		System.out.println("peekFirst():"+myQueue.peekFirst());
		System.out.println("peekLast():"+myQueue.peekLast());
		myQueue.printQueue();
		
		myQueue.removeFirst();
		myQueue.removeLast();
		myQueue.printQueue();
		System.out.println("peekFirst():"+myQueue.peekFirst());
		System.out.println("peekLast():"+myQueue.peekLast());
		myQueue.printQueue();
		
		myQueue.removeFirst();
		myQueue.removeLast();
		myQueue.printQueue();
		System.out.println("peekFirst():"+myQueue.peekFirst());
		System.out.println("peekLast():"+myQueue.peekLast());
		myQueue.printQueue();
		
		
		
		
		DoubleEndedQueue myQueue2= new DoubleEndQueue(Employee.class, 5);
		
		myQueue2.addFirst(new Employee("karthic", 32));
		myQueue2.addLast(new Employee("kavitha", 29));
		myQueue2.addFirst(new Employee("Tharunanth", 1));
		myQueue2.printQueue();
		System.out.println("peekFirst():"+myQueue2.peekFirst());
		System.out.println("peekLast():"+myQueue2.peekLast());
		
		myQueue2.addFirst(new Employee("Rakesh", 30));
		myQueue2.addLast(new Employee("Vivek", 34));
		System.out.println("peekFirst():"+myQueue2.peekFirst());
		System.out.println("peekLast():"+myQueue2.peekLast());
		myQueue2.printQueue();
		
		myQueue2.printQueue();
		System.out.println("peekFirst():"+myQueue2.peekFirst());
		System.out.println("peekLast():"+myQueue2.peekLast());
		myQueue2.addFirst(new Employee("Soujanya", 5));
		myQueue2.addLast(new Employee("Dharshini", 8));
		System.out.println("peekFirst():"+myQueue2.peekFirst());
		System.out.println("peekLast():"+myQueue2.peekLast());
		myQueue2.printQueue();
		
		
		
		myQueue2.removeFirst();
		myQueue2.printQueue();
		myQueue2.removeLast();
		System.out.println("peekFirst():"+myQueue2.peekFirst());
		System.out.println("peekLast():"+myQueue2.peekLast());
		
		myQueue2.removeFirst();
		myQueue2.printQueue();
		myQueue2.removeLast();
		System.out.println("peekFirst():"+myQueue2.peekFirst());
		System.out.println("peekLast():"+myQueue2.peekLast());
		
		myQueue2.removeFirst();
		myQueue2.printQueue();
		myQueue2.removeLast();
		System.out.println("peekFirst():"+myQueue2.peekFirst());
		System.out.println("peekLast():"+myQueue2.peekLast());
		
		myQueue2.removeFirst();
		myQueue2.printQueue();
		myQueue2.removeLast();
		System.out.println("peekFirst():"+myQueue2.peekFirst());
		System.out.println("peekLast():"+myQueue2.peekLast());
		
		myQueue2.removeFirst();
		myQueue2.printQueue();
		myQueue2.removeLast();
		System.out.println("peekFirst():"+myQueue2.peekFirst());
		System.out.println("peekLast():"+myQueue2.peekLast());
		
		
	}
	
}

class DoubleEndQueue<T> implements DoubleEndedQueue<T> {

	T[] container;
	int size;
	int item_count;
	int index = -1;

	DoubleEndQueue(Class<?> type, int size) {
		this.size = size;
		container = (T[]) Array.newInstance(type, size);
	}

	@Override
	public boolean addFirst(T element) {

		if (isFull())
			return false;
		
		if(isEmpty()) {
			container[0] = element;
		}
		else {
			shiftRightAndInsertAtFront(element);
		}

		index++;
		item_count++;
		return true;
	}

	

	@Override
	public boolean addLast(T element) {
		if (isFull())
			return false;

		container[++index] = element;
		item_count++;
		return true;
	}

	@Override
	public T peekFirst() {

		if (isEmpty())
			return null;

		return container[0];
	}

	@Override
	public T peekLast() {
		if (isEmpty())
			return null;

		return container[index];
	}

	@Override
	public T removeFirst() {
		if(isEmpty()) return null;
		
		item_count--;
		index--;
		return shiftLeftAndDeleteAtFront();
		
	}

	@Override
	public T removeLast() {
		if(isEmpty()) return null;
		
		item_count--;
		return container[index--];
	}

	@Override
	public boolean isFull() {
		return (item_count == size);
	}

	@Override
	public boolean isEmpty() {

		return (item_count == 0);
	}

	@Override
	public void printQueue() {
		
		int count=0;
		System.out.print("[");
		
		for(T item: container) {
			
			if( item_count ==0) {
				System.out.print("] \n");
				
				return;
			}
			
			System.out.print(item+"\t");
			
			if(++count == item_count) break;
			
		}
		
		System.out.print("]");
		System.out.println();
	}
	
	

private void shiftRightAndInsertAtFront(T element) {
		
		for(int i=item_count;i>=0;i--) {
			container[i+1]=container[i];
		}
		container[0]=element;
		
	}

private <T> T shiftLeftAndDeleteAtFront() {
	T temp=(T) container[0];
	for(int i=0;i<=item_count-1;i++) {
		container[i]=container[i+1];
	}
	return temp;
	
}
	
}
