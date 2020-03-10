package thisisjava.chapter11.ex01;

import java.util.Date;

public class Ex03 {
	public static void main(String[] args) {
		Object obj1 = new Object();
		Date obj2 = new Date();
		System.out.println(obj1.toString());
		System.out.println(obj2.toString());	//Date객체는 toString() 메소드가 재정의되어 있다.
		
		SmartPhone sp = new SmartPhone("삼성", "타이젠");
		String strObj = sp.toString();
		System.out.println(strObj);
		System.out.println(sp);
	}
	
	/*
	 * 객체의 내부 정보를 표시하기 위해 toString() 메서드를 재정의한다.
	 */
}

class SmartPhone {
	private String company;
	private String os;
	
	public SmartPhone(String company, String os) {
		this.company = company;
		this.os = os;
	}
	
	@Override
	public String toString() {
		return company + ", " + os;
	}
}