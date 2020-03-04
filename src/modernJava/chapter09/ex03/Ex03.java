package modernJava.chapter09.ex03;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ex03 {
	public static void main(String[] args) {
		/*명령형 데이터 처리*/
		List<String> dishNames1 = new ArrayList<String>();
		for(Dish dish: Dish.menu) {
			if(dish.getCalories() > 300) dishNames1.add(dish.getName());
		}
		
		/*스트림*/
		List<String> dishNames2 = Dish.menu.stream()
				.filter(d->d.getCalories()>300)
				.collect(Collectors.mapping(Dish::getName, Collectors.toList()));

		List<String> dishNames3 = Dish.menu.stream()
				.filter(d->d.getCalories()>300)
				.map(Dish::getName)
				.collect(Collectors.toList());

		System.out.println(dishNames1);
		System.out.println(dishNames2);
		System.out.println(dishNames3);
	}
}
