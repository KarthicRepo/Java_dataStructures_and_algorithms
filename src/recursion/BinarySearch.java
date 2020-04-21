/*
Copyright [2020] karthic.sdet.com
*/


package recursion;

public class BinarySearch {

	static int[] array;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		array= new int[]{3,5,7,8,9,10,12,14,15,16,20,24,28,30};
		int found=binarySearch(7,0,array.length);
		if(found >=0) {
			System.out.println("successfully found the element at index:"+found);
		}

	}
	
	static int binarySearch(int elem,int lower,int upper) {
		
		int mid=(lower+upper)/2;
		if(array[mid]==elem) 
			return mid;
		if(lower>upper)
			return -1;
		if(elem<array[mid])
			return binarySearch(elem, lower, mid-1);
		else {
			 return binarySearch(elem, mid+1, upper);
		}
			
	}

}
