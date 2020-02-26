package modernJava.chapter4.ex02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Ex02 {
	public static void main(String[] args) {
		List<Dish> menu = new ArrayList<>();
		menu.add(new Dish("라면", 500));
		menu.add(new Dish("샐러드", 300));
		menu.add(new Dish("콜라", 200));
		
		/* 자바8 스트림 적용 코드 */
		List<String> lowCaloricDishesName = 
				menu.stream()
				.filter(d -> d.getCalories() < 400)	//400칼로리 미만 요리 필터링
				.sorted(Comparator.comparing(Dish::getCalories))	//칼로리 순으로 요리 정렬
				.map(Dish::getName)	//요리명 추출
				.collect(Collectors.toList());	//리스트로 변경
		System.out.println(lowCaloricDishesName);
	}
}
