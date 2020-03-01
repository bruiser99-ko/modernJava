package modernJava.chapter6.ex07;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ex07 {
	public static void main(String[] args) {
		Ex07 me = new Ex07();
		Map<Boolean, List<Integer>> res = me.partitionPrimes(20);
		System.out.println(res);
	}
	
	public boolean isPrime(int candidate) {
		int candidateRoot = (int) Math.sqrt(candidate);
		return IntStream.range(2, candidateRoot).noneMatch(i -> candidate % i == 0);
	}
	
	public Map<Boolean, List<Integer>> partitionPrimes(int n) {
		return IntStream.rangeClosed(2, n).boxed().collect(Collectors.partitioningBy(candidate -> isPrime(candidate)));
	}
}
