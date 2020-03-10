package thisisjava.chapter11.ex01;

import java.util.HashMap;

public class Ex02 {
	public static void main(String[] args) {
		HashMap<Key, String> hashMap = new HashMap<Key, String>();
		hashMap.put(new Key(1), "홍길동");
		
		String value = hashMap.get(new Key(1));
		System.out.println(value);
		
		/*
		 * 새로 생성한 두 객체는 1이라는 값을 가져도 주소가 다르므로 다른 객체다.
		 * 이것을 같은 객체로 인식시키기 위해서는 hashCode() 메서드를 재정의해야 한다.
		 * 같은 객체인지 검사시에 먼저 hashCode를 검사하고 equals를 검사한다.
		 */
	}
}

class Key {
	public int number;
	
	public Key(int number) {
		this.number = number;
	}
	
	@Override
	public boolean equals(Object obj) {
		System.out.println("equals()");
		if(obj instanceof Key) {
			Key compareKey = (Key) obj;
			if(this.number == compareKey.number) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		System.out.println("hashCode()");
		return number;
	}
}