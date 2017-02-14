package me.example.concurrency.bean;

public class SemaphoreThread extends Thread {

	@Override
	public void run() {
		MySemaphore.doSomething();
	}

}
