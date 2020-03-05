package modernJava.chapter09.ex06;

public interface Subject {
	void registerObserver(Observer o);
	void notifyObservers(String tweet);
}
