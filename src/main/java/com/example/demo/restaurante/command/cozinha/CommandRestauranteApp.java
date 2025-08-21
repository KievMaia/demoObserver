package com.example.demo.restaurante.command.cozinha;

import com.example.demo.restaurante.command.common.CommandIGeneric;
import com.example.demo.model.event.EventGeral;
import com.example.demo.model.event.ObserverEventTypeEnum;
import com.example.demo.observable.GenericSubject;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.example.demo.model.event.ObserverEventTypeEnum.EVENT_TYPE_PEDIDO_APLICATIVO;

@Slf4j
@Component
@Getter
@Setter
public class CommandRestauranteApp extends CommandIGeneric<EventGeral> {

    private final GenericSubject<EventGeral> linkPaymentSubject;

    public CommandRestauranteApp(final GenericSubject<EventGeral> linkPaymentSubject) {
        super(List.of(EVENT_TYPE_PEDIDO_APLICATIVO));
        this.linkPaymentSubject = linkPaymentSubject;
        this.linkPaymentSubject.subscribe(this);
    }

    @Override
    public void execute(EventGeral eventGeral) {
        log.info("Recebe o evento {}", eventGeral.getEventMetadata().eventType());
        log.info("Anota o pedido");
        this.sendNewEvent(eventGeral);
    }

    private void sendNewEvent(EventGeral eventGeral) {
        log.info("Sending new event {}", ObserverEventTypeEnum.EVENT_TYPE_PEDIDO_COZINHA);
        this.linkPaymentSubject.eventEmmit(
                buildNextEventCheckoutLinkEvent(
                        eventGeral, ObserverEventTypeEnum.EVENT_TYPE_PEDIDO_COZINHA));
    }
}
