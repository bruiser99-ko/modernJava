package modernJava.chapter09.ex06;

public class Ex06 {
	public static void main(String[] args) {
		/*
		 * 객체 지향 디자인 패턴 리팩터링 - 3. 옵저버
		 * 어떤 이벤트가 발생했을 때 한 객체(주제)가 다른 객체 리스트(옵저버)에
		 * 자동으로 알림을 보내야 하는 상황에서 사용
		 */
		
		Feed f = new Feed();
		f.registerObserver(new NYTimes());
		f.registerObserver(new Guardian());
		f.registerObserver(new LeMonde());
		f.notifyObservers("the queen said ger");
		
		/* 람다식 */
		f.registerObserver(tweet -> {
			if(tweet != null && tweet.contains("korea")) {
				System.out.println("korea news... " + tweet);
			}
		});
	}
}
