package com.example.demo.command.optin;

import com.example.demo.model.event.DefaultEvent;
import com.example.demo.observable.GenericSubject;
import com.example.demo.command.common.CommandIGeneric;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.example.demo.model.event.ObserverEventTypeEnum.EVENT_TYPE_SAP_PROCESSING;

@Slf4j
@Component
@Getter
@Setter
public class CommandSAPProcessing extends CommandIGeneric<DefaultEvent> {

    private final GenericSubject<DefaultEvent> linkPaymentSubject;

    public CommandSAPProcessing(final GenericSubject<DefaultEvent> linkPaymentSubject) {
        super(List.of(EVENT_TYPE_SAP_PROCESSING));
        this.linkPaymentSubject = linkPaymentSubject;
        this.linkPaymentSubject.subscribe(this);
    }

    @Override
    public void execute(DefaultEvent defaultEvent) {
        log.info("Recebe o evento {}", defaultEvent.getEventMetadata().eventType());
        log.info("Envia para a fila SAP");
    }
}
