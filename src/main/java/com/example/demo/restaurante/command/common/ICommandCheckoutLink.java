package com.example.demo.restaurante.command.common;

public interface ICommandCheckoutLink<T> {

  void execute(T t);
}
