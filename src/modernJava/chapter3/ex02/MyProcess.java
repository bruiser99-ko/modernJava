package modernJava.chapter3.ex02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MyProcess {
	/* 기본 코드: 한 줄 출력 코드 */
	public String processFile() throws IOException {
		try(BufferedReader br = new BufferedReader(new FileReader("C:/eclipse-workspace/java/modernJava/src/modernJava/chapter3/data.txt"))) {
			return br.readLine();
		}
	}
	
	/* 한 줄 출력하는 부분을 파라미터화 */
	public String processFile(BufferedReaderProcessor p) throws IOException {
		try(BufferedReader br = new BufferedReader(new FileReader("C:/eclipse-workspace/java/modernJava/src/modernJava/chapter3/data.txt"))) {
			return p.process(br);
		}
	}
}
