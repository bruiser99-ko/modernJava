package modernJava.chapter09.ex07;

public class HeaderTextProcessing extends ProcessingObject<String> {

	@Override
	protected String handleWork(String text) {
		return "From Raoul, Mario and Alan: " + text;
	}

}
