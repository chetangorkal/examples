package me.example.concurrency.bean;

import java.util.concurrent.Semaphore;

public class MySemaphore {
	static Semaphore semaphore = new Semaphore(3);

	public static void doSomething() {
		try {
			semaphore.acquire();
			// critical section
			for (int i = 1; i <= 30; i++) {
				System.out.println(Thread.currentThread().getName() + " :: " + i);
				Thread.sleep(1000);
			}
			semaphore.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
