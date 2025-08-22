package com.example.demo.cartao.command.optin;

import com.example.demo.cartao.command.common.CommandIGeneric;
import com.example.demo.model.event.OptInEvent;
import com.example.demo.model.event.ObserverEventTypeEnum;
import com.example.demo.observable.GenericSubject;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.example.demo.model.event.ObserverEventTypeEnum.EVENT_TYPE_CSU_PROCESSING;
import static com.example.demo.model.event.ObserverEventTypeEnum.EVENT_TYPE_OPTIN_PROCESS;

@Slf4j
@Component
@Getter
@Setter
public class CommandOptInValidations extends CommandIGeneric<OptInEvent> {

    private final GenericSubject<OptInEvent> linkPaymentSubject;

    public CommandOptInValidations(final GenericSubject<OptInEvent> linkPaymentSubject) {
        super(List.of(EVENT_TYPE_OPTIN_PROCESS));
        this.linkPaymentSubject = linkPaymentSubject;
        this.linkPaymentSubject.subscribe(this);
    }

    @Override
    public void execute(OptInEvent optInEvent) {
        log.info("Recebe o evento {}", optInEvent.getEventMetadata().eventType());
        log.info("Efetua as validações");
        this.sendNewEvent(optInEvent);
    }

    private void sendNewEvent(OptInEvent optInEvent) {
        log.info("Sending new event {}", EVENT_TYPE_CSU_PROCESSING);
        this.linkPaymentSubject.eventEmmit(buildNextEvent(optInEvent, EVENT_TYPE_CSU_PROCESSING));
    }
}
