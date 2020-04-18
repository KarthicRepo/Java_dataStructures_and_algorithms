/*
Copyright [2020] karthic.sdet.com
*/

package basic.datastructures;

import java.lang.reflect.Array;
import java.util.Comparator;

import basic.datastructures.defns.Stack;

public class ArrayStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Stack<Integer> myStack = new MyStack(Integer.class, 10);
		myStack.push(2);
		myStack.push(6);
		myStack.push(8);
		myStack.push(11);
		myStack.push(23);
		myStack.push(0);
		myStack.push(1);
		myStack.push(5);
		myStack.push(3);
		myStack.push(4);
		myStack.push(10);
		myStack.push(20);
		
		myStack.printStack();
		
		System.out.println("peek():"+ myStack.peek());
		System.out.println("peek():"+ myStack.peek());
		
		System.out.println("pop():"+ myStack.pop());
		System.out.println("pop():"+ myStack.pop());
		System.out.println("pop():"+ myStack.pop());
		
		myStack.printStack();
		myStack.push(50);
		myStack.push(60);
		myStack.push(70);
		myStack.printStack();
		

		Stack<Employee> myStack2 = new MyStack(Employee.class, 5);
		
		myStack2.push(new Employee("karthic", 32));
		myStack2.push(new Employee("kavitha", 29));
		myStack2.push(new Employee("Tharunanth", 1));
		myStack2.push(new Employee("Rakesh", 30));
		myStack2.push(new Employee("Vivek", 34));
		myStack2.push(new Employee("Soujanya", 5));
		myStack2.push(new Employee("Dharshini", 8));
		
		myStack2.printStack();
		
		System.out.println("peek():"+ myStack2.peek());
		System.out.println("peek():"+ myStack2.peek());
		
		System.out.println("pop():"+ myStack2.pop());
		System.out.println("pop():"+ myStack2.pop());
		System.out.println("pop():"+ myStack2.pop());
		
		myStack2.printStack();
		myStack2.push(new Employee("Soujanya", 5));
		myStack2.push(new Employee("Dharshini", 8));
		myStack2.printStack();
		
		
		
	}

}

class MyStack<T extends Comparable> implements Stack<T> {

	private int size;
	private T[] container;
	private int items_count;
	private int index =-1;

	MyStack(Class<T> type, int size) {
		this.size = size;
		this.container = (T[]) Array.newInstance(type, size);
	}

	@Override
	public boolean push(T element) {

		if (isFull())
			return false;

		container[++index] = element;
		items_count++;
		return true;
	}

	@Override
	public T pop() {
		if (isEmpty())
			return null;

		items_count--;
		return container[index--];
	}

	@Override
	public boolean isEmpty() {
		
		return (items_count==0 && index==-1);
	}

	@Override
	public boolean isFull() {
		
		return (size == index+1 && size == items_count);
	}

	@Override
	public T peek() {
		
		if(isEmpty())
			return null;
		return container[index];
	}

	@Override
	public void printStack() {
		int count=1;
		for(T item:container) {
			System.out.print(item+"\t");
			
			if(++count > this.items_count) break;
		}
		System.out.println();
	}

}


class Employee implements Comparable<Employee> {

	private String name;
	int age;

	public Employee(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Employee obj) {
		int temp = this.age - obj.age;
		return (temp < 0 ? -1 : (temp > 0) ? 1 : 0);
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + "]";
	}

}


