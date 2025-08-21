package com.example.demo.observable;

public interface IGenericObserver<T> {
  void notify(T t);
}
