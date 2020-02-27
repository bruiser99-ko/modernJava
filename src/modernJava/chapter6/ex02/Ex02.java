package modernJava.chapter6.ex02;

import java.util.stream.Collectors;

public class Ex02 {
	public static void main(String[] args) {
		int totalCalories1 = Dish.menu.stream()
				.map(Dish::getCalories)
				.reduce(Integer::sum)
				.get();
		System.out.println("totalCalories1: " + totalCalories1);

		int totalCalories2 = Dish.menu.stream()
				.map(Dish::getCalories)
				.reduce(0, Integer::sum);
		System.out.println("totalCalories2: " + totalCalories2);
		
		int totalCalories3 = Dish.menu.stream()
				.map(Dish::getCalories)
				.collect(Collectors.reducing(0, Integer::sum));
		System.out.println("totalCalories3: " + totalCalories3);

		int totalCalories4 = Dish.menu.stream()
				.mapToInt(Dish::getCalories)
				.sum();
		System.out.println("totalCalories4: " + totalCalories4);
	}
}
