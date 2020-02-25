package modernJava.chapter3;

public class Ex01 {
	public static void process(Runnable r) {
		r.run();
	}
	
	public static void main(String[] args) {
		process(()->System.out.println("람다테스트"));
	}
}
