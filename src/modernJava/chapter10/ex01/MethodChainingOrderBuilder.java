package modernJava.chapter10.ex01;

public class MethodChainingOrderBuilder {
	public final Order order = new Order();

	private MethodChainingOrderBuilder(String customer) {
		order.setCustomer(customer);
	}

	public static MethodChainingOrderBuilder forCustomer(String customer) {
		return new MethodChainingOrderBuilder(customer);
	}

	public TradeBuilder buy(int quantity) {
		return new TradeBuilder(this, Trade.Type.BUY, quantity);
	}

	MethodChainingOrderBuilder addTrade(Trade trade) {
		order.addTrade(trade);
		return this;
	}
	
	public TradeBuilder sell(int quantity) {
		return new TradeBuilder(this, Trade.Type.SELL, quantity);
	}
	
	public Order end() {
	    return order;
	  }
}
