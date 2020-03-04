package modernJava.chapter09.ex01;

public class Ex01 {
	public static void main(String[] args) {
		Runnable r1 = new Runnable() {	//익명구현객체
			@Override
			public void run() {
				System.out.println("Hello");
			}
		};
		Runnable r2 = () -> System.out.println("Hello");	//람다식
		
		doSomething(new Task() {	//익명구현객체
			@Override
			public void execute() {
				System.out.println("Danger!");
			}
		});
		doSomething((Task)()-> System.out.println("Danger!"));	//Runnable 인지 Task 인지 구별을 위해 캐스팅함
	}
	
	public static void doSomething(Runnable r) {
		r.run();
	}
	public static void doSomething(Task r) {
		r.execute();
	}
	
	interface Task {
		public void execute();
	}
}
