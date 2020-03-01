package modernJava.chapter6.ex08;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ex08 {
	public static void main(String[] args) {
		/*ToListCollector 클래스를 이용한 수집*/
		List<Dish> dishes1 = Dish.menu.stream().collect(new ToListCollector<Dish>());
		System.out.println(dishes1);
		
		/*기존 예제처럼 toList()를 이용한 수집 - toString()이 오버라이딩되어서 동일 결과가 출력*/
		List<Dish> dishes2 = Dish.menu.stream().collect(Collectors.toList());
		System.out.println(dishes2);
		
		/*컬렉터 구현을 만들지 않고 수집*/
		List<Dish> dishes3 = Dish.menu.stream().collect(ArrayList::new, List::add, List::addAll);
		System.out.println(dishes3);
		/*
		 * 컬렉터를 구현하지 않으면 코드는 간결하지만 가독성이 떨어진다.
		 * 또한 Characteristics를 설정하지 못한다.
		 */
	}
}
