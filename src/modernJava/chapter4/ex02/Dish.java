package modernJava.chapter4.ex02;

public class Dish {
	private String name;
	private int calories;
	
	public Dish() {
		this("추천메뉴", 1000);
	}
	
	public Dish(String name, int calories) {
		this.name = name;
		this.calories = calories;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public int getCalories() {
		return calories;
	}
	
	public void setCalories(int calories) {
		this.calories = calories;
	}
}
