package com.example.demo.cartao.command.optin;

import com.example.demo.model.event.OptInEvent;
import com.example.demo.observable.GenericSubject;
import com.example.demo.cartao.command.common.CommandIGeneric;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.example.demo.model.event.ObserverEventTypeEnum.EVENT_TYPE_CSU_PROCESSING;
import static com.example.demo.model.event.ObserverEventTypeEnum.EVENT_TYPE_SAP_PROCESSING;
import static com.example.demo.model.event.ObserverEventTypeEnum.EVENT_TYPE_SEND_DATALAKE;

@Slf4j
@Component
@Getter
@Setter
public class CommandCSUProcessing extends CommandIGeneric<OptInEvent> {

    private final GenericSubject<OptInEvent> linkPaymentSubject;
    
    public CommandCSUProcessing(final GenericSubject<OptInEvent> linkPaymentSubject) {
        super(List.of(EVENT_TYPE_CSU_PROCESSING));
        this.linkPaymentSubject = linkPaymentSubject;
        this.linkPaymentSubject.subscribe(this);
    }

    @Override
    public void execute(OptInEvent optInEvent) {
        log.info("Envia o evento para o CSU");
        this.sendNewEvent(optInEvent);
    }

    private void sendNewEvent(OptInEvent optInEvent) {
        log.info("Enviando um novo evento {}", EVENT_TYPE_SAP_PROCESSING);
        this.linkPaymentSubject.eventEmmit(buildNextEvent(optInEvent, EVENT_TYPE_SAP_PROCESSING));
    }
}
