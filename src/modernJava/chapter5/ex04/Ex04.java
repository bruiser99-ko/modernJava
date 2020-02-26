package modernJava.chapter5.ex04;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex04 {
	public static void main(String[] args) {
		List<Integer> numbers1 = Arrays.asList(1, 2, 3);
		List<Integer> numbers2 = Arrays.asList(4, 5);
		List<int[]> result = 
				numbers1.stream()
				.flatMap(i -> numbers2.stream().map(j -> new int[] {i, j}))	//요소가 배열인데 플랫하게 하면 int 묶음이어야 되는거 아닌가?
				.collect(Collectors.toList());		//어쨋든 int[] 묶음 데이터가 나옴
		for(int[] is: result) {
			for(int num: is) {
				System.out.print(num);
			}
			System.out.println();
		}
	}
}
