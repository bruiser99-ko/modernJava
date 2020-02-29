package modernJava.chapter6.ex05;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import modernJava.chapter6.ex05.Dish.Type;

public class Ex05 {
	public static void main(String[] args) {
		/* 서브그룹으로 데이터 수집 */
		Map<Dish.Type, Dish> mostCaloricByType = Dish.menu.stream()
				.collect(Collectors.groupingBy(Dish::getType, Collectors.collectingAndThen(
						Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));
		System.out.println(mostCaloricByType);
		
		Map<Type, Integer> totalCaloricByType = Dish.menu.stream()
				.collect(Collectors.groupingBy(Dish::getType, Collectors.summingInt(Dish::getCalories)));
		System.out.println(totalCaloricByType);
		
		/* 서브그룹에서 데이터 매핑으로 수집 */
		Map<Type, Set<Dish.CaloricLevel>> caloricLevelByType = Dish.menu.stream()
				.collect(Collectors.groupingBy(Dish::getType, Collectors.mapping(d->{
					if(d.getCalories()<=400) return Dish.CaloricLevel.DIET;
					else if(d.getCalories()<= 700) return Dish.CaloricLevel.NORMAL;
					else return Dish.CaloricLevel.FAT;
				}, Collectors.toSet())));
		System.out.println(caloricLevelByType);
		
		/* 서브그룹에서 데이터 매핑으로 수집 - Set의 형태를 HashSet으로 고정 */
		Map<Type, Set<Dish.CaloricLevel>> caloricLevelByType2 = Dish.menu.stream()
				.collect(Collectors.groupingBy(Dish::getType, Collectors.mapping(d->d.getCalories()<=400?Dish.CaloricLevel.DIET:d.getCalories()<=700?Dish.CaloricLevel.NORMAL:Dish.CaloricLevel.FAT, Collectors.toCollection(HashSet::new))));
		System.out.println(caloricLevelByType2);
	}
}
