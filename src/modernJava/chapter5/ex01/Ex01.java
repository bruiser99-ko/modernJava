package modernJava.chapter5.ex01;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class Ex01 {
	public static void main(String[] args) {
		/* 컬렉션(외부 반복) */
		List<Dish> menu = Dish.menu;
		List<Dish> vegetarianDishes1 = new ArrayList<>();
		for(Dish d: menu) {
			if(d.isVegetarian()) {
				vegetarianDishes1.add(d);
			}
		}
		System.out.println("vegetarianDishes1: " + vegetarianDishes1);
		
		
		/* 스트림(내부 반복) */
		List<Dish> vegetarianDishes2 = menu.stream()
				.filter(Dish::isVegetarian)
				.collect(Collectors.toList());
		System.out.println("vegetarianDishes2: " + vegetarianDishes2);
		
		/* 중복 삭제 distinct() */
		List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
		numbers.stream()
		.filter(n -> n % 2 == 0)
		.distinct()
		.forEach(System.out::println); //forEach를 사용하여 각각의 요소에 적용. 여기선 출력
	}
}
