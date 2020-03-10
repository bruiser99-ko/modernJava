package thisisjava.chapter11.ex01;

public class Ex01 {
	/* Object 클래스 */
	public static void main(String[] args) {
		Object obj1 = new Object();
		Object obj2 = new Object();
		
		boolean result1 = obj1.equals(obj2);
		boolean result2 = obj1 == obj2;
		
		System.out.println(result1 + " : " + result2);
		
		Member member1 = new Member("blue");
		Member member2 = new Member("blue");
		Member member3 = new Member("red");
		
		/* 클래스에서 equals()메소드를 재정의함 */
		if(member1.equals(member2)) {
			System.out.println("멤버1과 멤버2는 같음");
		} else {
			System.out.println("멤버1과 멤버2는 다름");
		}
		if(member1.equals(member3)) {
			System.out.println("멤버1과 멤버3는 같음");
		} else {
			System.out.println("멤버1과 멤버3는 다름");
		}
	}
	
}

class Member {
	public String id;
	public Member(String id) {
		this.id = id;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member member = (Member) obj;
			if(id.equals(member.id)) {
				return true;
			}
		}
		return false;
	}
}

/*
 * equals는 기본적으로 번지를 비교한다.
 * String의 경우에는 논리적 비교(값비교)를 하는데
 * 메서드를 오버라이딩해야만 한다.
 */ 