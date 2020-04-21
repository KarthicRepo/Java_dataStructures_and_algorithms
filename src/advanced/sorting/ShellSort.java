/*
Copyright [2020] karthic.sdet.com
*/

package advanced.sorting;

public class ShellSort {

	public static void main(String args[]) {
		int array[] = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		System.out.println("Before sorting");
		printArray(array);

		new ShellSort().sort(array);

		System.out.println("After sorting");
		printArray(array);
	}

	private void sort(int arr[]) {
		int n = arr.length;

		for (int gap = n / 2; gap > 0; gap /= 2) {

			for (int i = gap; i < n; i += 1) {
				for (int k = i - gap; k >= 0; k = k - gap) {

					if (arr[k + gap] >= arr[k])
						break;

					int temp = arr[k];
					arr[k] = arr[k + gap];
					arr[k + gap] = temp;

				}

			}
		}
	}

	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + "\t");
		System.out.println();
	}

}
