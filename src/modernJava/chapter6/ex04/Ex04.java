package modernJava.chapter6.ex04;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import modernJava.chapter6.ex04.Dish.Type;

public class Ex04 {
	public static void main(String[] args) {
		/* 다수준 그룹화 */
		Map<Dish.Type, Map<Dish.CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel = Dish.menu.stream()
				.collect(Collectors.groupingBy(Dish::getType, Collectors.groupingBy(dish -> {
					if (dish.getCalories() <= 400) {
						return Dish.CaloricLevel.DIET;
					} else if (dish.getCalories() <= 700) {
						return Dish.CaloricLevel.NORMAL;
					} else {
						return Dish.CaloricLevel.FAT;
					}
				})));
		System.out.println(dishesByTypeCaloricLevel);
		
		/* 서브그룹으로 데이터 수집 - 요리 개수 구하기 */
		Map<Dish.Type, Long> typesCount = Dish.menu.stream()
				.collect(Collectors.groupingBy(Dish::getType, Collectors.counting()));
		System.out.println(typesCount);

		/* 서브그룹으로 데이터 수집 - 요리 중 가장 높은 칼로리 구하기 */
		Map<Type, Optional<Dish>> mostCaloricByType = Dish.menu.stream()
				.collect(Collectors.groupingBy(Dish::getType, Collectors.maxBy(Comparator.comparing(Dish::getCalories))));
		System.out.println(mostCaloricByType);
}
}
