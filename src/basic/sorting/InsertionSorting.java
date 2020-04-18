/*
Copyright [2020] karthic.sdet.com
*/


package basic.sorting;

public class InsertionSorting {

	public static void main(String[] args) {
		
		InsertionSorter<Integer> insertSortInt;
		InsertionSorter<Employee> insertSortObj;
		
		Integer[] intArr = new Integer[] { 2, 6, 8, 11, 23, 0, 1, 5, 3, 4 };

		Employee[] empArr = new Employee[] { new Employee("karthic", 32), new Employee("kavitha", 29),
				new Employee("Tharunanth", 1), new Employee("Rakesh", 30), new Employee("Vivek", 34),
				new Employee("Dharshini", 8), new Employee("Soujanya", 5) };
		
		
		insertSortInt= new InsertionSorter(intArr);
		System.out.println("Sorting Integer Array--- Ascending");
		System.out.println("Before Sorting");
		printArray(intArr);
		insertSortInt.ascendingSort();
		System.out.println("After Sorting");
		printArray(intArr);
		System.out.println("Sorting Integer Array--- Descending");
		insertSortInt.descendingSort();
		System.out.println("After Sorting");
		printArray(intArr);
		
		
		insertSortInt= new InsertionSorter(empArr);
		System.out.println("Sorting Employee Array---- Ascending");
		System.out.println("Before Sorting");
		printArray(empArr);
		insertSortInt.descendingSort();
		System.out.println("After Sorting");
		System.out.println("Sorting Employee Array--- Descending");
		insertSortInt.descendingSort();
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
	
	
class InsertionSorter<T extends Comparable>{
	
	T[] items;

	InsertionSorter(T[] items) {
		this.items = items;
	}

	void ascendingSort() {

		int size = items.length;

		for (int i = 1; i < size; i++) {
			int in = i;
			T temp=items[i];
			while(in>0 && (items[in-1].compareTo(temp) > 0)){
				items[in]=items[in-1];
				in--;
				}
			items[in]=temp;
			}
			
		}
	
	void descendingSort() {

		int size = items.length;

		for (int i = 1; i < size; i++) {
			int in = i;
			T temp=items[i];
			while(in>0 && (items[in-1].compareTo(temp) < 0)){
				items[in]=items[in-1];
				in--;
				}
			items[in]=temp;
			}
			
	}
	

		}
