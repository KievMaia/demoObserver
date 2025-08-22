package com.example.demo.service;

import com.example.demo.model.event.DefaultEvent;
import com.example.demo.model.event.EventMetadata;
import com.example.demo.model.notification.cartao.CardAuthorizationNotification;
import com.example.demo.model.notification.eef.EEFAuthorizationNotification;
import com.example.demo.observable.GenericSubject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.example.demo.model.event.ObserverEventTypeEnum.EVENT_TYPE_OPTIN_OR_OPTOUT_PROCESS;

@Slf4j
@Service
public class EEFAuthorizationService {

    private final GenericSubject<DefaultEvent> eventNotificationGenericSubject;

    public EEFAuthorizationService(GenericSubject<DefaultEvent> eventNotificationGenericSubject) {
        this.eventNotificationGenericSubject = eventNotificationGenericSubject;
    }

    public void process(EEFAuthorizationNotification notification) {
        log.info("Inicia processo de autorização");
        this.sendOptInProcess(notification);
    }

    private void sendOptInProcess(EEFAuthorizationNotification notification) {
        this.eventNotificationGenericSubject.eventEmmit(
                new DefaultEvent(
                        new EventMetadata(EVENT_TYPE_OPTIN_OR_OPTOUT_PROCESS),
                        notification)
        );
    }
}
