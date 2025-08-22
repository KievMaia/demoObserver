package com.example.demo.chain.steps.commonsteps;

import com.example.demo.chain.AbstractStep;
import com.example.demo.model.event.DefaultEvent;
import com.example.demo.model.event.EventMetadata;
import com.example.demo.model.event.ObserverEventTypeEnum;
import com.example.demo.model.notification.CommonNotification;
import com.example.demo.observable.GenericSubject;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;


@Slf4j
public class PersistenceStep extends AbstractStep<CommonNotification> {

    private final GenericSubject<DefaultEvent> genericSubject;

    private final Function<CommonNotification, List<ObserverEventTypeEnum>> eventSequenceProvider;

    public PersistenceStep(GenericSubject<DefaultEvent> genericSubject,
                           Function<CommonNotification, List<ObserverEventTypeEnum>> eventSequenceProvider) {
        this.genericSubject = genericSubject;
        this.eventSequenceProvider = eventSequenceProvider;
    }

    @Override
    protected Optional<CommonNotification> handleAndApplyNext(CommonNotification event) {
        var eventsToEmit = eventSequenceProvider.apply(event);
        log.info("Persiste os dados com eventos: {}", eventsToEmit);

        for (var type : eventsToEmit) {
            this.sendEvent(type, event);
        }

        return Optional.of(event);
    }

    private void sendEvent(ObserverEventTypeEnum type, CommonNotification notification) {
        genericSubject.eventEmmit(new DefaultEvent(new EventMetadata(type), notification));
    }

    @Override
    protected void handleException(Exception e, CommonNotification event) {
        log.error("Erro ao persistir CommonNotification {}", event, e);
    }
}