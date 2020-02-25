package modernJava.chapter3.ex03;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Filter {
	public <T> List<T> filter(List<T> list, Predicate<T> p) {
		List<T> results = new ArrayList<T>();
		for(T t: list) {
			if(p.test(t)) {
				results.add(t);
			}
		}
		return results;
	}
}
