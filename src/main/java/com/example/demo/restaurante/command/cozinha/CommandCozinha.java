package com.example.demo.restaurante.command.cozinha;

import com.example.demo.model.event.EventGeral;
import com.example.demo.model.event.ObserverEventTypeEnum;
import com.example.demo.observable.GenericSubject;
import com.example.demo.restaurante.command.common.CommandIGeneric;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.example.demo.model.event.ObserverEventTypeEnum.EVENT_TYPE_PEDIDO_COZINHA;

@Slf4j
@Component
@Getter
@Setter
public class CommandCozinha extends CommandIGeneric<EventGeral> {

    private final GenericSubject<EventGeral> linkPaymentSubject;
    
    public CommandCozinha(final GenericSubject<EventGeral> linkPaymentSubject) {
        super(List.of(EVENT_TYPE_PEDIDO_COZINHA));
        this.linkPaymentSubject = linkPaymentSubject;
    }

    @Override
    public void execute(EventGeral eventGeral) {
        log.info("Prepara o prato do pedido");
        this.sendNewEvent(eventGeral);
    }

    private void sendNewEvent(EventGeral eventGeral) {
        log.info("Enviando um novo evento {}", ObserverEventTypeEnum.EVENT_TYPE_PEDIDO_ENTREGA);
        this.linkPaymentSubject.eventEmmit(
                buildNextEventCheckoutLinkEvent(
                        eventGeral, ObserverEventTypeEnum.EVENT_TYPE_PEDIDO_ENTREGA));
    }
}
