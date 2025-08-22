package com.example.demo.command.optin;

import com.example.demo.command.common.CommandIGeneric;
import com.example.demo.model.event.DefaultEvent;
import com.example.demo.observable.GenericSubject;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.example.demo.model.event.ObserverEventTypeEnum.EVENT_TYPE_DATA_PERSISTENCE;
import static com.example.demo.model.event.ObserverEventTypeEnum.EVENT_TYPE_SEND_DATALAKE;

@Slf4j
@Component
@Getter
@Setter
public class CommandDatalake extends CommandIGeneric<DefaultEvent> {

    private final GenericSubject<DefaultEvent> linkPaymentSubject;

    public CommandDatalake(final GenericSubject<DefaultEvent> linkPaymentSubject) {
        super(List.of(EVENT_TYPE_SEND_DATALAKE));
        this.linkPaymentSubject = linkPaymentSubject;
        this.linkPaymentSubject.subscribe(this);
    }

    @Override
    public void execute(DefaultEvent defaultEvent) {
        log.info("Recebe o evento {}", defaultEvent.getEventMetadata().eventType());
        log.info("Envia o evento para o Datalake");
        this.sendNewEvent(defaultEvent);
    }

    private void sendNewEvent(DefaultEvent defaultEvent) {
        log.info("Sending new event {}", EVENT_TYPE_DATA_PERSISTENCE);
        this.linkPaymentSubject.eventEmmit(buildNextEvent(defaultEvent, EVENT_TYPE_DATA_PERSISTENCE));
    }
}
