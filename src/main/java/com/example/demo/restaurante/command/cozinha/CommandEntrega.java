package com.example.demo.restaurante.command.cozinha;

import com.example.demo.model.event.EventGeral;
import com.example.demo.observable.GenericSubject;
import com.example.demo.restaurante.command.common.CommandIGeneric;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.example.demo.model.event.ObserverEventTypeEnum.EVENT_TYPE_PEDIDO_ENTREGA;

@Slf4j
@Component
@Getter
@Setter
public class CommandEntrega extends CommandIGeneric<EventGeral> {

    private final GenericSubject<EventGeral> linkPaymentSubject;

    public CommandEntrega(final GenericSubject<EventGeral> linkPaymentSubject) {
        super(List.of(EVENT_TYPE_PEDIDO_ENTREGA));
        this.linkPaymentSubject = linkPaymentSubject;
        this.linkPaymentSubject.subscribe(this);
    }

    @Override
    public void execute(EventGeral eventGeral) {
        log.info("Pedido entregue ao cliente");
    }
}
