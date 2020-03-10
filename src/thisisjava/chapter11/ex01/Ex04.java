package thisisjava.chapter11.ex01;
/*
 * clone() 메소드는 얉은 복사이므로 재정의를 통해 깊은 복사로 변경해야 한다.
 */
public class Ex04 {
	public static void main(String[] args) {
		MemberInfo original = new MemberInfo("blue", "홍길동", "12345", new int[]{90, 90}, 25, true);
		MemberInfo cloned = original.getMember();
		
		System.out.println("[[original]]");
		System.out.println(original);
		System.out.println(original.hashCode());
		System.out.println();
		System.out.println("[[cloned]]");
		System.out.println(cloned);
		System.out.println(cloned.hashCode());
		System.out.println();
		
		cloned.setPassword("56789");
		cloned.setScore(new int[] {100,100});
		System.out.println("[[original]]");
		System.out.println(original);
		System.out.println(original.hashCode());
		System.out.println();
		System.out.println("[[cloned]]");
		System.out.println(cloned);
		System.out.println(cloned.hashCode());
	}
}

class MemberInfo implements Cloneable {	//clone() 메서드를 사용하려면 Cloneable을 구현해야 한다.
	private String id;
	private String name;
	private String password;
	private int[] score;
	private int age;
	private boolean adult;
	public MemberInfo(String id, String name, String password, int[] score, int age, boolean adult) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.score = score;
		this.age = age;
		this.adult = adult;
	}
	
	public MemberInfo getMember() {
		MemberInfo cloned = null;
		try {
			cloned = (MemberInfo) clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return cloned;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setScore(int[] score) {
		this.score = score;
	}
	
	@Override
		public String toString() {
			return "id: " + id + "\nname: " + name + "\npassword: " + password + "\nscore: " + score[0] + ", " + score[1] + "\nage: " + age + "\nadult: " + adult; 
		}
	
}