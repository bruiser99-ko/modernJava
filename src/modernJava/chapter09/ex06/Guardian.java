package modernJava.chapter09.ex06;

public class Guardian implements Observer {

	@Override
	public void notify(String tweet) {
		if(tweet != null && tweet.contains("queen")) {
			System.out.println("Yet more news form London... " + tweet);
		}
	}

}
