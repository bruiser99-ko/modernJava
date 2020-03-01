package modernJava.chapter6.ex08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class ToListCollector<T> implements Collector<T, List<T>, List<T>> {

	@Override
	/*수집 연산의 시발점*/
	public Supplier<List<T>> supplier() {
		return ArrayList::new;
	}

	@Override
	/*탐색한 항목을 누적하고 바로 누적자를 고친다*/
	public BiConsumer<List<T>, T> accumulator() {
		return List::add;
	}

	@Override
	/*분할 처리된 데이터의 결합*/
	public BinaryOperator<List<T>> combiner() {
		return (list1, list2) -> {
			list1.addAll(list2);
			return list1;
		};
	}

	@Override
	/*항등함수 - 입력된 형태로 출력한다.*/
	public Function<List<T>, List<T>> finisher() {
		return Function.identity();
	}

	@Override
	/*컬렉터의 플래그 설정*/
	public Set<Characteristics> characteristics() {
		return Collections.unmodifiableSet(EnumSet.of(Collector.Characteristics.IDENTITY_FINISH, Collector.Characteristics.CONCURRENT));
		/*
		 * UNORDERED : 순서에 영향없이
		 * CONCURRENT : 다중 스레드에서 동시에 accumulator를 호출, 병렬 리듀싱을 수행
		 * IDENTITY_FINISH : Function<A, R> finisher()메서드의 입력(A)과 출력(R)이 동일하다.
		 */
	}
	
}
