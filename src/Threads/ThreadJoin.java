package Threads;

import java.util.concurrent.TimeUnit;

public class ThreadJoin {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		Thread t1= new Thread(new MyRunnable2());
		Thread t2= new Thread(new MyRunnable2());
		
		
		t1.start();
		t2.start();
		

		 t1.join(); 
		 t2.join();
		 System.out.println("=====================================================");
		 
		 Thread t3= new Thread(new MyRunnable2());
		 Thread t4= new Thread(new MyRunnable2() {
			 
			 @Override
			 public void run() {
				 try {
					t3.join();// this thread t4 will join the t3, so will not be run till t3 completes
					super.run();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }
		 });
		 
		 System.out.println("starting t3");
		 t3.start();
		 System.out.println("starting t4");
		 t4.start();
		 
		 t4.join();// main thread will join the t4, below statement will not be executed till the t4 thread is complete
		 
		
		System.out.println("ending main thread");
		
		

	}

}

class MyRunnable2 implements Runnable{

	@Override
	public void run() {
		
		for(int i=0;i<100;i++) {
		System.out.println(Thread.currentThread().getName()+"--> "+i);	
		
		}
	}
}
