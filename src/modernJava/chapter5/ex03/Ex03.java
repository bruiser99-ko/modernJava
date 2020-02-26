package modernJava.chapter5.ex03;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex03 {
	public static void main(String[] args) {
		/* map() 메서드: 새로운 요소로 매핑 */
		List<String> dishNames = Dish.menu.stream()
				.map(Dish::getName)
				.collect(Collectors.toList());
		System.out.println(dishNames);
		
		/* 중복 문자 제거 후 출력하려고 했지만 실패 */
		List<String> words = Arrays.asList("Hello", "World");
		List<String[]> chars = words.stream()
				.map(s->s.split(""))
				.distinct()
				.collect(Collectors.toList());
		for(String[] s: chars) {
			for(String str: s) System.out.print(str);
			System.out.println();
		}
		
		/* Arrays.stream 활용도 실패 */
		String[] arrayOfWords = {"Goodbye", "World"};
		List<Stream<String>> chars2 = Arrays.stream(arrayOfWords)
				.map(s->s.split(""))
				.map(Arrays::stream)
				.distinct()
				.collect(Collectors.toList());
		for(Stream<String> s: chars2) {
			s.forEach(System.out::print);
		}
		System.out.println();
		
		/* flatMap 사용 */
		/* flatMap은 Array나 Object로 감싸여 있는 모든 원소를
		 * 평면화(모든 원소를 Depth1으로 나열)하여 하나의 스트림으로 변환한다. */
		List<String> chars3 = Arrays.stream(arrayOfWords)
				.map(s->s.split(""))	//한글자씩 분리되어 2차원 배열로 만들어짐
				.flatMap(Arrays::stream)	//Depth1로 결합되어 1차원 배열이 됨
				.distinct()				//꼭 stream으로 변환해야 되나 의문은 들지만 답은 못찾음
				.collect(Collectors.toList());	//char[]과 String으로 변환은 오류 발생
		System.out.println(chars3);
	}
}
