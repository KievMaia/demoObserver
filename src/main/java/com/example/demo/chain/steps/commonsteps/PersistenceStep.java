package com.example.demo.chain.steps.commonsteps;

import com.example.demo.chain.AbstractStep;
import com.example.demo.model.event.DefaultEvent;
import com.example.demo.model.event.EventMetadata;
import com.example.demo.model.event.ObserverEventTypeEnum;
import com.example.demo.model.notification.CommonNotification;
import com.example.demo.observable.GenericSubject;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static com.example.demo.model.event.ObserverEventTypeEnum.EVENT_TYPE_CSU_PROCESSING;
import static com.example.demo.model.event.ObserverEventTypeEnum.EVENT_TYPE_SAP_PROCESSING;
import static com.example.demo.model.event.ObserverEventTypeEnum.EVENT_TYPE_SEND_DATALAKE;

@Slf4j
@Component
public class PersistenceStep extends AbstractStep<CommonNotification> {

    private final GenericSubject<DefaultEvent> eventNotificationGenericSubject;

    private List<ObserverEventTypeEnum> eventSequence = List.of();

    public PersistenceStep(GenericSubject<DefaultEvent> eventNotificationGenericSubject,
                           List<ObserverEventTypeEnum> eventSequence) {
        this.eventNotificationGenericSubject = eventNotificationGenericSubject;
        this.eventSequence = eventSequence;
    }

    @Override
    protected Optional<CommonNotification> handleAndApplyNext(CommonNotification event) throws Exception {
        log.info("Persiste os dados");

        Stream.of(EVENT_TYPE_SEND_DATALAKE, EVENT_TYPE_CSU_PROCESSING, EVENT_TYPE_SAP_PROCESSING)
                .forEach(type -> this.sendEvent(type, event));

        return Optional.empty();
    }

    private void sendEvent(ObserverEventTypeEnum eventType, CommonNotification notification) {
        this.eventNotificationGenericSubject.eventEmmit(
                new DefaultEvent(new EventMetadata(eventType), notification)
        );
    }

    @Override
    protected void handleException(Exception e, CommonNotification event) {

    }
}