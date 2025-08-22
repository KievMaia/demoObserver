package com.example.demo.cartao.command.common;

import com.example.demo.observable.IGenericObserver;

public interface ICommandIGenericGenerator<T>
    extends IGenericObserver<T>, ICommandGeral<T> {}
