/*
Copyright [2020] karthic.sdet.com
*/


package recursion;

public class WordAnagram {

	static char[] word;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		word="cat".toCharArray();
		
		new WordAnagram().anagramFinder(word.length);

	}
	
	public void anagramFinder(int size) {
		
		if(size==1)
			return;
		
		for(int i=0;i<size;i++) {
			anagramFinder(size-1);
			
			if(size==2) 
				display();
			
			rotate(size);
		}
	}

	private void rotate(int subSize) {
		int index=word.length-subSize;
		int i=0;
		char temp=word[index];
		for(i=index;i<word.length-1;i++) {
			word[i]=word[i+1];
		}
		word[i]=temp;
	}

	private void display() {
		for(char ch:word) {
			System.out.print(ch);
		}
		System.out.println();
		
	}

}
