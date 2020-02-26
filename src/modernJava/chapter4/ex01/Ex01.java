package modernJava.chapter4.ex01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ex01 {
	public static void main(String[] args) {
		List<Dish> menu = new ArrayList<>();
		menu.add(new Dish("라면", 500));
		menu.add(new Dish("샐러드", 300));
		menu.add(new Dish("콜라", 200));
		
		/* 자바7 코드 */
		List<Dish> lowCaloricDishes = new ArrayList<>();
		for(Dish dish: menu) {
			if(dish.getCalories() < 400) {
				lowCaloricDishes.add(dish);
			}
		}
		Collections.sort(lowCaloricDishes, new Comparator<Dish>() {	//익명클래스로 요리 정렬
			@Override
			public int compare(Dish d1, Dish d2) {
				return Integer.compare(d1.getCalories(), d2.getCalories());
			}
		});
		List<String> lowCaloricDishesName = new ArrayList<String>();
		for(Dish dish:lowCaloricDishes) {
			lowCaloricDishesName.add(dish.getName());	//정렬된 리스트의 요리 이름 선택
		}
	}
}
