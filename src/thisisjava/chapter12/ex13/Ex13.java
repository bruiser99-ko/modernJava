package thisisjava.chapter12.ex13;

import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ex13 {
	private ExecutorService executorService;

	public Ex13() {
		this.executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
	}
	
	private CompletionHandler<Integer, Void> callback = new CompletionHandler<Integer, Void>() {
		
		@Override
		public void failed(Throwable exc, Void attachment) {
			System.out.println("failed(): " + exc.toString());
		}
		
		@Override
		public void completed(Integer result, Void attachment) {
			System.out.println("completed(): " + result);
		}
	};
	
	public void doWork(String x, String y) {
		Runnable task = new Runnable() {
			@Override
			public void run() {
				try {
					int intX = Integer.parseInt(x);
					int intY = Integer.parseInt(y);
					int result = intX + intY;
					callback.completed(result, null);
				} catch(Exception e) {
					callback.failed(e, null);
				}
			}
		};
		executorService.submit(task);
	}
	
	public void finish() {
		executorService.shutdown();
	}
	
	public static void main(String[] args) {
		Ex13 exam = new Ex13();
		exam.doWork("3", "3");
		exam.doWork("3", "삼");
		exam.finish();
	}
}
