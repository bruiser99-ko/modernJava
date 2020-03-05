package modernJava.chapter09.ex07;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Ex07 {
	public static void main(String[] args) {
		/*
		 * 객체 지향 디자인 패턴 리팩터링 - 4. 의무 체인
		 * 한 객체가 어떤 작업을 처리한 다음에 다른 객체로 결과를 전달하고,
		 * 다른 객체도 해야 할 작업을 처리한 다음에 또 다른 객체로 전달
		 */
		
		ProcessingObject<String> p1 = new HeaderTextProcessing();
		ProcessingObject<String> p2 = new SpellCheckerProcessing();
		p1.setSuccessor(p2);
		String result1 = p1.handle("Aren't labdas really sexy?!!");
		System.out.println(result1);
		String result2 = p2.handle("Aren't labdas really sexy?!!");
		System.out.println(result2);
		
		/* 람다식 */
		UnaryOperator<String> headerProcessing = text -> "From Raoul, Mario and Alan: " + text;
		UnaryOperator<String> spellCheckerProcessing = text -> text.replaceAll("labda", "lambda");
		Function<String, String> pipeline = headerProcessing.andThen(spellCheckerProcessing);
		String result3 = pipeline.apply("Aren't labdas really sexy?!!");
		System.out.println(result3);
	}
}
