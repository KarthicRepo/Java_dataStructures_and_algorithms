package Threads;

public class ThreadLearning {

	public static void main(String[] args) throws InterruptedException {

		new Thread(new MyRunnable()).start();

		
		Thread t= new Thread(() -> {
			System.out.println("Java 8 lambda exprssion thread Implentation");
		});
		
		t.start();
		t.join();
		
		System.out.println("Main thread end");

	}

}

class MyRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("Im implemented by Runnable");
	}

}
