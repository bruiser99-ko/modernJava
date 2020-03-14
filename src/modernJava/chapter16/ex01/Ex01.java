package modernJava.chapter16.ex01;

public class Ex01 {
	public static void main(String[] args) {
		System.out.println(City.SEOUL);
		System.out.println(City.SEOUL.getPop());
	}
}

enum City {
	SEOUL(200), BUSAN(100), JEJU(50);
	int pop;
	City(int pop) {
		this.pop = pop;
	}
	public int getPop() {
		return pop;
	}
}
