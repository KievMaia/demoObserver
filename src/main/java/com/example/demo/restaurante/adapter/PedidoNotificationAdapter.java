package com.example.demo.restaurante.adapter;

import com.example.demo.model.Pedido;
import com.example.demo.model.notification.pedido.PedidoNotification;

public class PedidoNotificationAdapter {

    public static PedidoNotification toPedidoNotification(Pedido pedido) {
        return PedidoNotification.builder()
                .pedido(pedido)
                .build();
    }
}
