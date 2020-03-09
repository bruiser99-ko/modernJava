package modernJava.chapter15.ex02;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Ex02 {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		/* ExcutorService로 스레드 풀 이용 */
		int x = 1337;
		
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		Future<Integer> y = executorService.submit(() -> f(x));
		Future<Integer> z = executorService.submit(() -> g(x));
		System.out.println(y.get() + z.get());
		
		executorService.shutdown();
	}
	
	private static int f(int x) {
		return 0;
	}
	private static int g(int x) {
		return 0;
	}

}
