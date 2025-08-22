package com.example.demo.command.optin;

import com.example.demo.model.event.DefaultEvent;
import com.example.demo.observable.GenericSubject;
import com.example.demo.command.common.CommandIGeneric;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.example.demo.model.event.ObserverEventTypeEnum.EVENT_TYPE_CSU_PROCESSING;
import static com.example.demo.model.event.ObserverEventTypeEnum.EVENT_TYPE_SAP_PROCESSING;

@Slf4j
@Component
@Getter
@Setter
public class CommandCSUProcessing extends CommandIGeneric<DefaultEvent> {

    private final GenericSubject<DefaultEvent> linkPaymentSubject;
    
    public CommandCSUProcessing(final GenericSubject<DefaultEvent> linkPaymentSubject) {
        super(List.of(EVENT_TYPE_CSU_PROCESSING));
        this.linkPaymentSubject = linkPaymentSubject;
        this.linkPaymentSubject.subscribe(this);
    }

    @Override
    public void execute(DefaultEvent defaultEvent) {
        log.info("Envia o evento para o CSU");
        this.sendNewEvent(defaultEvent);
    }

    private void sendNewEvent(DefaultEvent defaultEvent) {
        log.info("Enviando um novo evento {}", EVENT_TYPE_SAP_PROCESSING);
        this.linkPaymentSubject.eventEmmit(buildNextEvent(defaultEvent, EVENT_TYPE_SAP_PROCESSING));
    }
}
