package modernJava.chapter09.ex07;

public class SpellCheckerProcessing extends ProcessingObject<String> {

	@Override
	protected String handleWork(String text) {
		return text.replaceAll("labda", "lambda");
	}

}
