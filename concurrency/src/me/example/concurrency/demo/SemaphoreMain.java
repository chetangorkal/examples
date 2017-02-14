package me.example.concurrency.demo;

import me.example.concurrency.bean.SemaphoreThread;

public class SemaphoreMain {
	public static void main(String[] args) {
		Thread myThread = new SemaphoreThread();
		Thread myThread1 = new SemaphoreThread();
		Thread myThread2 = new SemaphoreThread();
		Thread myThread3 = new SemaphoreThread();
		Thread myThread4 = new SemaphoreThread();
		Thread myThread5 = new SemaphoreThread();
		Thread myThread6 = new SemaphoreThread();
		Thread myThread7 = new SemaphoreThread();
		Thread myThread8 = new SemaphoreThread();
		myThread.start();
		myThread1.start();
		myThread2.start();
		myThread3.start();
		myThread4.start();
		myThread5.start();
		myThread6.start();
		myThread7.start();
		myThread8.start();
	}
}
