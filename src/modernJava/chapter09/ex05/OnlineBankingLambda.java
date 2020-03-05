package modernJava.chapter09.ex05;

import java.util.function.Consumer;

public abstract class OnlineBankingLambda {
	public void processCustomer(int id) {
		Customer c = Database.getCustomerWithId(id);
		makeCustomerHappy(c);	
	}

	public void processCustomer(int id, Consumer<Customer> makeCustomerHappy) {
		Customer c = Database.getCustomerWithId(id);
		makeCustomerHappy.accept(c);	
	}

	abstract void makeCustomerHappy(Customer c);

	// 더미 Customer 클래스
	static class Customer {
	}

	// 더미 Database 클래스
	static private class Database {

		static Customer getCustomerWithId(int id) {
			return new Customer();
		}
	}
}
