package me.example.threads.interuption;

class TestInterruptingThread3 extends Thread {

	public void run() {
		// Thread is not interrupted, only flag is set
		for (int i = 1; i <= 5; i++)
			System.out.println(i);
	}

}

class TestInterruptingThread2 extends Thread {

	public void run() {
		try {
			Thread.sleep(10000);
			for (int i = 1; i <= 5; i++)
				System.out.println(i);
		} catch (InterruptedException e) {
			// handle interruption.
			e.printStackTrace();
		}
	}
}

class TestInterruptingThread1 extends Thread {

	public void run() {
		try {
			Thread.sleep(10000);
			for (int i = 1; i <= 5; i++)
				System.out.println(i);
		} catch (InterruptedException e) {
			throw new RuntimeException("interuppted in case of sleep and wait state " + e);
		}
	}
}

public class ThreadInteruptionDemo {
	public static void main(String args[]) {
		TestInterruptingThread3 t3 = new TestInterruptingThread3();
		t3.start();
		t3.interrupt();

		TestInterruptingThread2 t2 = new TestInterruptingThread2();
		t2.start();
		t2.interrupt();
	}

}
