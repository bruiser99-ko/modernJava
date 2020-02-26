package modernJava.chapter4.ex04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Ex04 {
	public static void main(String[] args) {
		/* 외부 반복(컬렉션: for문) */
		List<String> names1 = new ArrayList<String>();
		for(Dish dish: Dish.menu) {
			names1.add(dish.getName());
		}
		System.out.println("외부 반복(컬렉션: for문)");
		System.out.println(names1);

		/* 외부 반복(컬렉션: Iterator) */
		List<String> names2 = new ArrayList<String>();
		Iterator<Dish> iterator = Dish.menu.iterator();
		while(iterator.hasNext()) {
			Dish dish = iterator.next();
			names2.add(dish.getName());
		}
		System.out.println("외부 반복(컬렉션: Iterator)");
		System.out.println(names2);

		/* 내부 반복(스트림) */
		List<String> names3 = Dish.menu.stream()
				.map(Dish::getName)
				.collect(Collectors.toList());
		System.out.println("내부 반복(스트림)");
		System.out.println(names3);
		
		/*
		 * 컬렉션은 DVD처럼 모든 데이터를 가지고 있고
		 * 스트림은 유투브의 스트리밍처럼 필요한 데이터만 가지고 있다.
		 * 그래서 스트림으로 변형하면 한 번만 데이터를 사용할 수 있다.
		 * 데이터의 재사용이 필요하면 컬렉션을 사용해야 한다.
		 * 만약 I/O를 통해 입력된 데이터를 스트림으로 변경하면
		 * 원본 데이터가 없어지게 되므로 신중하게 사용해야 한다.
		 */
	}
	
}
