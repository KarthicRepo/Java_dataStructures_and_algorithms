/*
Copyright [2020] karthic.sdet.com
*/

package basic.sorting;

public class SelectionSort {

	public static void main(String[] args) {
		
		SelectionSortObj<Employee> selSort;
		SelectionSortObj<Integer>  selSortInt;
		
		Integer[] intArr = new Integer[] { 2, 6, 8, 11, 23, 0, 1, 5, 3, 4 };

		Employee[] empArr = new Employee[] { new Employee("karthic", 32), new Employee("kavitha", 29),
				new Employee("Tharunanth", 1), new Employee("Rakesh", 30), new Employee("Vivek", 34),
				new Employee("Dharshini", 8), new Employee("Soujanya", 5) };

		selSortInt= new SelectionSortObj(intArr);
		System.out.println("Sorting Integer Array--- Ascending");
		System.out.println("Before Sorting");
		printArray(intArr);
		selSortInt.ascendingSort();
		System.out.println("After Sorting");
		printArray(intArr);
		System.out.println("Sorting Integer Array--- Descending");
		selSortInt.descendingSort();
		System.out.println("After Sorting");
		printArray(intArr);
		
		
		selSort= new SelectionSortObj(empArr);
		System.out.println("Sorting Employee Array---- Ascending");
		System.out.println("Before Sorting");
		printArray(empArr);
		selSort.descendingSort();
		System.out.println("After Sorting");
		System.out.println("Sorting Employee Array--- Descending");
		selSort.descendingSort();
		System.out.println("After Sorting");
		printArray(empArr);

	}

	static <T> void printArray(T[] items) {
		for (T item : items) {
			System.out.print(item + "\t");
		}
		System.out.println();
	}

}

class SelectionSortObj<T extends Comparable> {

	T[] items;

	SelectionSortObj(T[] items) {
		this.items = items;
	}

	void ascendingSort() {

		int size = items.length;

		for (int i = 0; i <= size - 1; i++) {
			int min = i;
			for (int j = i + 1; j < size; j++) {
				if (items[min].compareTo(items[j]) > 0) {
					min = j;
				}
			}
			swap(min, i);
		}
	}
	
	void descendingSort() {

		int size = items.length;

		for (int i = 0; i < size; i++) {
			int min = i;
			for (int j = i + 1; j < size; j++) {
				if (items[min].compareTo(items[j]) < 0) {
					min = j;
				}
			}
			swap(min, i);
		}
	}
	

	void swap(int index1, int index2) {
		T temp = items[index1];
		items[index1] = items[index2];
		items[index2] = temp;
	}

}
