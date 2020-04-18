/*
Copyright [2020] karthic.sdet.com
*/

package basic.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsUtilSorting {

	public static void main(String[] args) {

		List<Integer> intList = new ArrayList<Integer>() {
			{
				add(2);
				add(6);
				add(8);
				add(11);
				add(23);
				add(0);
				add(1);
				add(5);
				add(3);
				add(4);

			}
		};
		
		//different ways to static initialize an arraylist
		List<Integer> intlist2= new ArrayList<>(Arrays.asList(2,6,8,11,23,0,1,5,3,4));
		List<Integer> intlist3= new ArrayList<Integer>() {
			{
				addAll(intlist2);
			}
		};


		List<Employee> employees_Original;
		employees_Original = new ArrayList<Employee>(Arrays.asList( new Employee("karthic", 32), new Employee("kavitha", 29),
				new Employee("Tharunanth", 1), new Employee("Rakesh", 30), new Employee("Vivek", 34),
				new Employee("Dharshini", 8), new Employee("Soujanya", 5)));

		System.out.println("Int array sorting :");
		System.out.println("Before sorting:");
		printArray(intList);
		Collections.sort(intList);
		System.out.println("after sorting:");
		printArray(intList);

		
		System.out.println("Arraylist of Objects:"+employees_Original);
		
		
		System.out.println("--- sorting using custom comparable sorter -----");

		List<Employee> employees1= new ArrayList<Employee>(employees_Original); 
		
		System.out.println("Before sorting:");
		printArray(employees1);
		Collections.sort(employees1, new EmployeeComparator()); // using comparator
		System.out.println("After sorting:");
		printArray(employees1);

		System.out.println("--- sorting using comparable -----");
		List<Employee> employees2=  new ArrayList<Employee>(){{addAll(employees_Original);}};
		System.out.println("Before sorting:");
		printArray(employees2);
		Collections.sort(employees2);// using comparable
		System.out.println("After sorting:");
		printArray(employees2);

		System.out.println("--- reverse sorting using comparator -----");
		List<Employee>  employees3 = new ArrayList<>();
		employees3.addAll(employees_Original);
		System.out.println("Before sorting:");
		printArray(employees3);
		Collections.sort(employees3, new EmployeeReverseComparator());// using reverse comparator
		System.out.println("After sorting:");
		printArray(employees3);

		System.out.println("--- reverse sorting using comparable reverse Interface -----");
		List<Employee>  employees4 = new ArrayList<>(employees_Original);
		
		System.out.println("Before sorting:");
		printArray(employees4);
		Collections.sort(employees4, Comparator.reverseOrder());// using reverse comparator
		System.out.println("After sorting:");
		printArray(employees4);

	}

	static <T> void printArray(List<T> items) {
		for (T item : items) {
			System.out.print(item + "\t");
		}
		System.out.println();
	}

}
