package modernJava.chapter09.ex05;

public class Ex05 {
	public static void main(String[] args) {
		/* 
		 * 객체 지향 디자인 패턴 리팩터링 - 2. 템플릿 메서드
		 * 알고리즘을 사용할 때 수정이 필요한 상황에서 사용
		 */
		OnlineBankingLambda bank = new OnlineBankingLambda() {

			@Override
			void makeCustomerHappy(Customer c) {
				// TODO Auto-generated method stub
				
			}};
		bank.processCustomer(1337, (OnlineBankingLambda.Customer c)->System.out.println("Hello "));
	}
}
