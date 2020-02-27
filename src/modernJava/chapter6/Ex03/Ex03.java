package modernJava.chapter6.Ex03;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import modernJava.chapter6.Ex03.Dish.Type;

public class Ex03 {
	public static void main(String[] args) {
		Map<Type, List<Dish>> dishesByType = Dish.menu.stream().collect(Collectors.groupingBy(Dish::getType));
		System.out.println(dishesByType);
		// 원래는 Dish형 obj가 출력되야 하지만 toString()을 오버라이딩해서 name이 출력됨

		/* Dish형 Obj임을 확인하기 위해 사용한 코드 */
		Set<Type> keys = dishesByType.keySet();
		for (Type key : keys) {
			List<Dish> dish = dishesByType.get(key);
			for (int i = 0; i < dish.size(); i++)
				System.out.println(dish.get(i).getCalories());
			System.out.println();
		}

		/* 그룹화된 요소 조작 */
		Map<Type, List<Dish>> caloricDishesByType1 = Dish.menu.stream()
				.filter(dish -> dish.getCalories() > 500)
				.collect(Collectors.groupingBy(Dish::getType));
		System.out.println(caloricDishesByType1);

		Map<Type, List<Dish>> caloricDishesByType2 = Dish.menu.stream()
				.collect(Collectors.groupingBy(Dish::getType, Collectors.filtering(dish -> dish.getCalories() > 500, Collectors.toList())));
		System.out.println(caloricDishesByType2);
		
		Map<Type, List<String>> caloricDishesByType3 = Dish.menu.stream()
				.collect(Collectors.groupingBy(Dish::getType, Collectors.mapping(Dish::getName, Collectors.toList())));
		System.out.println(caloricDishesByType3);
		
		Map<Type, Set<String>> dishTagsByType = Dish.menu.stream()
				.collect(Collectors.groupingBy(Dish::getType, Collectors.flatMapping(d -> Dish.dishTags.get(d.getName()).stream(), Collectors.toSet())));
		System.out.println(dishTagsByType);
	}
}
