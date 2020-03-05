package modernJava.chapter09.ex08;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class Ex08 {
	public static void main(String[] args) {
		/*
		 * 객체 지향 디자인 패턴 리팩터링 - 5. 팩토리
		 * 인스턴스화 로직을 클라이언트에 노출하지 않고 객체를 만들 때 팩토리 디자인 패턴을 사용한다.
		 */
		
		Product p = ProductFactory.createProduct("loan");
		Supplier<Product> loanSupplier = Loan::new;
		Product loan = loanSupplier.get();
		
	}
	4
	final static Map<String, Supplier<Product>> map = new HashMap<String, Supplier<Product>>();
	static {
		map.put("loan", Loan::new);
		map.put("stock", Stock::new);
		map.put("bond", Bond::new);
	}
	
	public static Product createProduct(String name) {
		Supplier<Product> p = map.get(name);
		if(p != null) return p.get();
		throw new IllegalArgumentException("No such product " + name);
	}
}
