package modernJava.chapter5.ex02;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Ex02 {
	public static void main(String[] args) {
		/* 스트림 */
		List<Dish> filteredMenu1 = Dish.menu.stream()
				.filter(d -> d.getCalories() < 320)
				.collect(Collectors.toList());
		System.out.println("filteredMenu1: " + filteredMenu1);
		
		/* takeWhile() 메서드: 조건에 예외가 발생하면 멈추게 함  */
		List<Dish> filteredMenu2 = Dish.menu.stream()
				.takeWhile(d -> d.getCalories() < 320)	//첫번째 fork가 800이라서 멈춤
				.collect(Collectors.toList());
		System.out.println("filteredMenu2: " + filteredMenu2);

		List<Dish> filteredMenu3 = Dish.menu.stream()
				.sorted(Comparator.comparing(Dish::getCalories))	//칼로리 별로 오름차순 정렬
				.takeWhile(d -> d.getCalories() < 320)	//조건에 부합하지 않으면 정지
				.collect(Collectors.toList());
		System.out.println("filteredMenu3: " + filteredMenu3);
		
		/* dropWhile() 메서드: takeWhile()과 반대로 조건이 참이면 버리고 거짓이 발생하면 중단하고
		   나머지를 반환 */
		List<Dish> filteredMenu4 = Dish.menu.stream()
				.sorted(Comparator.comparing(Dish::getCalories))	//칼로리 별로 오름차순 정렬
				.dropWhile(d -> d.getCalories() < 320)	//조건이 참이면 버리고 거짓이면 중단하고 나머지를 반환
				.collect(Collectors.toList());
		System.out.println("filteredMenu4: " + filteredMenu4);
		
		/*
		 * takeWhile()과 dropWhile()을 사용하면 조건이 거짓일 때 중단되므로
		 * 연산 속도를 높일 수 있다. 이것을 '스트림 슬라이싱'이라고 한다.
		 */
	}
}
