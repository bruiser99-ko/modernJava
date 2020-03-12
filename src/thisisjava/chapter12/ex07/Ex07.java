package thisisjava.chapter12.ex07;

import java.util.Map;
import java.util.Set;

public class Ex07 {
	public static void main(String[] args) {
		Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();
		Set<Thread> threads = map.keySet();
		for(Thread t: threads) {
			System.out.print(t.getName());
			System.out.print(t.isDaemon()?"(데몬): ":"(주): ");
			System.out.println(t.getThreadGroup());
		}
	}
}
