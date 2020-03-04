package modernJava.chapter09.ex02;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import modernJava.chapter09.ex02.Dish.CaloricLevel;

public class Ex02 {
	public static void main(String[] args) {
		/*람다식*/
		Map<CaloricLevel, List<Dish>> dishesByCaloricLevel1 = Dish.menu.stream()
				.collect(Collectors.groupingBy(dish -> { 
					if(dish.getCalories() <= 400) return CaloricLevel.DIET;
					else if(dish.getCalories() <= 700) return CaloricLevel.NORMAL;
					else return CaloricLevel.FAT;
				}));
		
		/*메서드 참조(Dish 클래스에 getCaloricLevel()메서드 추가)*/
		Map<CaloricLevel, List<Dish>> dishesByCaloricLevel2 = Dish.menu.stream()
				.collect(Collectors.groupingBy(Dish::getCaloricLevel));
		
		int totalCalories1 = Dish.menu.stream().map(Dish::getCalories).reduce(0, (c1, c2)->c1+c2);
		int totalCalories2 = Dish.menu.stream().collect(Collectors.summingInt(Dish::getCalories));
		int totalCalories3 = Dish.menu.stream().mapToInt(Dish::getCalories).sum();
		/*
		 * map을 사용하면 전체 데이터 변환을 해야 되므로 데이터가 많을 경우에 처리 속도가 느려진다.
		 */
		
		
		System.out.println(dishesByCaloricLevel1);
		System.out.println(dishesByCaloricLevel2);
		System.out.println(totalCalories1);
		System.out.println(totalCalories2);
		System.out.println(totalCalories3);
	}
}
