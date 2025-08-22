package com.example.demo.chain;

import com.example.demo.model.notification.Notification;

public class NoHandleStep<T extends Notification> implements IElementChainable<T> {
    @Override
    public void setNext(IElementChainable<T> step) {}
    @Override
    public void handle(T event) {}
}