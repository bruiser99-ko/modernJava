package modernJava.chapter17.ex02;

import static modernJava.chapter17.ex02.TempObservable.getTemperature;

import io.reactivex.rxjava3.core.Observable;

public class Main {

  public static void main(String[] args) {
    Observable<TempInfo> observable = getTemperature("New York");
    observable.subscribe(new TempObserver());

    try {
      Thread.sleep(10000L);
    }
    catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

}
