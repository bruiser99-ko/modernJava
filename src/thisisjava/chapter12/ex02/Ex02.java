package thisisjava.chapter12.ex02;

public class Ex02 {
	public static void main(String[] args) {
		for(int i=0; i<10; i++) {
			Thread t = new Thread() {
				@Override
				public void run() {
					for(int i=0; i<2_000_000_000; i++) {
					}
					System.out.println(Thread.currentThread().getName());
				}
			};
			if(i == 5) {
				t.setPriority(Thread.MAX_PRIORITY);
			}
			t.start();
		}
	}
}
