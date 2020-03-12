package thisisjava.chapter12.ex10;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Ex10 {
	public static void main(String[] args) {
		int cores = Runtime.getRuntime().availableProcessors();
		System.out.println(cores);
		ExecutorService executorService = Executors.newFixedThreadPool(cores);
		
		System.out.println("[작업 처리 요청]");
		Callable<Integer> callable = new Callable<>() {
			
			@Override
			public Integer call() {
				int sum = 0;
				for(int i=1; i<=10; i++) {
					sum += i;
				}
				System.out.println("[처리 결과] " + sum);
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return sum;
			}
		};
		
		Future<Integer> future = executorService.submit(callable);
		executorService.submit(()->{	//메인(UI)에서 get()을 호출하면 블로킹될 수 있어서 다른 스레드에서 호출
			try {
				int result = future.get();
				System.out.println(result);
				System.out.println("[작업 처리 완료]");
			} catch (InterruptedException | ExecutionException e) {
				System.out.println("[예외 발생] " + e.getMessage());
			}
		});
		
		executorService.shutdown();
	}
}
