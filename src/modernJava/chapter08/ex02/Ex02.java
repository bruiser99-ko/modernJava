package modernJava.chapter08.ex02;

import java.util.List;
import java.util.Map;

public class Ex02 {
	public static void main(String[] args) {
//		for(Transaction transaction:transactions) {
//			if(Character.isDigit(transaction.getReferenceCode().charAt(0) )) {
//				transactions.remove(transaction);
// 			}
//		}
		/* 컬렉션에서도 forEach() 메서드가 있다. */
		Map<String, Integer> ageOfFirends1 = Map.of("Raphael", 30, "Olivia", 40, "Thibaut", 25);
		ageOfFirends1.forEach((key, value) -> System.out.println(key + " : " + value));
		
		List<String> friends = List.of("Raphael", "Olivia", "Thibaut");
		friends.forEach(System.out::println);
	}
}
