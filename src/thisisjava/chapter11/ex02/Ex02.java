package thisisjava.chapter11.ex02;

import java.util.Properties;
import java.util.Set;

public class Ex02 {
	public static void main(String[] args) {
		Properties info = System.getProperties();
		Set<Object> keys = info.keySet();
		keys.stream().forEach(key->{
			Object value = info.get(key);
			System.out.println(key + " : " + value);
		});
	}
}
