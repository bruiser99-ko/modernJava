package thisisjava.chapter12.ex04;

public class Ex04 {
	public static void main(String[] args) {
		WorkObject sharedObject = new WorkObject();
		
		Thread threadA = new ThreadA(sharedObject);
		Thread threadB = new ThreadB(sharedObject);
		threadA.start();
		threadB.start();
	}
}

class WorkObject {
	public synchronized void methodA() {
		System.out.println("ThreadA의 methodA() 작업");
		notify();
		try {
			wait();
		} catch (InterruptedException e) {}
	}
	public synchronized void methodB() {
		System.out.println("ThreadB의 methodB() 작업");
		notify();
		try {
			wait();
		} catch (InterruptedException e) {}
	}
}

class ThreadA extends Thread {
	private WorkObject workObject;

	public ThreadA(WorkObject workObject) {
		this.workObject = workObject;
	}
	
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			workObject.methodA();
		}
	}
}

class ThreadB extends Thread {
	private WorkObject workObject;

	public ThreadB(WorkObject workObject) {
		this.workObject = workObject;
	}
	
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			workObject.methodB();
		}
	}
}