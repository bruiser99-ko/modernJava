package modernJava.chapter08.ex01;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Ex01 {
	public static void main(String[] args) {
		/* 자바8 코드 */
		List<String> friends1 = Arrays.asList("Raphael", "Olivia", "Thibaut");
//		friends1.add("Richard");	//asList는 추가 삭제 불가능
		System.out.println(friends1);
		
		/* 자바9 추가된 팩토리 코드 */
		List<String> friends2 = List.of("Raphael", "Olivia", "Thibaut");
//		friends2.add("Richard");	//of도 추가 삭제 불가능
		System.out.println(friends2);
		
		/* Set과 Map */
//		Set<String> friends3 = Set.of("Raphael", "Olivia", "Thibaut", "Thibaut");	//중복은 걸러내지 않고 예외를 발생한다.
		Set<String> friends3 = Set.of("Raphael", "Olivia", "Thibaut");
		System.out.println(friends3);
		
		Map<String, Integer> ageOfFirends1 = Map.of("Raphael", 30, "Olivia", 40, "Thibaut", 25);
		System.out.println(ageOfFirends1);	//인자의 개수가 많아지면 가독성이 떨어진다.
		
		Map<String, Integer> ageOfFirends2 = Map.ofEntries(
					Map.entry("Raphael", 30),
					Map.entry("Olivia", 40),
					Map.entry("Thibaut", 25)
				);
		System.out.println(ageOfFirends2);
		
		/*
		 * 처리과정을 변경하면 복잡해져서 of()메서드도 추가 삭제가 불가능하다.
		 * 굳이 왜 만들었을까? Set과 Map 때문인듯 하다.
		 */
	}
}
