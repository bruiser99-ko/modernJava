package thisisjava.chapter12.ex06;

public class Ex06 {
	public static void main(String[] args) {
		PrintThread1 printThread1 = new PrintThread1();
		printThread1.start();
		
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {}
		printThread1.setStop(true);
		
		PrintThread2 printThread2 = new PrintThread2();
		printThread2.start();
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {}
		printThread2.interrupt();
	}
}

class PrintThread1 extends Thread {
	private boolean stop;
	
	public void setStop(boolean stop) {
		this.stop = stop;
	}
	
	@Override
	public void run() {
		while(!stop) {
			System.out.println("PrintThread1 실행 중");
		}
		System.out.println("PrintThread1 자원 정리");
		System.out.println("PrintThread1 실행 종료");
	}
}

class PrintThread2 extends Thread {
	@Override
	public void run() {
		while(!Thread.interrupted()) {
			System.out.println("PrintThread2 실행 중");
		}
		System.out.println("PrintThread2 자원 정리");
		System.out.println("PrintThread2 실행 종료");
	}
}