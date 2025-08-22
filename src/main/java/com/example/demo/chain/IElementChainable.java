package com.example.demo.chain;

import com.example.demo.model.notification.Notification;

import java.util.List;

public interface IElementChainable<T extends Notification> {
    void setNext(IElementChainable<T> step);
    void handle(T event);

    static <T extends Notification> IElementChainable<T> buildChain(
            List<IElementChainable<T>> elements,
            IElementChainable<T> lastElement) {

        if (elements.isEmpty()) {
            return lastElement;
        }

        for (int i = 0; i < elements.size(); i++) {
            var current = elements.get(i);
            var next = (i < elements.size() - 1) ? elements.get(i + 1) : lastElement;
            current.setNext(next);
        }
        return elements.get(0);
    }
}