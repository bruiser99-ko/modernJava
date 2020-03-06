package modernJava.chapter10.ex01;

import java.util.function.Consumer;

public class TradeBuilder {
	private final MethodChainingOrderBuilder builder;
	public final Trade trade = new Trade();
	
	TradeBuilder(MethodChainingOrderBuilder builder, Trade.Type type, int quantity) {
		this.builder = builder;
		trade.setType(type);
		trade.setQuantity(quantity);
	}
	
	public TradeBuilder() {
		this.builder = null;
		// TODO Auto-generated constructor stub
	}

	public StockBuilder stock(String symbol) {
		return new StockBuilder(builder, trade, symbol);
	}
	
	/* 람다식을 위해 추가 */
	public void quantity(int quantity) {
		trade.setQuantity(quantity);
	}
	
	public void price(double price) {
		trade.setPrice(price);
	}
	
	public void stock(Consumer<StockBuilder> consumer) {
		StockBuilder builder = new StockBuilder();
		consumer.accept(builder);
		trade.setStock(builder.stock);
	}
}
