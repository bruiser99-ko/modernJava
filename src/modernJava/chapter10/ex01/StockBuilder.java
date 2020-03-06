package modernJava.chapter10.ex01;

public class StockBuilder {
	private final MethodChainingOrderBuilder builder;
	private final Trade trade;
	final Stock stock = new Stock();
	
	StockBuilder(MethodChainingOrderBuilder builder, Trade trade, String symbol) {
		this.builder = builder;
		this.trade = trade;
		stock.setSymbol(symbol);
	}
	
	public StockBuilder() {
		this.builder = null;
		this.trade = new Trade();
	}

	public TradeBuilderWithStock on(String market) {
		stock.setMarket(market);
		trade.setStock(stock);
		return new TradeBuilderWithStock(builder, trade);
	}
	
	/* 람다식 추가 */
	public void symbol(String symbol) {
		stock.setSymbol(symbol);
	}
	
	public void market(String market) {
		stock.setMarket(market);
	}
}
