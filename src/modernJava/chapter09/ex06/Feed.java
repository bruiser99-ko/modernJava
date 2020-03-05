package modernJava.chapter09.ex06;

import java.util.ArrayList;
import java.util.List;

public class Feed implements Subject {
	private final List<Observer> observers = new ArrayList<Observer>();
	
	@Override
	public void registerObserver(Observer o) {
		this.observers.add(o);
	}

	@Override
	public void notifyObservers(String tweet) {
		observers.forEach(o -> o.notify(tweet));
	}

}
