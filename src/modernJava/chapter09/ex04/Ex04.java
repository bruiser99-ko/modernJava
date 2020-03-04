package modernJava.chapter09.ex04;

public class Ex04 {
	public static void main(String[] args) {
		Ex04 me = new Ex04(); 
		Validator numericValidator = me.new Validator(me.new IsNumeric());
		System.out.println(numericValidator.validate("a"));
		System.out.println(numericValidator.validate("1"));
		
		Validator lowerCaseValidator = me.new Validator(me.new IsAllLowerCase());
		System.out.println(lowerCaseValidator.validate("1"));
		System.out.println(lowerCaseValidator.validate("A"));
		System.out.println(lowerCaseValidator.validate("a"));
		
		/* 람다식 */
		Validator numericValidator2 = me.new Validator(s->s.matches("\\d+"));
		Validator lowerCaseValidator2 = me.new Validator(s->s.matches("[a-z]+"));
		System.out.println(numericValidator2.validate("1"));
		System.out.println(lowerCaseValidator2.validate("a"));
	}
	
	/* 전략 - 한 유형의 알고리즘을 보유한 상태에서 런타임에 적절한 알고리즘을 선택하는 기법 */
	interface ValidationStrategy {
		boolean execute(String s);
	}
	
	class IsAllLowerCase implements ValidationStrategy {
		@Override
		public boolean execute(String s) {
			return s.matches("[a-z]+");
		}
	}
	
	class IsNumeric implements ValidationStrategy {
		@Override
		public boolean execute(String s) {
			return s.matches("\\d+");
		}
	}
	
	class Validator {
		private final ValidationStrategy strategy;
		
		public Validator(ValidationStrategy strategy) {
			this.strategy = strategy;
		}
		public boolean validate(String s) {
			return strategy.execute(s);
		}
		
	}
}
