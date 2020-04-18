/*
Copyright [2020] karthic.sdet.com
*/

package basic.datastructures;

import java.lang.reflect.Array;
import basic.datastructures.defns.Queue;

public class ArrayQueue {
	
	public static void main(String[] args) {
		
		Queue myQueue= new MyQueue(Integer.class, 10);
		myQueue.enqueue(5);
		myQueue.enqueue(10);
		myQueue.enqueue(15);
		myQueue.enqueue(20);
		myQueue.enqueue(25);
		myQueue.enqueue(30);
		
		myQueue.printQueue();
		
		System.out.println("peek():"+myQueue.peek());
		
		myQueue.enqueue(40);
		myQueue.enqueue(50);
		myQueue.enqueue(60);
		myQueue.enqueue(70);
		myQueue.printQueue();
		System.out.println("peek():"+myQueue.peek());
		myQueue.enqueue(80);
		myQueue.enqueue(90);
		System.out.println("peek():"+myQueue.peek());
		myQueue.enqueue(100);
		myQueue.enqueue(200);
		System.out.println("peek():"+myQueue.peek());
		
		myQueue.printQueue();
		
		myQueue.dequeue();
		myQueue.printQueue();
		System.out.println("peek():"+myQueue.peek());
		myQueue.dequeue();
		myQueue.dequeue();
		myQueue.dequeue();
		myQueue.printQueue();
		System.out.println("peek():"+myQueue.peek());
		myQueue.dequeue();
		myQueue.dequeue();
		myQueue.dequeue();
		myQueue.printQueue();
		myQueue.dequeue();
		myQueue.printQueue();
		myQueue.dequeue();
		myQueue.printQueue();
		myQueue.dequeue();
		myQueue.printQueue();
		System.out.println("peek():"+myQueue.peek());
		myQueue.dequeue();
		myQueue.dequeue();
		myQueue.printQueue();
		System.out.println("peek():"+myQueue.peek());
		
		
		
		Queue myQueue2= new MyQueue(Employee.class, 5);
		
		myQueue2.enqueue(new Employee("karthic", 32));
		myQueue2.enqueue(new Employee("kavitha", 29));
		myQueue2.enqueue(new Employee("Tharunanth", 1));
		myQueue2.printQueue();
		System.out.println("peek():"+myQueue2.peek());
		myQueue2.enqueue(new Employee("Rakesh", 30));
		myQueue2.enqueue(new Employee("Vivek", 34));
		System.out.println("peek():"+myQueue2.peek());
		myQueue2.printQueue();
		System.out.println("peek():"+myQueue2.peek());
		myQueue2.enqueue(new Employee("Soujanya", 5));
		myQueue2.enqueue(new Employee("Dharshini", 8));
		System.out.println("peek():"+myQueue2.peek());
		myQueue2.printQueue();
		
		
		
		myQueue2.dequeue();
		myQueue2.printQueue();
		System.out.println("peek():"+myQueue.peek());
		myQueue2.dequeue();
		myQueue2.dequeue();
		myQueue2.dequeue();
		myQueue2.printQueue();
		System.out.println("peek():"+myQueue.peek());
		myQueue2.printQueue();
		myQueue2.dequeue();
		myQueue2.dequeue();
		myQueue2.printQueue();
		System.out.println("peek():"+myQueue.peek());
		
		
		
	}

}


class MyQueue<T> implements Queue<T>{
	
	T[] container;
	int size;
	int item_count;
	int index=-1;
	
	MyQueue(Class<?> type, int size){
		this.size=size;
		container= (T[]) Array.newInstance(type, size);
	}

	@Override
	public boolean enqueue(T element) {
		
		if(isFull()) return false;
		if(item_count==0) {
			container[0]=element; 
		}
		else {
		shiftRightElements();
		container[0]=element;
		}
		item_count++;
		index++;
		
		return true;
	}

	@Override
	public T dequeue() {
		if(isEmpty()) return null;
		
		item_count--;
		return container[index--];
	}

	@Override
	public boolean isFull() {
		return (size==item_count);
	}

	@Override
	public boolean isEmpty() {
		return (index==-1);
	}
	
	private void shiftRightElements() {
		for(int i=index+1;i>0;i--) {
			container[i]=container[i-1];
		}
	}
	
	@Override
	public T peek() {
		if(isEmpty()) return null;
		
		return container[index];
	}

	@Override
	public void printQueue() {
		int count=0;
		System.out.print("==>[");
		for(T item: container) {
			if(count++ >=item_count) break;
			System.out.print(item+"\t");
			
		}
		System.out.print("]\n");
	}

	
	
	
}
