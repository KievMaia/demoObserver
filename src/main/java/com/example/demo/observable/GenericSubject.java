package com.example.demo.observable;

import java.util.ArrayList;
import java.util.List;

public abstract class GenericSubject<T> {
  private final List<IGenericObserver<T>> observers;

  protected GenericSubject() {this.observers = new ArrayList<>();}

  public void subscribe(IGenericObserver<T> observer) {observers.add(observer);}

  public void eventEmmit(T event) {notifyAll(event);}

  private void notifyAll(T state) {observers.forEach(observer -> observer.notify(state));}
}
