package me.example.threads.methods;

class MyThread extends Thread {

	public MyThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		System.out.println("in : " + getName());
		try {
			// static methods

			Thread.yield(); // yields current state and release resources for
			// other threads.
			Thread.sleep(500000000); // sleeps for ms, does not release
			// resources while sleeping.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		super.run();
	}
}

public class ThreadMethodsDemo {

	public static void main(String[] args) {
		Thread t1 = new MyThread("t1");
		Thread t2 = new MyThread("t2");
		Thread t3 = new MyThread("t3");
		t1.start();
		/*
		 * try { t1.join(); // joins main thread statements } catch
		 * (InterruptedException e) { e.printStackTrace(); }
		 */ t2.start(); // separate thread stack
		t3.start(); // main method stack

	}

}
