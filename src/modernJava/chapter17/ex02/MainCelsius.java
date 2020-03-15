package modernJava.chapter17.ex02;

import static modernJava.chapter17.ex02.TempObservable.getCelsiusTemperatures;

import io.reactivex.rxjava3.core.Observable;

public class MainCelsius {

  public static void main(String[] args) {
    Observable<TempInfo> observable = getCelsiusTemperatures("New York", "Chicago", "San Francisco");
    observable.subscribe(new TempObserver());

    try {
      Thread.sleep(10000L);
    }
    catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

}
