package modernJava.chapter3.ex02;

import java.io.BufferedReader;
import java.io.IOException;

public interface BufferedReaderProcessor {
	String process(BufferedReader b) throws IOException;
}
