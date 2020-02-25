package modernJava.chapter3.ex04;

import java.util.Arrays;
import java.util.List;

public class Ex04 {
	public static void main(String[] args) {
		List<String> str = Arrays.asList("a", "b", "A", "B");
		
		/* 람다식 */
		str.sort((s1, s2)->s1.compareTo(s2));
		System.out.println(str);
		
		/* 메서드 참조 */
		str.sort(String::compareToIgnoreCase);
		System.out.println(str);
	}
}
