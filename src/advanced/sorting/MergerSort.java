/*
Copyright [2020] karthic.sdet.com
*/

package advanced.sorting;

public class MergerSort {

	static int[] array = {2,1,5,3,4,9,8,5,6,10,20,11,23,12,19,15};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printArray();
		new MergerSort().mergeSort(array, 0, array.length - 1);
		printArray();
	}
	
	private static void printArray() {
		for(int i:array) {
			System.out.print(i+"\t");
		}
		System.out.println();
	}

	public void mergeSort(int[] arr, int low, int high) {

		if (low < high) {
			int mid = (low + high) / 2;

			mergeSort(arr, low, mid);
			mergeSort(arr, mid + 1, high);
			merge(arr, low, mid, high);

		}

	}

	public void merge(int[] arr,int low, int mid, int high) {
		
		int leftSize=mid-low+1;
		int rightSize=high-mid;
		
		int[] leftArr=new int[leftSize];
		int[] rightArr=new int[rightSize];
		
		for(int i=0;i<leftSize;++i) {
			leftArr[i]=array[low+i];
		}
		
		for(int i=0;i<rightSize;++i) {
			rightArr[i]=array[(mid+1)+i];
		}
		
		
		int i = 0;
		int j = 0;
		int k = low;
		
		while(i < leftSize && j < rightSize) {
			if (leftArr[i] <= rightArr[j]) {
				arr[k] = leftArr[i];
				i++;
			} else {
				arr[k] = rightArr[j];
				j++;
			}
			k++;
		}
		

//		for (; lowptr <= mid && highptr <= high;) {
//			if (array[lowptr] <= array[highptr]) {
//				copy[k] = array[lowptr];
//				lowptr++;
//			} else {
//				copy[k] = array[highptr];
//				highptr++;
//			}
//			k++;
//		}

		while (i < leftSize) {
			arr[k] = leftArr[i];
			k++;i++;
		}

		while (j < rightSize) {
			arr[k] = rightArr[j];
			k++;j++;
		}

	}

}
