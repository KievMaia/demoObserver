package com.example.demo.cartao.service;

import com.example.demo.model.event.OptInEvent;
import com.example.demo.model.event.EventMetadata;
import com.example.demo.model.notification.cartao.CardOptInNotification;
import com.example.demo.observable.GenericSubject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.example.demo.model.event.ObserverEventTypeEnum.EVENT_TYPE_OPTIN_PROCESS;
import static com.example.demo.model.event.ObserverEventTypeEnum.EVENT_TYPE_OPTOUT_PROCESS;

@Slf4j
@Service
public class AuthorizationService {

    private final GenericSubject<OptInEvent> eventCheckoutLinkNotificationGenericSubject;

    public AuthorizationService(GenericSubject<OptInEvent> eventCheckoutLinkNotificationGenericSubject) {
        this.eventCheckoutLinkNotificationGenericSubject = eventCheckoutLinkNotificationGenericSubject;
    }

    public void process(CardOptInNotification notification) {
        log.info("Inicia processo de autorização");
        if (notification.getCardOptin().getAuthorization().equals("optin")) {
            this.sendOptInProcess(notification);
        }
        this.sendOptOutProcess(notification);
    }

    private void sendOptInProcess(CardOptInNotification notification) {
        this.eventCheckoutLinkNotificationGenericSubject.eventEmmit(
                new OptInEvent(
                        new EventMetadata(EVENT_TYPE_OPTIN_PROCESS),
                        notification)
        );
    }

    private void sendOptOutProcess(CardOptInNotification notification) {
        this.eventCheckoutLinkNotificationGenericSubject.eventEmmit(
                new OptInEvent(
                        new EventMetadata(EVENT_TYPE_OPTOUT_PROCESS),
                        notification)
        );
    }
}
