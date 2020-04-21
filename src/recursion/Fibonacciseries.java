/*
Copyright [2020] karthic.sdet.com
*/


package recursion;

public class Fibonacciseries {

	static int num1=0;
	static int num2=1; 
	static int num3=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.print(num1+"\t"+num2+"\t");
		fibsequence(20);

	}
	
	static void fibsequence(int count) {
		if(count>0) {
			num3=num1+num2;
			num1=num2;
			num2=num3;
			
			System.out.print(num3+"\t");
			fibsequence(count-1);
			
		}
		
	}

}
