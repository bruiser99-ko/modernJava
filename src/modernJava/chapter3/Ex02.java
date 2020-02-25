package modernJava.chapter3;

import java.io.BufferedReader;
import java.io.IOException;

public class Ex02 {
	public static void main(String[] args) throws IOException {
		MyProcess mp = new MyProcess();
		String oneLine = mp.processFile((BufferedReader br)->br.readLine());
		String twoLine = mp.processFile((BufferedReader br)->br.readLine() + br.readLine());
		System.out.println(oneLine);
		System.out.println(twoLine);
	}
}
