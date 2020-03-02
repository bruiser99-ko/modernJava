package modernJava.chapter07.ex01;

import java.util.stream.Stream;

public class Ex01 {
	public static void main(String[] args) {
		
	}
	
	/* 스트림을 사용한 메서드 */
	public long sequentialSum(long n) {
		return Stream.iterate(1L, i-> i + 1)
				.limit(n)
				.reduce(0L, Long::sum);
	}
	
	/* 반복문을 사용한 메서드 */
	public long iterativeSum(long n) {
		long result = 0;
		for(long i = 1L; i <= n; i++) {
			result += i;
		}
		return result;
	}
	
	/* 병렬 스트림을 사용한 메서드 */
	public long parallelSum(long n) {
		return Stream.iterate(1L, i-> i + 1)
				.limit(n)
				.parallel()	//병렬스트림 변환 메서드
//				.sequential()	//순차스트림 변환 메서드
				.reduce(0L, Long::sum);
	}

}
