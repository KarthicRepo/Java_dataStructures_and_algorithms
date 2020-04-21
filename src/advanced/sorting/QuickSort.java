/*
Copyright [2020] karthic.sdet.com
*/

package advanced.sorting;

public class QuickSort {

	private static int[] array;

	public static void main(String[] args) {
		
		array= new int[]{9,7,1,2,6,8,10,5,4,3,0};
		printArray(array);
		sort(0, array.length-1);
		printArray(array);
	}

	private static void sort(int left, int right) {

		if(right - left <=0)
			return;
		
		int partition=partition(left, right, array[right]);
		sort(left,partition-1);
		
		sort(partition+1,right);
	}

	private static int partition(int left, int right, int pivot) {

		int rightPtr = right;
		int leftPtr = left - 1;

		while (true) {

			while (array[++leftPtr] < pivot) {
				
			}
			while (rightPtr>0 && array[--rightPtr] > pivot) {
				
			}

			if (leftPtr >= rightPtr)
				break;

			swap(leftPtr, rightPtr);

		}
		swap(leftPtr, right);
		return leftPtr;
	}

	private static void swap(int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
	
	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + "\t");
		System.out.println();
	}


}
