package modernJava.chapter3.ex05;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Ex05 {
	public static void main(String[] args) {
		/* 기본 코드 */
		List<Apple> inventory = new ArrayList<>();
		inventory.add(new Apple(150));
		inventory.add(new Apple(200));
		inventory.sort(new AppleComparator());
		
		/* 익명 클래스 */
		inventory.sort(new Comparator<Apple>() {
			@Override
			public int compare(Apple a1, Apple a2) {
				return a1.getWeight().compareTo(a2.getWeight());
			}
		});
		
		/* 람다식 */
		inventory.sort((a1, a2)->a1.getWeight().compareTo(a2.getWeight()));
		
		/* 메서드 참조 */
		AppleComparator ac = new AppleComparator();
		inventory.sort(ac::compare);
	}
}
