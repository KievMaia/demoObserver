package com.example.demo.chain;

import com.example.demo.model.notification.Notification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;

import java.util.Optional;

@Slf4j
public abstract class AbstractStep<T extends Notification> implements IElementChainable<T> {

    private IElementChainable<T> next;

    @Override
    public void setNext(IElementChainable<T> step) {
        this.next = step;
    }

    @Override
    public void handle(T event) {
        var watch = new StopWatch();
        watch.start();
        try {
            handleAndApplyNext(event).ifPresentOrElse(
                    next::handle,
                    () -> next.handle(event)
            );
        } catch (Exception e) {
            handleException(e, event);
        } finally {
            watch.stop();
            log.info("Execution time for {} step call: {} ms",
                    this.getClass().getSimpleName(),
                    watch.getTotalTimeMillis());
        }
    }

    protected abstract Optional<T> handleAndApplyNext(T event) throws Exception;

    protected abstract void handleException(Exception e, T event);
}
