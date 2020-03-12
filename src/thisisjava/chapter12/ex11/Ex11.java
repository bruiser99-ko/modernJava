package thisisjava.chapter12.ex11;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Ex11 {
	public static void main(String[] args) {
		int cores = Runtime.getRuntime().availableProcessors();
		System.out.println(cores);
		ExecutorService executorService = Executors.newFixedThreadPool(cores);
		
		System.out.println("[작업 처리 요청]");
		class Task implements Runnable {
			Result result;
			public Task(Result result) {
				this.result = result;
			}
			@Override
			public void run() {
				int sum = 0;
				for(int i=0; i<=10; i++) {
					sum += i;
				}
				result.addValue(sum);
			}
			
		}
		
		Result result = new Result();
		Runnable task1 = new Task(result);
		Runnable task2 = new Task(result);
		
		Future<Result> future1 = executorService.submit(task1, result);
		Future<Result> future2 = executorService.submit(task2, result);
		try {
			result = future1.get();
			System.out.println("[처리 결과1] " + result.getAccumValue());
			result = future2.get();
			System.out.println("[처리 결과2] " + result.getAccumValue());
			System.out.println("[작업 처리 완료]");
		} catch (InterruptedException | ExecutionException e) {
			System.out.println("[예외 발생] " + e.getMessage());
		}
	}
}

class Result {
	private int accumValue;
	
	synchronized void addValue(int value) {
		accumValue += value;
	}
	
	public int getAccumValue() {
		return accumValue;
	}
}