package modernJava.chapter15.ex01;

public class Ex01 {
	public static void main(String[] args) throws InterruptedException {
		/* Thread를 이용한 병렬 처리 */
		int x = 1337;
		Result result = new Result();
		
		Thread t1 = new Thread(() -> result.left = f(x));
		Thread t2 = new Thread(() -> result.right = g(x));
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(result.left + result.right);
	}
	
	private static class Result {
		private int left;
		private int right;
	}
	
	private static int f(int x) {
		return 0;
	}
	private static int g(int x) {
		return 0;
	}
}
