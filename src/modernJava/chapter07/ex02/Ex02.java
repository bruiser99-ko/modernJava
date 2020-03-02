package modernJava.chapter07.ex02;

public class Ex02 {
	public static void main(String[] args) {
		long res1 = ForkJoinSumCalculator.forkJoinSum(10_000_000);
		System.out.println(res1);
		long res2 = ForkJoinSumCalculator.forkJoinSum(1_000);
		System.out.println(res2);
		long res3 = ForkJoinSumCalculator.forkJoinSum(1_0_0_0);
		System.out.println(res3);
		System.out.println(1_0_0_________________________000);
		/* 숫자 사이의 언더바는 아무런 의미가 없다. */
	}
}
