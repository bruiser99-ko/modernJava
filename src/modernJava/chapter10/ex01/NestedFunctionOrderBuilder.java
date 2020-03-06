package modernJava.chapter10.ex01;

import java.util.stream.Stream;

import modernJava.chapter10.ex01.Trade.Type;

public class NestedFunctionOrderBuilder {
	public static Order order(String customer, Trade...trades) {
		Order order = new Order();
		order.setCustomer(customer);
		Stream.of(trades).forEach(order::addTrade);
		return order;
	}
	
	public static Trade buy(int quantity, Stock stock, double price) {
		return buildTrade(quantity, stock, price, Trade.Type.BUY);
	}

	public static Trade sell(int quantity, Stock stock, double price) {
		return buildTrade(quantity, stock, price, Trade.Type.SELL);
	}

	private static Trade buildTrade(int quantity, Stock stock, double price, Type type) {
		Trade trade = new Trade();
		trade.setQuantity(quantity);
		trade.setType(type);
		trade.setStock(stock);
		trade.setPrice(price);
		return trade;
	}
	
	public static double at(double price) {
		return price;
	}
	
	public static Stock stock(String symbol, String market) {
		Stock stock = new Stock();
		stock.setSymbol(symbol);
		stock.setMarket(market);
		return stock;
	}
	
	public static String on(String market) {
		return market;
	}
}
