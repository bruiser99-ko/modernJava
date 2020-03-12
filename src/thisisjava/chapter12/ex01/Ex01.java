package thisisjava.chapter12.ex01;

import java.awt.Toolkit;

public class Ex01 {
	public static void main(String[] args) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		new Thread(new Task()).start();
		for(int i=0; i<5; i++) {
			toolkit.beep();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
		}
	}
}

class Task implements Runnable {

	@Override
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println("경고음");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
		}
	}
	
}