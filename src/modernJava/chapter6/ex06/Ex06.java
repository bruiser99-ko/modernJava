package modernJava.chapter6.ex06;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import modernJava.chapter4.ex03.Dish;

public class Ex06 {
	public static void main(String[] args) {
		/* 분할 */
		Map<Boolean, List<Dish>> partitionedMenu1 = Dish.menu.stream()
				.collect(Collectors.groupingBy(Dish::isVegetarian));
		System.out.println(partitionedMenu1);

		Map<Boolean, List<Dish>> partitionedMenu2 = Dish.menu.stream()
				.collect(Collectors.partitioningBy(Dish::isVegetarian));
		System.out.println(partitionedMenu2);
		/*
		 * 그룹화는 여러 개의 그룹으로 나눈다. 분할은 true와 false의 2개로만 나눈다.
		 */

		Map<Boolean, Map<Dish.Type, List<Dish>>> vegitarianDishesByType = Dish.menu.stream().collect(Collectors
				.partitioningBy(Dish::isVegetarian, Collectors.groupingBy(Dish::getType, Collectors.toList())));
		System.out.println(vegitarianDishesByType);

		Map<Boolean, Dish> mostCaloricPartitionedByVegetarian = Dish.menu.stream()
				.collect(Collectors.partitioningBy(Dish::isVegetarian, Collectors.collectingAndThen(
						Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));
		System.out.println(mostCaloricPartitionedByVegetarian);
	}
}
