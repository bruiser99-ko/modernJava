package modernJava.chapter16.ex01;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Shop {
	public Shop(String string) {
		// TODO Auto-generated constructor stub
	}

	public double getPrice(String product) {
		return calculatePrice(product);
	}
	
	private double calculatePrice(String product) {
		delay();
		return new Random().nextDouble() * product.charAt(0) + product.charAt(1);
	}

	public static void delay() {
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Future<Double> getPriceAsync(String product) {
		CompletableFuture<Double> futurePrice = new CompletableFuture<Double>();
		new Thread(()->{
			double price = calculatePrice(product);
			futurePrice.complete(price);
		}).start();
		return futurePrice;
	}
}
