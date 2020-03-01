package modernJava.chapter6.ex09;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ex09 {
	public static void main(String[] args) {
		
	}
	
	public Map<Boolean, List<Integer>> partitionPrimes(int n) {
		return IntStream.rangeClosed(2, n).boxed()
				.collect(Collectors.partitioningBy(candidate -> isPrime(candidate)));
	}

	private boolean isPrime(int candidate) {
		return IntStream.rangeClosed(2, candidate)
				.noneMatch(i->candidate % i == 0);
	}

}
