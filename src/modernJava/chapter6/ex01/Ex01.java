package modernJava.chapter6.ex01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ex01 {
	public static void main(String[] args) {
		List<Transaction> transactions = Transaction.transactions;
//		System.out.println(transactions);	//이해를 위한 출력
		
		/* 통화별로 트랜잭션을 그룹화한 코드(명령형 버전) */
		Map<Currency, List<Transaction>> transactionsByCurrencies1 = new HashMap<>();
		for(Transaction t: transactions) {
			Currency currency = t.getCurrency();
			List<Transaction> transactionsForCurrency = transactionsByCurrencies1.get(currency);
//			System.out.println(transactionsForCurrency);	//이해를 위한 출력
			if(transactionsForCurrency == null) {
				transactionsForCurrency = new ArrayList<Transaction>();
				transactionsByCurrencies1.put(currency, transactionsForCurrency);
			}
			transactionsForCurrency.add(t);	//Map 내부의 List에 추가를 해도 참조타입이므로 적용된다.
//			System.out.println(transactionsByCurrencies1);	//이해를 위한 출력
		}
		
		Map<Currency, List<Transaction>> transactionsByCurrencies2 = transactions.stream()
				.collect(Collectors.groupingBy(Transaction::getCurrency));
		System.out.println(transactionsByCurrencies2);
	}
}
