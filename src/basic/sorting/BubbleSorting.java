/*
Copyright [2020] karthic.sdet.com
*/

package basic.sorting;

import java.util.Arrays;
import java.util.Comparator;

public class BubbleSorting {

	public static void main(String[] args) {
		BubbleSortInt bubbleSort = new BubbleSortInt(new int[] { 2, 6, 8, 11, 23, 0, 1, 5, 3, 4 });
		bubbleSort.printItems();
		bubbleSort.sort();
		bubbleSort.printItems();

		
		System.out.println("--- sorting using custom comparable sorter -----");
		Student[] students_Original;
		students_Original = new Student[] { new Student("karthic", 32), new Student("kavitha", 29), new Student("Tharunanth", 1),
				new Student("Rakesh", 30), new Student("Vivek", 34), new Student("Dharshini", 8),
				new Student("Soujanya", 5) };

		
		Student[] students1=new Student[students_Original.length];
				System.arraycopy(students_Original, 0, students1, 0, students_Original.length);
		BubbleSortObj<Student> sortObj = new BubbleSortObj<Student>(students1);
		sortObj.printItems();
		sortObj.customComparableSort();
		sortObj.printItems();
		
		
		System.out.println("--- sorting using Arrays util -----");
		Student[] students2=new Student[students_Original.length];
		System.arraycopy(students_Original, 0, students2, 0, students_Original.length);
		sortObj = new BubbleSortObj<Student>(students2);
		sortObj.printItems();
		sortObj.customComparableSort();
		sortObj.printItems();

	}
}

class BubbleSortInt {

	int[] items;

	BubbleSortInt(int[] items) {
		this.items = items;
	}

	void printItems() {
		for (int item : items) {
			System.out.print(item + "\t");

		}
		System.out.println("\n");
	}

	void sort() {
		int size = items.length;
		System.out.println("size= " + size);

		for (int i = size - 2; i > 0; i--) {

			for (int j = 0; j <= i; j++) {

				if (items[j + 1] < items[j]) {
					swap(j + 1, j);
				}
			}

		}
	}

	void swap(int index1, int index2) {
		int temp = items[index1];
		items[index1] = items[index2];
		items[index2] = temp;
	}

}

class BubbleSortObj<T extends Comparable> {

	T[] items;

	BubbleSortObj(T[] items) {
		this.items = items;
	}

	void printItems() {
		for (T item : items) {
			System.out.print(item + "\t");

		}
		System.out.println("\n");
	}

	void customComparableSort() {
		int size = items.length;
		System.out.println("size= " + size);

		for (int i = size - 2; i > 0; i--) {

			for (int j = 0; j <= i; j++) {

				if (items[j + 1].compareTo(items[j]) < 0) {
					swap(j + 1, j);
				}
			}

		}
	}

	void arraySortComparable(T[] items) {
		Arrays.sort(items);
	}

	void swap(int index1, int index2) {
		T temp = items[index1];
		items[index1] = items[index2];
		items[index2] = temp;
	}

}

class Student implements Comparable<Student> {

	private String name;
	int age;

	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Student obj) {
		int temp = this.age - obj.age;
		return (temp < 0 ? -1 : (temp > 0) ? 1 : 0);
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}

}

class StudentComparator implements Comparator<Student> {
	@Override
	public int compare(Student o1, Student o2) {
		int temp = o1.age - o2.age;
		return (temp < 0 ? -1 : (temp > 0) ? 1 : 0);
	}

}