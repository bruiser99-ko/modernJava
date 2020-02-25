package modernJava.chapter3.ex05;

public class Apple {
	private int weight;

	public Apple() {
		this.weight = 100;
	}
	
	public Apple(int weight) {
		this.weight = weight;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
}
