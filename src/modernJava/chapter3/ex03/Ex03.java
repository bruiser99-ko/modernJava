package modernJava.chapter3.ex03;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Ex03 {
	public static void main(String[] args) {
		Filter f = new Filter();
		List<String> listOfStrings = new ArrayList<String>();
		listOfStrings.add("가나다");
		listOfStrings.add("라마바");
		listOfStrings.add("사아자");
		Predicate<String> nonEmptyStringPredicate = s -> !s.isEmpty();
		List<String> nonEmpty = f.filter(listOfStrings, nonEmptyStringPredicate);
		System.out.println(nonEmpty.toString());
	}
}
