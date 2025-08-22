package com.example.demo.command.common;

import com.example.demo.observable.IGenericObserver;

public interface ICommandIGenericGenerator<T>
    extends IGenericObserver<T>, ICommandGeral<T> {}
