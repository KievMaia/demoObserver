package com.example.demo.cartao.command.optin;

import com.example.demo.cartao.command.common.CommandIGeneric;
import com.example.demo.model.event.OptInEvent;
import com.example.demo.observable.GenericSubject;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.example.demo.model.event.ObserverEventTypeEnum.EVENT_TYPE_DATA_PERSISTENCE;

@Slf4j
@Component
@Getter
@Setter
public class CommandDataPersistence extends CommandIGeneric<OptInEvent> {

    private final GenericSubject<OptInEvent> linkPaymentSubject;

    public CommandDataPersistence(final GenericSubject<OptInEvent> linkPaymentSubject) {
        super(List.of(EVENT_TYPE_DATA_PERSISTENCE));
        this.linkPaymentSubject = linkPaymentSubject;
        this.linkPaymentSubject.subscribe(this);
    }

    @Override
    public void execute(OptInEvent optInEvent) {
        log.info("Recebe o evento {}", optInEvent.getEventMetadata().eventType());
        log.info("Persiste os dados necessários");
    }
}
