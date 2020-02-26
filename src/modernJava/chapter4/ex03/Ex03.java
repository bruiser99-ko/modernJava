package modernJava.chapter4.ex03;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Ex03 {
	public static void main(String[] args) {
		List<String> threeHighCaloricDishNames =
				Dish.menu.stream()
				.filter(d -> d.getCalories() > 300)
				.sorted(Comparator.comparing(Dish::getCalories).thenComparing(Dish::getName))
				.map(Dish::getName)
				.limit(3)
				.collect(Collectors.toList());
		System.out.println(threeHighCaloricDishNames);
	}
	
}
