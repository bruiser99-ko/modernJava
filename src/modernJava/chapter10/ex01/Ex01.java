package modernJava.chapter10.ex01;

import static modernJava.chapter10.ex01.NestedFunctionOrderBuilder.*;

public class Ex01 {
	public static void main(String[] args) {
		/* 자바 코드를 이용한 주식 거래 주문서 */
		Order order = new Order();
		order.setCustomer("BigBank");

		Trade trade1 = new Trade();
		trade1.setType(Trade.Type.BUY);

		Stock stock1 = new Stock();
		stock1.setSymbol("IBM");
		stock1.setMarket("NYSE");

		trade1.setStock(stock1);
		trade1.setPrice(125.00);
		trade1.setQuantity(80);
		order.addTrade(trade1);

		Trade trade2 = new Trade();
		trade2.setType(Trade.Type.SELL);

		Stock stock2 = new Stock();
		stock2.setSymbol("GOOGLE");
		stock2.setMarket("NASDAQ");

		trade2.setStock(stock2);
		trade2.setPrice(375.00);
		trade2.setQuantity(50);
		order.addTrade(trade2);
		
		/* 메서드 체인을 이용한 주식 거래 주문서 */
		Order order2 = MethodChainingOrderBuilder.forCustomer("BigBank")
				.buy(80)
				.stock("IBM")
				.on("NYSE")
				.at(125.00)
				.sell(50)
				.stock("GOOGLE")
				.on("NASDAQ")
				.at(375.00)
				.end();
		// 메서드 체인의 단점은 빌더 클래스를 만들어야 한다는 점이다.
		
		/* 중첩된 함수 이용 */
		Order order3 = order("BigBank",
					buy(80, stock("IBM", on("NYSE")), at(125.00)),
					sell(50, stock("GOOGLE", on("NASDAQ")), at(375.00))
				);
		
		
		/* 람다식 */
		Order order4 = LambdaOrderBuilder.order(o -> {
			o.forCustomer("BigBank");
			o.buy(t -> {
				t.quantity(80);
				t.price(125.00);
				t.stock(s -> {
					s.symbol("IBM");
					s.market("NYSE");
				});
			});
			o.sell(t -> {
				t.quantity(50);
				t.price(375.00);
				t.stock(s -> {
					s.symbol("GOOGLE");
					s.market("NASDAQ");
				});
			});
		});
	}
}
