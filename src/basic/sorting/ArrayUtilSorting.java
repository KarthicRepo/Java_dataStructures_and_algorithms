/*
Copyright [2020] karthic.sdet.com
*/

package basic.sorting;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayUtilSorting {

	public static void main(String[] args) {

		Integer[] intarray = new Integer[] { 2, 6, 8, 11, 23, 0, 1, 5, 3, 4 };

		
		Employee[] employees_Original;
		employees_Original = new Employee[] { new Employee("karthic", 32), new Employee("kavitha", 29),
				new Employee("Tharunanth", 1), new Employee("Rakesh", 30), new Employee("Vivek", 34),
				new Employee("Dharshini", 8), new Employee("Soujanya", 5) };
	
		
		
		System.out.println("Int array sorting :");
		System.out.println("Before sorting:");
		printArray(intarray);
		Arrays.sort(intarray);
		System.out.println("after sorting:");
		printArray(intarray);
		
		System.out.println("--- sorting using custom comparable sorter -----");
		
		Employee[] employees1=new Employee[employees_Original.length];
		System.arraycopy(employees_Original, 0, employees1, 0, employees_Original.length);
		System.out.println("Before sorting:");
		printArray(employees1);
		Arrays.sort(employees1,new EmployeeComparator()); // using comparator
		System.out.println("After sorting:");
		printArray(employees1);
		
		System.out.println("--- sorting using comparable -----");
		Employee[] employees2=new Employee[employees_Original.length];
		System.arraycopy(employees_Original, 0, employees2, 0, employees_Original.length);
		System.out.println("Before sorting:");
		printArray(employees2);
		Arrays.sort(employees2);// using comparable
		System.out.println("After sorting:");
		printArray(employees2);
		
		
		System.out.println("--- reverse sorting using comparator -----");
		Employee[] employees3=new Employee[employees_Original.length];
		System.arraycopy(employees_Original, 0, employees3, 0, employees_Original.length);
		System.out.println("Before sorting:");
		printArray(employees3);
		Arrays.sort(employees3,new EmployeeReverseComparator());// using reverse comparator
		System.out.println("After sorting:");
		printArray(employees3);
		
		
		System.out.println("--- reverse sorting using comparable reverse Interface -----");
		Employee[] employees4=new Employee[employees_Original.length];
		System.arraycopy(employees_Original, 0, employees4, 0, employees_Original.length);
		System.out.println("Before sorting:");
		printArray(employees4);
		Arrays.sort(employees4,Comparator.reverseOrder());// using reverse comparator
		System.out.println("After sorting:");
		printArray(employees4);
		
				
	}
	
	static <T> void  printArray(T[] items){
		for(T item:items) {
			System.out.print(item+"\t");
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

class EmployeeComparator implements Comparator<Employee> {
	@Override
	public int compare(Employee o1, Employee o2) {
		int temp = o1.age - o2.age;
		return (temp < 0 ? -1 : (temp > 0) ? 1 : 0);
	}
}

	class EmployeeReverseComparator implements Comparator<Employee> {
		@Override
		public int compare(Employee o1, Employee o2) {
			int temp = o1.age - o2.age;
			return (temp < 0 ? 1 : (temp > 0) ? -1 : 0);
		}
}
