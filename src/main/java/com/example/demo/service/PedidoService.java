package com.example.demo.service;

import com.example.demo.model.event.EventGeral;
import com.example.demo.model.event.EventMetadata;
import com.example.demo.model.notification.pedido.PedidoNotification;
import com.example.demo.observable.GenericSubject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.example.demo.model.event.ObserverEventTypeEnum.EVENT_TYPE_PEDIDO_APLICATIVO;

@Slf4j
@Service
public class PedidoService {

    private final GenericSubject<EventGeral> eventCheckoutLinkNotificationGenericSubject;

    public PedidoService(GenericSubject<EventGeral> eventCheckoutLinkNotificationGenericSubject) {
        this.eventCheckoutLinkNotificationGenericSubject = eventCheckoutLinkNotificationGenericSubject;
    }

    public void gerarPedido(PedidoNotification notification) {
        log.info("Pede no aplicativo");
        this.sendNewOrder(notification);
    }

    private void sendNewOrder(PedidoNotification notification) {
        this.eventCheckoutLinkNotificationGenericSubject.eventEmmit(
                new EventGeral(
                        new EventMetadata(EVENT_TYPE_PEDIDO_APLICATIVO),
                        notification)
        );
    }
}
